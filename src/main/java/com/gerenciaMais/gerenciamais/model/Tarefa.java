package com.gerenciaMais.gerenciamais.model;

import java.time.LocalDateTime;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Tarefa {

	@Id
	@GeneratedValue
	private Integer id;

	private LocalDateTime dataInicial;

	private LocalDateTime dataTermino;

	@NotBlank
	private String descricao;

	public Tarefa() {

	}

	public Tarefa(Integer id, LocalDateTime dataInicial, @NotBlank String descricao, LocalDateTime dataTermino) {
		super();
		this.id = id;
		this.dataInicial = dataInicial;
		this.descricao = descricao;
		this.dataTermino = dataTermino;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(LocalDateTime dataTermino) {
		this.dataTermino = dataTermino;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDateTime getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(LocalDateTime dataInicial) {
		this.dataInicial = dataInicial;
	}

}
