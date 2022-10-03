package com.oop.napi.api.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.oop.napi.domain.email.Mailer;
import com.oop.napi.domain.email.MensagemEmail;
//import com.oop.napi.domain.email.SpringEmailMain;
import com.oop.napi.domain.model.ResetPasswordToken;
import lombok.val;
import org.hibernate.ObjectNotFoundException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import com.oop.napi.domain.model.Usuario;
import com.oop.napi.domain.repository.UsuarioRepository;

import javax.mail.Message;
import javax.validation.Valid;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	private final UsuarioRepository usuarioRepository;
	private final PasswordEncoder encoder;

	public UsuarioController(UsuarioRepository usuarioRepository, PasswordEncoder encoder) {
		super();
		this.usuarioRepository = usuarioRepository;
		this.encoder = encoder;
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
		if(!usuarioRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		usuarioRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
/*
	@PostMapping("/enviar-email")
	public ResponseEntity<?> findById(@Valid @RequestBody Usuario usuario) throws JsonProcessingException {
		Optional<Usuario> achouUsuario = usuarioRepository.findByEmail(usuario.getEmail());

		if(achouUsuario == null) {
			throw new ObjectNotFoundException("Usuário " + usuario.getNome() + " não encontrado.",
					"E-mail " + usuario.getEmail());
		}

		ResetPasswordToken resetPasswordToken = usuarioRepository.generateResetPasswordToken(achouUsuario);
		//emailService.ResetPasswordToken(resetPasswordToken);
		//enviar email:
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
                SpringEmailMain.class.getPackage().getName());

        Mailer mailer = applicationContext.getBean(Mailer.class);
        mailer.enviar(new MensagemEmail("Teste do napi <oop.napi@gmail.com>",
                Arrays.asList("Mais um teste do napi <oop.napi@gmail.com>"),
                "Pedido para resetar senha", "Olá! \n\n O envio do e-mail deu certo."));

        applicationContext.close();

        System.out.println("FOI!!!!!!!");
		//fim enviar email

		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Um e-mail foi enviado para o endereço fornecido.");
		stringBuilder.append("Clique no link enviado para redefinir sua senha.");

		return ResponseEntity.ok().build();
	}

	@PostMapping("/resetar-senha")
	public ResponseEntity<?> findById(@Valid @RequestBody MudarSenha) {
		ResetPasswordToken resetPasswordToken = serviceResetPassword.findByToken(dto.getToken());
		if(resetPasswordToken == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).body(
					new MessageDTO("Link inválido", "Erro ao resetar a senha", HttpStatus.BAD_REQUEST.value())
			);
		}

		Usuario usuario = resetPasswordToken.getUsername();
		usuario.setPassword(dto.getPassword());
		serviceUser.update(user);
		//limpar o token para que ele não possa ser usado mais de uma vez
		resetPasswordToken.setToken(null);
		serviceResetPassword.update(resetPasswordToken);

		return ResponseEntity.ok().body(new MessageDTO("A senha foi alterada", HttpStatus.OK.value()));
	}*/
}