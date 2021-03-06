package com.gerenciaMais.gerenciamais.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
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
	private String titulo;
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@NotBlank
	private List<Tarefa> tarefas = new ArrayList<>();

	public void adicionarTarefa(Tarefa tarefa) {
		this.tarefas.add(tarefa);
	}

	public Projeto(Integer id, @NotBlank String titulo) {
		this.id = id;
		this.titulo = titulo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return titulo;
	}

	public void setNome(String nome) {
		this.titulo = nome;
	}

	public List<Tarefa> getTarefas() {
		return tarefas;
	}

	public void setTarefas(List<Tarefa> tarefas) {
		this.tarefas.clear();
		this.tarefas.addAll(tarefas);
	}

}
