//Fonte https://www.baeldung.com/spring-security-registration-i-forgot-my-password
//Fonte http://davifelipe.com.br/spring-boot-forgot-password
package com.oop.napi.api.controller;

import java.util.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.oop.napi.api.exceptionhandler.UserNotFoundException;
import com.oop.napi.domain.dto.ResetSenhaDTO;
import com.oop.napi.domain.dto.UsuarioDTOResponse;
import com.oop.napi.domain.email.Mailer;
import com.oop.napi.domain.email.MensagemEmail;
import com.oop.napi.domain.model.ResetSenhaToken;
import com.oop.napi.domain.services.ResetSenhaSaveValidator;
import com.oop.napi.domain.services.ResetSenhaTokenService;
import com.oop.napi.domain.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import com.oop.napi.domain.model.Usuario;
import com.oop.napi.domain.services.UsuarioService;
import com.oop.napi.domain.repository.UsuarioRepository;

import javax.validation.Valid;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private final Mailer mailer;

	@Autowired
	private final UsuarioRepository usuarioRepository;

	@Autowired
	private final PasswordEncoder encoder;

	@Autowired
	private MessageSource messages;

	@Autowired
	private ResetSenhaTokenService resetSenhaTokenService;

	@Autowired
	private UsuarioService usuarioService;

	@Value("360000000000000")
	private Long resetSenhaTokenExpirationMisiseg;

	public UsuarioController(Mailer mailer, UsuarioRepository usuarioRepository,
							 PasswordEncoder encoder, MessageSource messages,
							 ResetSenhaTokenService resetSenhaTokenService,
							 UsuarioService usuarioService) {
		this.mailer = mailer;
		this.usuarioRepository = usuarioRepository;
		this.encoder = encoder;
		this.messages = messages;
		this.resetSenhaTokenService = resetSenhaTokenService;
		this.usuarioService = usuarioService;
	}

	@GetMapping("/listar")
	public List<Usuario> listar() {

		return usuarioRepository.findAll();
	}

	@PostMapping("/adicionar")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario adicionar(@Valid @RequestBody Usuario usuario) {

		usuario.setSenha(encoder.encode(usuario.getSenha()));
		return usuarioRepository.save(usuario);
	}

	@DeleteMapping("excluir/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Long id) {

		if (!usuarioRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		usuarioRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}

	@PostMapping ("/esqueci-senha")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> enviarEmailUsuario(@Valid @RequestBody UsuarioDTOResponse dtoResponse) throws
			JsonProcessingException {

		Usuario achouUsuario = usuarioService.findByEmail(dtoResponse.getEmail());

		if (achouUsuario == null) {
			throw new UserNotFoundException("Erro ao tentar enviar o e-mail. Tente novamente.");
		}

		ResetSenhaToken resetSenhaToken = usuarioService.generateResetPasswordToken(achouUsuario);
		mailer.enviar(new MensagemEmail("Naruto themed API <oop.napi@gmail.com>",
				Arrays.asList(dtoResponse.getEmail()),
				"E-mail de recuperação de senha", "Olá!\n\n" +
				"Infelizmente eu ainda não funciono com front end :( \n" +
				"Para resetar sua senha acesse a URL [POST] http://localhost:8080/usuarios/resetar-senha " +
				"e informe seu token, sua nova senha e a confirmação dela.\n\n" +
				"Seu token é: " + resetSenhaToken.getToken()));

		return ResponseEntity.ok().body("Um e-mail foi enviado para o endereço fornecido. "+
			"Por favor, verifique o link e complete seu reset de senha.");
	}

	//erro
	@PostMapping("/resetar-senha")
	public ResponseEntity<?> resetarSenha(@Valid @RequestBody ResetSenhaDTO dto) {

		ResetSenhaToken resetSenhaToken = resetSenhaTokenService.findByToken(dto.getToken());

		if (resetSenhaToken == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST.value())
					.body("Erro ao resetar a senha.");
		}

		if (resetSenhaToken.isExpired(resetSenhaTokenExpirationMisiseg)) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST.value())
					.body("Token expirado.");
		}

		//problema tá aqui
		Usuario usuario = usuarioService.getUser(dto.getToken());
		usuario.setSenha(dto.getSenha());
		usuarioService.update(usuario);
		resetSenhaTokenService.update(resetSenhaToken);

		return ResponseEntity.ok().body("A senha foi alterada com sucesso.");
	}
}