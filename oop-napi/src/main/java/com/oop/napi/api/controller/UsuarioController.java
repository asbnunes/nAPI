package com.oop.napi.api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import com.oop.napi.domain.model.Usuario;
import com.oop.napi.domain.repository.UsuarioRepository;

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