package com.gerenciaMais.gerenciamais;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.gerenciaMais.gerenciamais.relatorioTestes.ValidacaoUsuario;

public class ValidacaoUsuarioTest {

	ValidacaoUsuario usuario;

	@Before
	public void inicializaClasse() {
		usuario = new ValidacaoUsuario();
	}

	//ok
	@Test
	public void naoValidarNomeComNumeros() {
		
		String nome = "V1tor L1ma" ;

		assertEquals(false, usuario.naoValidarNomeComNumeros(nome));

	}

	// ok
	@Test
	public void naoValidarNomeMenorDoQueOitoDigitos() {

		String nome = "fulano o";

		assertEquals(false, usuario.validarNomeMaiorDoQueOitoLetras(nome));
	}

	//ok
	@Test
	public void naoValidarNomeESobrenomeSemEspacos() {

		String nome = "VitorLima";

		assertEquals(false, usuario.validarNomeESobrenomeComAcentosEEspacos(nome));

	}

	// ok
	@Test
	public void validarNomeESobrenomeComAcentosEEspaco() {

		String nome = "Débora Áurea";

		assertEquals(true, usuario.validarNomeESobrenomeComAcentosEEspacos(nome));

	}

	// ok
	@Test
	public void naoValidarEmailSemArroba() {

		String email = "eliabegmail.com";

		assertEquals(false, usuario.validarEmailComArrobaEComPonto(email));

	}

	// ok
	@Test
	public void naoValidarEmailSemPonto() {

		String email = "eliabe@gmailcom";

		assertEquals(false, usuario.validarEmailComArrobaEComPonto(email));

	}

	
	public void naoValidarEmailComCaracterEspecial() {

		String email = "eliabe$#@gmailcom";

		assertEquals(false, usuario.validarEmail(email));

	}

	// ok
	@Test
	public void naoValidarSenhaComMenosDoQueOitDigitos() {

		String senha = "5678";

		assertEquals(false, usuario.validarSenhaComOMinimoDeOitoDigitos(senha));

	}

	// ok
	@Test
	public void validarSenhaComCaracteres() {

		String senha = "Fulaaa00";
		assertEquals(true, usuario.validarSenhaComCaracteres(senha));

	}

	public void usuarioValido() {

		String nome = "Débora Áurea";
		String email = "debora@gmail.com";
		String senha = "123456789";

		assertEquals(true, usuario.validarUsuario(nome, email, senha));

	}

}
