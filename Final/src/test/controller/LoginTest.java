package test.controller;

import static org.junit.Assert.*;
import model.Usuario;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;
import controller.Login;
import interfaces.IUsuarioController;
import exceptions.UsuarioInvalidoException;

public class LoginTest {

	private Login login;
	private Usuario usuario;
	private IUsuarioController usuarioController;

	@Before
	public void setUp() {
		login = new Login();
		usuario = mock(Usuario.class);
		usuarioController = mock(IUsuarioController.class);
	}

	@Test
	public void testAutenticarUsuarioValido() throws UsuarioInvalidoException {
		when(usuarioController.autenticarUsuario(anyString(), anyString()))
				.thenReturn(usuario);

		login.setUsername("jolizinha");
		login.setSenha("jolie2014");

		assertEquals(true, usuario.equals(login.autenticarUsuario()));
	}

	@Test(expected = UsuarioInvalidoException.class)
	public void testFalhaAutenticarUsuario() throws UsuarioInvalidoException {
		when(usuarioController.autenticarUsuario(anyString(), anyString()))
				.thenThrow(UsuarioInvalidoException.class);

		login.setUsername("jolizinha");
		login.setSenha("jolie2014");

		login.autenticarUsuario();
	}
}
