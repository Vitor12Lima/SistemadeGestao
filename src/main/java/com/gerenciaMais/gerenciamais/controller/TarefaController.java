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
import com.gerenciaMais.gerenciamais.model.Tarefa;
import com.gerenciaMais.gerenciamais.repository.TarefaRepository;

@RestController
public class TarefaController {

	@Autowired
	private TarefaRepository tarefaRepository;

	@GetMapping("/tarefa")
	public Page<Tarefa> retorneTarefas(Pageable pageable) {
		return tarefaRepository.findAll(pageable);
	}

	@PostMapping("/tarefa")
	public Tarefa salvarTarefa(@Valid @RequestBody Tarefa tarefa) {
		return tarefaRepository.save(tarefa);
	}

	@PutMapping("/tarefa/{id}")
	public Tarefa atualizarTarefa(@PathVariable Integer id, @Valid @RequestBody Tarefa tarefaRequest) {
		return tarefaRepository.findById(id)
				.map(tarefa -> {
			tarefa.setDescricao(tarefaRequest.getDescricao());
			tarefa.setDataInicial(tarefaRequest.getDataInicial());
			tarefa.setDataTermino(tarefaRequest.getDataTermino());

			return tarefaRepository.save(tarefa);
		}).orElseThrow(() -> new ResourceNotFoundException("tarefa not found: " + id));
	}

	@DeleteMapping("/tarefa/{id}")
	public ResponseEntity<?> deletarTarefa(@PathVariable Integer id) {
		return tarefaRepository.findById(id)
				.map(tarefa -> {
			tarefaRepository.delete(tarefa);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new ResourceNotFoundException("tarefa not found: " + id));
	}

}
