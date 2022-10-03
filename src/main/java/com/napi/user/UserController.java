/**
 * Andre Santoro, Gustavo Pedro Lima, Maisa Moreira
 *
 * 01/10/2022
 *
 * Esse programa foi feito para fins educativos, para a materia
 * de Programacaoo Orientada a Objetos, oferecida no Centro
 * Universitário IESB no periodo 2022.2, ministrada pelo professor
 * Kenniston Arraes.
 */
package com.napi.user;

import java.util.List;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Endpoints de usuario (users) da api.
 */
@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
	/* chama a interface repositório */
	private final UserRepository usuarioRepository;

	/* chama o codificador de senhas */
	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	/* Endpoint "Get" de /users */
	@GetMapping
	public List<UserData> listar() {
		return usuarioRepository.findAll();

	}

	/* Endpoint "Post" de /users. Retorna codigo especifico 201 CREATED */
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public UserData adicionar(@Valid @RequestBody UserData usuario) {
		usuario.setSenha(bCryptPasswordEncoder.encode(usuario.getSenha()));
		return usuarioRepository.save(usuario);
	}

	/* Endpoint "Delete" de /users/id */
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Long id) {
		if(!usuarioRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		usuarioRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}