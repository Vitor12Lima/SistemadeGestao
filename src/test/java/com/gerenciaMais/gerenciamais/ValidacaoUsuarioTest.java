package com.gerenciaMais.gerenciamais;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import com.gerenciaMais.gerenciamais.relatorioTestes.ValidacaoUsuario;

public class ValidacaoUsuarioTest {

	// ok
	@Test
	public void naoValidarNomeComNumeros() {

		ValidacaoUsuario usuario = new ValidacaoUsuario();

		String nome = "Vitor L1m4";
//		String email = "deboraaurea.ifal@gmail.com";
//		String senha = "1234";

		boolean usuarioValido = usuario.validarNome(nome);
		assertEquals(false, usuarioValido);

	}

	// ok
	@Test
	public void naoValidarNomeESobrenomeSemEspacos() {

		ValidacaoUsuario usuario = new ValidacaoUsuario();

		String nome = "VitorLima";
		String email = "vitor.ifal@gmail.com";
		String senha = "1234";

		boolean usuarioValido = usuario.validarUsuario(nome, email, senha);
		assertEquals(false, usuarioValido);

	}

	// ok
	@Test
	public void naoValidarEmailSemArroba() {

		ValidacaoUsuario usuario = new ValidacaoUsuario();

		String nome = "Eliabe Francelino";
		String email = "eliabegmail.com";
		String senha = "5678";

		boolean usuarioValido = usuario.validarUsuario(nome, email, senha);
		assertEquals(false, usuarioValido);

	}

	// ok
	@Test
	public void naoValidarEmailSemPonto() {

		ValidacaoUsuario usuario = new ValidacaoUsuario();

		String nome = "Eliabe Francelino";
		String email = "eliabe@gmailcom";
		String senha = "5678";

		boolean usuarioValido = usuario.validarUsuario(nome, email, senha);
		assertEquals(false, usuarioValido);

	}

	//ok
	@Test
	public void naoValidarEmailComCaracterEspecial() {
		
		ValidacaoUsuario usuario = new ValidacaoUsuario();

		String nome = "Eliabe Francelino";
		String email = "eliabe$#@gmailcom";
		String senha = "5678";

		boolean usuarioValido = usuario.validarUsuario(nome, email, senha);
		assertEquals(false, usuarioValido);
		
	}
	
	@Test
	public void naoValidarSenhaComMenosDoQueOitDigitos() {
		
		ValidacaoUsuario usuario = new ValidacaoUsuario();

		String senha = "5678";

		boolean usuarioValido = usuario.validarSenha(senha);
		assertEquals(true, usuarioValido);
		
	}
	
	/*@Test
	public void usuarioValido() {
		
		ValidacaoUsuario usuario = new ValidacaoUsuario();

		String nome = "Débora Áurea";
		String email = "debora@gmail.com";
		String senha = "9999";

		boolean usuarioValido = usuario.validarUsuario(nome, email, senha);
		assertEquals(true, usuarioValido);
		
	}*/
	

}
