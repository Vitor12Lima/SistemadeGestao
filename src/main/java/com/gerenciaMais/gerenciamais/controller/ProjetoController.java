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
import com.gerenciaMais.gerenciamais.model.Projeto;
import com.gerenciaMais.gerenciamais.repository.ProjetoRepository;

@RestController
public class ProjetoController {

	@Autowired
	private ProjetoRepository projetoRespository;

	@GetMapping("/projeto")
	public Page<Projeto> retorneUsuarios(Pageable pageable) {
		return projetoRespository.findAll(pageable);
	}

	@PostMapping("/projeto")
	public Projeto criarProjeto(@Valid @RequestBody Projeto projeto) {
		return projetoRespository.save(projeto);
	}

	@PutMapping("/projeto/{id}")
	public Projeto atualizarProjeto(@PathVariable Integer id, 
			@Valid @RequestBody Projeto projetoRequest) {
		return projetoRespository.findById(id)
				.map(projeto -> {
			projeto.setNome(projetoRequest.getNome());
			projeto.setTarefas(projetoRequest.getTarefas());

			return projetoRespository.save(projeto);
		}).orElseThrow(() -> new ResourceNotFoundException("projeto not found: " + id));
	}

	@DeleteMapping("/projeto/{id}")
	public ResponseEntity<?> deletarProjeto(@PathVariable Integer id) {
		return projetoRespository.findById(id)
				.map(projeto -> {
			projetoRespository.delete(projeto);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new ResourceNotFoundException("projeto not found: " + id));
	}

}
