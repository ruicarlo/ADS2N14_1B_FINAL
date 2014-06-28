package test.controller;

import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import model.Usuario;
import controller.ProjetoController;
import exceptions.TituloInvalidoException;
import exceptions.UsuarioInvalidoException;

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
		doNothing().when(usuarioLogado).exists();;
		
		projController.salvarProjeto("Teste", "Com descricao", usuarioLogado);
		projController.salvarProjeto("Teste", "", usuarioLogado);
	}

	@Test(expected = TituloInvalidoException.class)
	public void testNaoSalvarProjetoSemTituloNoArquivo() throws Exception {
		doNothing().when(usuarioLogado).exists();;
		
		projController.salvarProjeto("", "Com descricao", usuarioLogado);
	}

	@Test(expected = UsuarioInvalidoException.class)
	public void testNaoSalvarProjetoComUsuarioInexistenteNoArquivo() throws Exception {
		doThrow(new UsuarioInvalidoException()).when(usuarioLogado).exists();;
		
		projController.salvarProjeto("", "Com descricao", usuarioLogado);
	}
}
