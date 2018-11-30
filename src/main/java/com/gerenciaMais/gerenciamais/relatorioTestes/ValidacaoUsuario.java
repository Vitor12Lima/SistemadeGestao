package com.gerenciaMais.gerenciamais.relatorioTestes;

public class ValidacaoUsuario {

	public ValidacaoUsuario() {

	}

	public boolean validarUsuario(String nome, String email, String senha) {

		if (validarNome(nome) && validarEmail(email) && validarSenha(senha)) {
			return true;
		}

		return false;

	}

	public boolean validarNome(String nome) {

		if (validarNomeComLetrasMaiusculasOuMinusculas(nome) || validarNomeMaiorDoQueOitoLetras(nome)) {
			return true;
		}

		return false;
	}

	public boolean validarEmail(String email) {

		if (validarEmailComArrobaEComPonto(email)) {
			return true;
		}

		return false;

	}

	public boolean validarSenha(String senha) {

		if (validarSenhaComOMinimoDeOitoDigitos(senha) || validarSenhaComCaracteres(senha)) {
			return true;
		}

		return false;

	}
	
	///////////////////////////////

	public boolean validarNomeComLetrasMaiusculasOuMinusculas(String nome) {

		if (nome.matches("^[A-Z][a-z]* [[A-Z][a-z]]*")) {
			return true;
		}

		return false;

	}

	public boolean validarNomeMaiorDoQueOitoLetras(String nome) {

		if (nome.length() > 8) {
			return true;
		}

		return false;
	}

	public boolean validarNomeComAcentosEEspacos(String nome) {

		if (nome.matches("[a-zA-Z ]*") || nome.matches("[\\p{L}]+")) {
			return true;
		}

		return false;
	}

	public boolean validarEmailComArrobaEComPonto(String email) {

		/*
		 * if(email.matches("^[_A-Za-z0-9-\\\\+]+(\\\\.[_A-Za-z0-9-]+)*@\"\r\n" +
		 * "[A-Za-z0-9-]+(\\\\.[A-Za-z0-9]+)*(\\\\.[A-Za-z]{2,})$")) {
		 */

		if (email.matches("\\\\w+@\\\\w+\\\\.\\\\w{2,3}\\\\.\\\\w{2,3}")) {

			return true;
		}

		return false;
	}

	public boolean validarSenhaComOMinimoDeOitoDigitos(String senha) {

		if (senha.length() >= 8) {
			return true;
		}

		return false;
	}

	public boolean validarSenhaComCaracteres(String senha) {

		if (senha.matches("[A-Za-z0-9]+")) {
			return true;
		}

		return false;
	}

}
