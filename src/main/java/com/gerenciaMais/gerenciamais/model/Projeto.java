package com.gerenciaMais.gerenciamais.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

@Entity
public class Projeto {

	@Id
	@GeneratedValue
	private Integer id;
	@NotBlank
	private String nome;
	@OneToMany
	@NotBlank
	private List<Tarefa> tarefas;
	
	public Projeto() {
		
	}

	public Projeto(Integer id, @NotBlank String nome) {
		this.id = id;
		this.nome = nome;
		this.tarefas = new ArrayList<>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Tarefa> getTarefas() {
		return tarefas;
	}

	public void setTarefas(List<Tarefa> tarefas) {
		this.tarefas = tarefas;
	}

}
