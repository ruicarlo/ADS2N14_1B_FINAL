package test.controller;

import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import model.Usuario;
import controller.ProjetoController;
import exceptions.controllers.UsuarioException.*;
import exceptions.controllers.ProjetoException.*;

public class ProjetoControllerTest {
	private ProjetoController projController;
	private Usuario usuarioLogado;

	@Before
	public void setUp() throws Exception {
		projController = new ProjetoController();

		usuarioLogado = mock(Usuario.class);
	}

	@Test
	public void testSalvarProjetoValidoNoArquivo() throws Exception {
		doNothing().when(usuarioLogado).exists();
		
		projController.setTitulo("Teste");
		projController.setDescricao("Com descricao");
		projController.setCriador(usuarioLogado);
		projController.salvarProjeto();
	}

	@Test(expected = DescricaoInvalidaException.class)
	public void testNaoSalvarProjetoDescricaoInvalida() throws Exception {
		doNothing().when(usuarioLogado).exists();
		
		projController.setTitulo("Teste");
		projController.setDescricao("");
		projController.setCriador(usuarioLogado);
		projController.salvarProjeto();
	}

	@Test(expected = TituloInvalidoException.class)
	public void testNaoSalvarProjetoSemTituloNoArquivo() throws Exception {
		doNothing().when(usuarioLogado).exists();
		
		projController.setTitulo("");
		projController.setDescricao("Com descricao");
		projController.setCriador(usuarioLogado);
		projController.salvarProjeto();
	}

	@Test(expected = UsuarioInvalidoException.class)
	public void testNaoSalvarProjetoComUsuarioInexistenteNoArquivo() throws Exception {
		doThrow(new UsuarioInvalidoException()).when(usuarioLogado).exists();
		
		projController.setTitulo("Teste");
		projController.setDescricao("Com descricao");
		projController.setCriador(usuarioLogado);
		projController.salvarProjeto();
	}
}
