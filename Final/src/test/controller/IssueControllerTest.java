package test.controller;


import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import model.Criticidade;
import model.Estado;
import model.Projeto;
import model.Tipo;
import model.Usuario;
import controller.IssueController;
import exceptions.controllers.ProjetoException;
import exceptions.controllers.ProjetoException.ProjetoNaoEcontrado;
import exceptions.controllers.UsuarioException;
import exceptions.controllers.IssueException.*;

public class IssueControllerTest {
	private IssueController issueController;
	private Projeto projetoDoIssue;
	private Usuario usuarioLogado;

	@Before
	public void setUp() throws Exception {
		usuarioLogado  = mock(Usuario.class);
		projetoDoIssue = mock(Projeto.class);

		when(projetoDoIssue.getIdProjeto()).thenReturn(1);
		when(usuarioLogado.getIdUsuario()).thenReturn(1);

		issueController = new IssueController(projetoDoIssue, usuarioLogado);
	}

	@Test
	public void testSalvarIssueValidoNoArquivo() throws Exception {
		doNothing().when(usuarioLogado).exists();
		
		issueController.setTitulo("Titulo de teste");
		issueController.setDescricao("Descricao de teste");
		issueController.setUsuario(usuarioLogado);
		issueController.setCriticidade(Criticidade.BLOCKER);
		issueController.setTipo(Tipo.ENHANCEMENT);
		issueController.setProjeto(projetoDoIssue);
		issueController.setStatus(Estado.ATRIBUIDO);
		issueController.salvarIssue();
	}

	@Test(expected = TituloInvalidoException.class)
	public void testNaoSalvarIssueSemTituloNoArquivo() throws Exception {
		doNothing().when(usuarioLogado).exists();
		
		issueController.setTitulo("");
		issueController.setDescricao("Descricao de teste");
		issueController.setUsuario(usuarioLogado);
		issueController.setCriticidade(Criticidade.CRITICAL);
		issueController.setTipo(Tipo.BUG);
		issueController.setProjeto(projetoDoIssue);
		issueController.setStatus(Estado.CLOSED);
		issueController.salvarIssue();
	}

	@Test(expected = DescricaoInvalidaException.class)
	public void testNaoSalvarIssueDescricaoInvalida() throws Exception {
		doNothing().when(usuarioLogado).exists();
		
		issueController.setTitulo("Titulo de teste");
		issueController.setDescricao("");
		issueController.setUsuario(usuarioLogado);
		issueController.setCriticidade(Criticidade.LOW);
		issueController.setTipo(Tipo.BUG);
		issueController.setProjeto(projetoDoIssue);
		issueController.setStatus(Estado.NOVO);
		issueController.salvarIssue();
	}

	@Test(expected = CriticidadeInvalidaException.class)
	public void testNaoSalvarIssueCriticidadeInvalida() throws Exception {
		doNothing().when(usuarioLogado).exists();
		
		issueController.setTitulo("Titulo de teste");
		issueController.setDescricao("Descricao de teste");
		issueController.setUsuario(usuarioLogado);
		issueController.setCriticidade(Criticidade.getEnumById(9999));
		issueController.setTipo(Tipo.BUG);
		issueController.setProjeto(projetoDoIssue);
		issueController.setStatus(Estado.ABERTO);
		issueController.salvarIssue();
	}

	@Test(expected = TipoInvalidoException.class)
	public void testNaoSalvarIssueTipoInvalido() throws Exception {
		doNothing().when(usuarioLogado).exists();
		
		issueController.setTitulo("Titulo de teste");
		issueController.setDescricao("Descricao de teste");
		issueController.setUsuario(usuarioLogado);
		issueController.setCriticidade(Criticidade.MEDIUM);
		issueController.setTipo(Tipo.getEnumById(9999));
		issueController.setProjeto(projetoDoIssue);
		issueController.setStatus(Estado.DUPLICADO);
		issueController.salvarIssue();
	}

	@Test(expected = StatusInvalidoException.class)
	public void testNaoSalvarIssueStatusInvalido() throws Exception {
		doNothing().when(usuarioLogado).exists();
		
		issueController.setTitulo("Titulo de teste");
		issueController.setDescricao("Descricao de teste");
		issueController.setUsuario(usuarioLogado);
		issueController.setCriticidade(Criticidade.HIGH);
		issueController.setTipo(Tipo.BUG);
		issueController.setProjeto(projetoDoIssue);
		issueController.setStatus(Estado.getEnumById(9999));
		issueController.salvarIssue();
	}

	@Test(expected = ProjetoNaoEcontrado.class)
	public void testNaoSalvarIssueComProjetoInexistenteNoArquivo() throws Exception {
		doNothing().when(usuarioLogado).exists();
		doThrow(new ProjetoException.ProjetoNaoEcontrado()).when(projetoDoIssue).exists();

		issueController.setTitulo("Titulo de teste");
		issueController.setDescricao("Descricao de teste");
		issueController.setUsuario(usuarioLogado);
		issueController.setCriticidade(Criticidade.HIGH);
		issueController.setTipo(Tipo.BUG);
		issueController.setProjeto(projetoDoIssue);
		issueController.setStatus(Estado.EM_DEV);
		issueController.salvarIssue();
	}

	@Test(expected = UsuarioException.UsuarioInvalidoException.class)
	public void testNaoSalvarIssueComUsuarioInexistenteNoArquivo() throws Exception {
		doThrow(new UsuarioException.UsuarioInvalidoException()).when(usuarioLogado).exists();
		
		issueController.setTitulo("Titulo de teste");
		issueController.setDescricao("Descricao de teste");
		issueController.setUsuario(usuarioLogado);
		issueController.setCriticidade(Criticidade.HIGH);
		issueController.setTipo(Tipo.BUG);
		issueController.setProjeto(projetoDoIssue);
		issueController.setStatus(Estado.NOVO);
		issueController.salvarIssue();
	}
}
