package com.gerenciaMais.gerenciamais.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

@Entity
public class Usuario {

	@Id
	@GeneratedValue
	private Integer id;
	@Column
	@NotBlank
	private String nome;
	@Column(unique = true)
	@NotBlank
	private String email;
	@Column
	@NotBlank
	private String senha;
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Tarefa> tarefas = new ArrayList<>();
	
	public void adicionarTarefa(Tarefa tarefa) {
		this.tarefas.add(tarefa);
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Tarefa> getTarefas() {
		return tarefas;
	}

	public void setTarefas(List<Tarefa> tarefas) {
		this.tarefas.clear();
		this.tarefas.addAll(tarefas);
	}

}
