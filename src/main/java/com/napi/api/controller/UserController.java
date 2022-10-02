package com.napi.api.controller;

import java.util.List;

import com.napi.domain.user.UserData;
import com.napi.domain.user.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

//import javax.validation.Valid;

@RestController
@RequestMapping(path = "oop-napi/register")
public class UserController {

	private final UserRepository usuarioRepository;
	private final PasswordEncoder encoder;

	public UserController(UserRepository usuarioRepository, PasswordEncoder encoder) {
		super();
		this.usuarioRepository = usuarioRepository;
		this.encoder = encoder;
	}

	@GetMapping("/listar")
	public List<UserData> listar() {
		return usuarioRepository.findAll();

	}

	@PostMapping("/adicionar")
	@ResponseStatus(HttpStatus.CREATED)
	public UserData adicionar(/*@Valid*/ @RequestBody UserData usuario) {
		usuario.setSenha(encoder.encode(usuario.getSenha()));
		return usuarioRepository.save(usuario);
	}

	@DeleteMapping("/excluir/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Long id) {
		if(!usuarioRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		usuarioRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/redefinir/{senha}")
	public ResponseEntity<Void> redefinirSenha(@PathVariable String senha){
		return ResponseEntity.accepted().build();
	}
}