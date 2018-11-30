package com.gerenciaMais.gerenciamais.relatorioTestes;

public class ValidacaoUsuario {

	public boolean validarUsuario(String nome, String email, String senha) {

		if (validarNome(nome) && validarEmail(email) && validarSenha(senha)) {
			return true;
		}

		return false;

	}

	// ok
	public boolean validarNome(String nome) {

		if (validarNomeMaiorDoQueOitoLetras(nome) && validarNomeESobrenomeComAcentosEEspacos(nome)) {
			return true;
		}

		return false;
	}

	// ok
	public boolean validarEmail(String email) {

		if (validarEmailComArrobaEComPonto(email)) {
			return true;
		}

		return false;

	}

	public boolean naoValidarNomeComNumeros(String nome) {

		for (int i = 0; i < nome.length(); i++) {
			
			if (!Character.isAlphabetic((nome.charAt(i)))) {
				return false;
			}
		}

		return true;
	}

	// ok
	public boolean validarSenha(String senha) {

		if (validarSenhaComOMinimoDeOitoDigitos(senha) && validarSenhaComCaracteres(senha)) {
			return true;
		}

		return false;

	}

	///////////////////////////////

	// ok
	public boolean validarNomeMaiorDoQueOitoLetras(String nome) {

		if (nome.length() > 8) {
			return true;
		}

		return false;
	}

	// ok
	public boolean validarNomeESobrenomeComAcentosEEspacos(String nome) {

		if (nome.matches("^[a-zA-Z\\u00C0-\\u017F´]+\\s+[a-zA-Z\\u00C0-\\u017F´]{0,}$")) {
			return true;
		}

		return false;
	}

	// ok
	public boolean validarEmailComArrobaEComPonto(String email) {

		if (email.matches("\\\\w+@\\\\w+\\\\.\\\\w{2,3}\\\\.\\\\w{2,3}")) {

			return true;
		}

		return false;
	}

	// ok
	public boolean validarSenhaComOMinimoDeOitoDigitos(String senha) {

		if (senha.length() >= 8) {
			return true;
		}

		return false;
	}

	// ok
	public boolean validarSenhaComCaracteres(String senha) {

		if (senha.matches("[A-Za-z0-9]+")) {
			return true;
		}

		return false;
	}

}
