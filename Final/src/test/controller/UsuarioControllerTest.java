package test.controller;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import model.Usuario;

import org.junit.*;

import static org.mockito.Mockito.*;
import controller.UsuarioController;
import exceptions.controllers.UsuarioException.*;

public class UsuarioControllerTest {

	private UsuarioController usuarioController;
	public Usuario usuario;
	private String dataHora;

	@Before
	public void setUp() {
		usuarioController = new UsuarioController();
		usuario = mock(Usuario.class);

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		dataHora = dateFormat.format(date);
	}

	private void dadosDoUsuarioParaRetornar(String nome, String username, String senha) {
		when(usuario.getNome()).thenReturn(nome);
		when(usuario.getUsername()).thenReturn(username);
		when(usuario.getSenha()).thenReturn(senha);
	}

	@Test
	public void testSalvarUsuarioNoArquivo() throws Exception {
		dadosDoUsuarioParaRetornar(dataHora, dataHora, dataHora);
		usuarioController.setUsuario(usuario);
		usuarioController.salvarUsuario();
	}

	@Test(expected = Exception.class)
	public void testNaoSalvarUsuarioFaltandoDadosNoArquivo() throws Exception {
		dadosDoUsuarioParaRetornar("Teste da Silva", "123", "testedasilva");
		usuarioController.setUsuario(usuario);
		usuarioController.salvarUsuario();
	}

	@Test(expected = Exception.class)
	public void testNaoSalvarUsuarioExistenteNoArquivo() throws Exception {
		dadosDoUsuarioParaRetornar("Teste da Silva", "123", "testedasilva");
		usuarioController.setUsuario(usuario);
		usuarioController.salvarUsuario();
	}

	@Test
	public void testAutenticacaoUsuario() throws FalhaDeAutenticacaoException {
		usuarioController.autenticarUsuario(dataHora, dataHora);
	}

	@Test(expected = FalhaDeAutenticacaoException.class)
	public void testFalhaAutenticacaoUsuario() throws FalhaDeAutenticacaoException {
		usuarioController.autenticarUsuario("Inexistente", "SemSenha");
	}
}
