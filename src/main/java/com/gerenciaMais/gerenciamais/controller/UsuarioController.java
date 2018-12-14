package com.gerenciaMais.gerenciamais.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gerenciaMais.gerenciamais.exception.ResourceNotFoundException;
import com.gerenciaMais.gerenciamais.model.Tarefa;
import com.gerenciaMais.gerenciamais.model.Usuario;
import com.gerenciaMais.gerenciamais.repository.UsuarioRepository;

@RestController
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@GetMapping("/usuario")
	public Page<Usuario> retorneUsuarios(Pageable pageable) {
		//return usuarioRepository.findAll(pageable);
		
		return usuarioRepository.findAll(pageable);
	}

	@PostMapping("/usuario")
	public Usuario salvarUsuario(@Valid @RequestBody Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	@PostMapping("usuario/{id}/adicionarTarefa")
	public Usuario adicionarTarefa(@PathVariable Integer id, @Valid @RequestBody Tarefa tarefa) {
		return usuarioRepository.findById(id).map(usuario -> {
			usuario.adicionarTarefa(tarefa);
			return usuarioRepository.save(usuario);
		}).orElseThrow(() -> new ResourceNotFoundException("tarefa not found: " + id));
	}
	
	@PostMapping("/login")
	public Usuario login(@RequestBody Map<String, String> params) {
		return usuarioRepository.findByEmailAndSenha(params.get("email"), params.get("senha"));
		
		
	}

	@PutMapping("/usuario/{id}")
	public Usuario atualizarUsuario(@PathVariable Integer id, @Valid @RequestBody Usuario usuarioRequest) {
		return usuarioRepository.findById(id).map(usuario -> {
			usuario.setNome(usuarioRequest.getNome());
			usuario.setEmail(usuarioRequest.getEmail());
			usuario.setSenha(usuarioRequest.getSenha());

			return usuarioRepository.save(usuario);
		}).orElseThrow(() -> new ResourceNotFoundException("usuario not found: " + id));
	}

	@DeleteMapping("/usuario/{id}")
	public ResponseEntity<?> deleteQuestion(@PathVariable Integer id) {
		return usuarioRepository.findById(id).map(usuario -> {
			usuarioRepository.delete(usuario);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new ResourceNotFoundException("usuario not found: " + id));
	}

	@GetMapping("/usuario/{id}")
	public Usuario retornaUsuarioId(@PathVariable Integer id) {
		return usuarioRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("usuario not found: " + id));

	}
	
	
}
