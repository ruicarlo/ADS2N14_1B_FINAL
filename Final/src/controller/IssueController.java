package controller;

import exceptions.controllers.IssueException;
import exceptions.controllers.IssueException.*;
import exceptions.controllers.UsuarioException;
import model.Issue;
import model.Projeto;
import model.Usuario;

public class IssueController {
	Issue issue = new Issue();

	public void salvarIssue() throws CriticidadeInvalidaException,
	                                 DescricaoInvalidaException,
	                                 ProjetoInvalidoException,
	                                 exceptions.controllers.IssueException.UsuarioInvalidoException,
	                                 StatusInvalidoException,
	                                 TipoInvalidoException,
	                                 TituloInvalidoException {
		this.validarCriticidade();
		this.validarDescricao();
		this.validarIdProjeto();
		this.validarUsuario();
		this.validarStatus();
		this.validarTipo();
		this.validarTitulo();
		this.issue.armazenarIssueNoArquivo();
	}

	private void validarTitulo() throws TituloInvalidoException {
		if(this.issue.getTitulo() == null || this.issue.getTitulo().equals("")) {
			throw new IssueException.TituloInvalidoException();
		}
	}
	
	private void validarCriticidade() throws CriticidadeInvalidaException {
		if(this.issue.getCriticidade() == null || this.issue.getCriticidade().equals("")) {
			throw new IssueException.CriticidadeInvalidaException();
		}
	}

	private void validarTipo() throws TipoInvalidoException {
		if(this.issue.getTipo() == null || this.issue.getTipo().equals("")) {
			throw new IssueException.TipoInvalidoException();
		}
	}

	private void validarStatus() throws StatusInvalidoException {
		if(this.issue.getStatus() == null || this.issue.getStatus().equals("")) {
			throw new IssueException.StatusInvalidoException();
		}
	}

	private void validarDescricao() throws DescricaoInvalidaException {
		if(this.issue.getDescricao() == null || this.issue.getDescricao().equals("")) {
			throw new IssueException.DescricaoInvalidaException();
		}
	}

	private void validarIdProjeto() throws ProjetoInvalidoException {
		if(this.issue.getIdProjeto() < 1) {
			throw new IssueException.ProjetoInvalidoException();
		}
	}
	
	private void validarUsuario() throws exceptions.controllers.IssueException.UsuarioInvalidoException  {
		if(this.issue.getIdUsuario() < 1) {
			throw new IssueException.UsuarioInvalidoException();
		}
	}
	
	public int getIdProjeto() {
		return this.issue.getIdProjeto();
	}

	public void setProjeto(Projeto projeto) throws Exception {
		this.issue.setIdProjeto(projeto.getIdProjeto());
		this.validarIdProjeto();
	}

	public int getIdUsuario() {
		return this.issue.getIdUsuario();
	}

	public void setUsuario(Usuario usuario) throws UsuarioException.UsuarioInvalidoException {
		usuario.exists();
		this.issue.setIdUsuario(usuario.getIdUsuario());
	}

	public int getIdIssue() {
		return this.issue.getIdIssue();
	}

	public String getDescricao() {
		return this.issue.getDescricao();
	}

	public void setDescricao(String descricao) throws DescricaoInvalidaException {
		this.issue.setDescricao(descricao);
		this.validarDescricao();
	}
	
	public String getTitulo() {
		return this.issue.getTitulo();
	}
	
	public void setTitulo(String titulo) throws TituloInvalidoException {
		this.issue.setTitulo(titulo);
		this.validarTitulo();
	}
	
	public String getCriticidade() {
		return this.issue.getCriticidade();
	}
	
	public void setCriticidade(String criticidade) throws CriticidadeInvalidaException {
		this.issue.setCriticidade(criticidade);
		this.validarCriticidade();
	}
	
	public String getTipo() {
		return this.issue.getTipo();
	}
	
	public void setTipo(String tipo) throws TipoInvalidoException {
		this.issue.setTipo(tipo);
		this.validarTipo();
	}
	
	public String getStatus() {
		return this.issue.getStatus();
	}
	
	public void setStatus(String status) throws StatusInvalidoException {
		this.issue.setStatus(status);
		this.validarStatus();
	}
}
