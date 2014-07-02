package test.controller;


import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import model.Issue;
import model.Usuario;
import controller.EventoController;
import exceptions.controllers.UsuarioException;
import exceptions.controllers.EventoException.*;

public class EventoControllerTest {
	private EventoController eventoController;
	private Issue IssueDoEvento;
	private Usuario usuarioLogado;

	@Before
	public void setUp() throws Exception {
		usuarioLogado = mock(Usuario.class);
		IssueDoEvento = mock(Issue.class);
		
		when(IssueDoEvento.getIdIssue()).thenReturn(1);
		when(usuarioLogado.getIdUsuario()).thenReturn(1);
		
		eventoController = new EventoController(IssueDoEvento, usuarioLogado);

	}

	@Test
	public void testSalvarEventoValidoNoArquivo() throws Exception {
		doNothing().when(usuarioLogado).exists();
		
		eventoController.setData("29/06/2014");
		eventoController.setUsuario(usuarioLogado);
		eventoController.setComentario("Criticidade de teste");
		eventoController.setIssue(IssueDoEvento);
		eventoController.salvarEvento();
	}

	@Test(expected = DataInvalidaException.class)
	public void testNaoSalvarEventoDataInvalida() throws Exception {
		doNothing().when(usuarioLogado).exists();
		
		eventoController.setData("");
		eventoController.setUsuario(usuarioLogado);
		eventoController.setComentario("Criticidade de teste");
		eventoController.setIssue(IssueDoEvento);
		eventoController.salvarEvento();
	}

	@Test(expected = ComentarioInvalidoException.class)
	public void testNaoSalvarEventoComentarioInvalido() throws Exception {
		doNothing().when(usuarioLogado).exists();
		
		eventoController.setData("29/06/2014");
		eventoController.setUsuario(usuarioLogado);
		eventoController.setComentario("");
		eventoController.setIssue(IssueDoEvento);
		eventoController.salvarEvento();
	}

	@Test(expected = IssueInvalidoException.class)
	public void testNaoSalvarEventoIssueInvalido() throws Exception {
		doNothing().when(usuarioLogado).exists();
		
		//o objeto é criado para nao gerar um id valido para a issue
		when(IssueDoEvento.getIdIssue()).thenReturn(0);
		eventoController = new EventoController(IssueDoEvento, usuarioLogado);
		
		eventoController.setData("29/06/2014");
		eventoController.setUsuario(usuarioLogado);
		eventoController.setComentario("Criticidade de teste");
		//eventoController.setIssue(IssueDoEvento);
		eventoController.salvarEvento();
	}

	@Test(expected = UsuarioException.UsuarioInvalidoException.class)
	public void testNaoSalvarEventoComUsuarioInexistenteNoArquivo() throws Exception {
		doThrow(new UsuarioException.UsuarioInvalidoException()).when(usuarioLogado).exists();
		
		eventoController.setData("29/06/2014");
		eventoController.setUsuario(usuarioLogado);
		eventoController.setComentario("Criticidade de teste");
		eventoController.setIssue(IssueDoEvento);
		eventoController.salvarEvento();
	}
}
