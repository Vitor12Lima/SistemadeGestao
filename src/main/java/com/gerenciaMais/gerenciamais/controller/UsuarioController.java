package com.gerenciaMais.gerenciamais.controller;


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
import com.gerenciaMais.gerenciamais.model.Usuario;
import com.gerenciaMais.gerenciamais.repository.UsuarioRepository;

@RestController
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping("/usuario")
	public Page<Usuario> retorneUsuarios(Pageable pageable){
		return usuarioRepository.findAll(pageable);
	}
	
	@PostMapping("/usuario")
	public Usuario salvarUsuario(@Valid @RequestBody Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	@PutMapping("/usuario/{id}")
	public Usuario atualizarUsuario(@PathVariable Integer id,
            								@Valid @RequestBody Usuario usuarioRequest) {
		return usuarioRepository.findById(id)
				.map(usuario -> {
					usuario.setNome(usuarioRequest.getNome());
					usuario.setEmail(usuarioRequest.getEmail());
					usuario.setSenha(usuarioRequest.getSenha());
		
					return usuarioRepository.save(usuario);
		}).orElseThrow(() -> new ResourceNotFoundException("usuario not found: " + id));
	}
	
	@DeleteMapping("/familymember/{familyMemberId}")
	public ResponseEntity<?> deleteQuestion(@PathVariable Integer id){
		return usuarioRepository.findById(id)
				.map(usuario -> {
					usuarioRepository.delete(usuario);
					return ResponseEntity.ok().build();
				}).orElseThrow(() -> new ResourceNotFoundException("usuario not found: " + id));
	}
	

}
