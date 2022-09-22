package com.oop.napi.api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.oop.napi.domain.model.Usuario;
import com.oop.napi.domain.repository.UsuarioRepository;

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
	public Usuario adicionar(@RequestBody Usuario usuario) {
		usuario.setSenha(encoder.encode(usuario.getSenha()));
		return usuarioRepository.save(usuario);
	}

}
