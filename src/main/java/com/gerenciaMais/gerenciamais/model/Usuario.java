package com.gerenciaMais.gerenciamais.model;

import javax.persistence.*;
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

	public Usuario() {

	}

	public Usuario(Integer id, @NotBlank String nome, @NotBlank String email, @NotBlank String senha) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
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

}
