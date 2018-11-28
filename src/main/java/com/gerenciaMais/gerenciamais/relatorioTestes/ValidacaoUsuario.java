package com.gerenciaMais.gerenciamais.relatorioTestes;

import com.gerenciaMais.gerenciamais.model.Usuario;

public class ValidacaoUsuario {

	Usuario usuario = new Usuario();

	public boolean validarLoginUsuario(String nome, String email, String senha) {

		if (validarNome(nome) && validarEmail(email) && validarSenha(senha)) {
			return true;
		}

		return false;

	}

	public boolean validarNome(String nome) {

		nome = usuario.getNome();

		return nome.matches("^[A-Z][a-z]* [[A-Z][a-z]]*");
	}

	public boolean validarEmail(String email) {

		if (email.contains("@")) {

			return true;
		}

		return false;

	}

	public boolean validarSenha(String senha) {

		return true;

	}

}
