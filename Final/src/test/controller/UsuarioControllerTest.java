package test.controller;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.junit.*;

import static org.mockito.Mockito.*;
import controller.UsuarioController;
import exceptions.UsuarioInvalidoException;

public class UsuarioControllerTest {

	private UsuarioController usuarioController;
	private String usuario;

	@Before
	public void setUp() {
		usuarioController = new UsuarioController();

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		usuario = dateFormat.format(date);
	}

	@Test
	public void testSalvarUsuarioNoArquivo() throws Exception {
		usuarioController.salvarUsuario(usuario, usuario, usuario);
	}

	@Test(expected = Exception.class)
	public void testNaoSalvarUsuarioFaltandoDadosNoArquivo() throws Exception {
		usuarioController.salvarUsuario("Silva Silva", "", "");
	}


	@Test(expected = Exception.class)
	public void testNaoSalvarUsuarioExistenteNoArquivo() throws Exception {
		usuarioController.salvarUsuario("Teste da Silva", "123", "testedasilva");
	}

	@Test
	public void testAutenticacaoUsuario() throws UsuarioInvalidoException {
		usuarioController.autenticarUsuario(usuario, usuario);
	}

	@Test(expected = UsuarioInvalidoException.class)
	public void testFalhaAutenticacaoUsuario() throws UsuarioInvalidoException {
		usuarioController.autenticarUsuario(anyString(), anyString());
	}
}
