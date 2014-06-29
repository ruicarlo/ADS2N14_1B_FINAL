package test.controller;


import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import model.Projeto;
import model.Usuario;
import controller.IssueController;
import exceptions.controllers.UsuarioException;
import exceptions.controllers.IssueException.*;

public class IssueControllerTest {
	private IssueController issueController;
	private Projeto projetoDoIssue;
	private Usuario usuarioLogado;

	@Before
	public void setUp() throws Exception {
		issueController = new IssueController();

		usuarioLogado  = mock(Usuario.class);
		projetoDoIssue = mock(Projeto.class);
		when(projetoDoIssue.getIdProjeto()).thenReturn(1);
		when(usuarioLogado.getIdUsuario()).thenReturn(1);
	}

	@Test
	public void testSalvarIssueValidoNoArquivo() throws Exception {
		doNothing().when(usuarioLogado).exists();
		
		issueController.setTitulo("Titulo de teste");
		issueController.setDescricao("Descricao de teste");
		issueController.setUsuario(usuarioLogado);
		issueController.setCriticidade("Criticidade de teste");
		issueController.setTipo("Tipo de teste");
		issueController.setProjeto(projetoDoIssue);
		issueController.setStatus("Status de teste");
		issueController.salvarIssue();
	}

	@Test(expected = TituloInvalidoException.class)
	public void testNaoSalvarIssueSemTituloNoArquivo() throws Exception {
		doNothing().when(usuarioLogado).exists();
		
		issueController.setTitulo("");
		issueController.setDescricao("Descricao de teste");
		issueController.setUsuario(usuarioLogado);
		issueController.setCriticidade("Criticidade de teste");
		issueController.setTipo("Tipo de teste");
		issueController.setProjeto(projetoDoIssue);
		issueController.setStatus("Status de teste");
		issueController.salvarIssue();
	}

	@Test(expected = DescricaoInvalidaException.class)
	public void testNaoSalvarIssueDescricaoInvalida() throws Exception {
		doNothing().when(usuarioLogado).exists();
		
		issueController.setTitulo("Titulo de teste");
		issueController.setDescricao("");
		issueController.setUsuario(usuarioLogado);
		issueController.setCriticidade("Criticidade de teste");
		issueController.setTipo("Tipo de teste");
		issueController.setProjeto(projetoDoIssue);
		issueController.setStatus("Status de teste");
		issueController.salvarIssue();
	}

	@Test(expected = CriticidadeInvalidaException.class)
	public void testNaoSalvarIssueCriticidadeInvalida() throws Exception {
		doNothing().when(usuarioLogado).exists();
		
		issueController.setTitulo("Titulo de teste");
		issueController.setDescricao("Descricao de teste");
		issueController.setUsuario(usuarioLogado);
		issueController.setCriticidade("");
		issueController.setTipo("Tipo de teste");
		issueController.setProjeto(projetoDoIssue);
		issueController.setStatus("Status de teste");
		issueController.salvarIssue();
	}

	@Test(expected = TipoInvalidoException.class)
	public void testNaoSalvarIssueTipoInvalido() throws Exception {
		doNothing().when(usuarioLogado).exists();
		
		issueController.setTitulo("Titulo de teste");
		issueController.setDescricao("Descricao de teste");
		issueController.setUsuario(usuarioLogado);
		issueController.setCriticidade("Criticidade de teste");
		issueController.setTipo("");
		issueController.setProjeto(projetoDoIssue);
		issueController.setStatus("Status de teste");
		issueController.salvarIssue();
	}

	@Test(expected = StatusInvalidoException.class)
	public void testNaoSalvarIssueStatusInvalido() throws Exception {
		doNothing().when(usuarioLogado).exists();
		
		issueController.setTitulo("Titulo de teste");
		issueController.setDescricao("Descricao de teste");
		issueController.setUsuario(usuarioLogado);
		issueController.setCriticidade("Criticidade de teste");
		issueController.setTipo("Tipo de teste");
		issueController.setProjeto(projetoDoIssue);
		issueController.setStatus("");
		issueController.salvarIssue();
	}

	@Test(expected = ProjetoInvalidoException.class)
	public void testNaoSalvarIssueComProjetoInexistenteNoArquivo() throws Exception {
		doNothing().when(usuarioLogado).exists();

		issueController.setTitulo("Titulo de teste");
		issueController.setDescricao("Descricao de teste");
		issueController.setUsuario(usuarioLogado);
		issueController.setCriticidade("Criticidade de teste");
		issueController.setTipo("Tipo de teste");
//		issueController.setProjeto(projetoDoIssue);
		issueController.setStatus("Status de teste");
		issueController.salvarIssue();
	}

	@Test(expected = UsuarioException.UsuarioInvalidoException.class)
	public void testNaoSalvarIssueComUsuarioInexistenteNoArquivo() throws Exception {
		doThrow(new UsuarioException.UsuarioInvalidoException()).when(usuarioLogado).exists();
		
		issueController.setTitulo("Titulo de teste");
		issueController.setDescricao("Descricao de teste");
		issueController.setUsuario(usuarioLogado);
		issueController.setCriticidade("Criticidade de teste");
		issueController.setTipo("Tipo de teste");
		issueController.setProjeto(projetoDoIssue);
		issueController.setStatus("Status de teste");
		issueController.salvarIssue();
	}
}
