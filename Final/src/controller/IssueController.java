package controller;

import model.Issue;
import estruturas.Vector;
import exceptions.UsuarioInvalidoException;

public class IssueController {
	Issue issue = new Issue();
	
	public void salvarIssue() throws Exception {
		this.issue.armazenarIssueNoArquivo();
	}

	private void validarTitulo(String titulo) throws Exception {
		if(titulo.isEmpty()) {
			throw new Exception("Para cadastrar um issue o titulo deve ser definido");
		}
	}
	
	private void validarCriticidade(String criticidade) throws Exception {
		if(criticidade.isEmpty()) {
			throw new Exception("Para cadastrar um issue a criticidade deve ser definida");
		}
	}

	private void validarTipo(String tipo) throws Exception {
		if(tipo.isEmpty()) {
			throw new Exception("Para cadastrar um issue o tipo deve ser definido");
		}
	}

	private void validarStatus(String status) throws Exception {
		if(status.isEmpty()) {
			throw new Exception("Para cadastrar um issue o status deve ser definido");
		}
	}

	private void validarDescricao(String descricao) throws Exception {
		if(descricao.isEmpty()) {
			throw new Exception("Para cadastrar um issue a descrição deve ser definida");
		}
	}

	private void validarIdProjeto(int idProjeto) throws Exception {
		if(idProjeto < 1) {
			throw new Exception("Para cadastrar um issue o projeto deve ser definido");
		}
	}
	
	private void validarIdUsuario(int idUsuario) throws Exception {
		if(idUsuario < 1) {
			throw new Exception("Para cadastrar um issue o usuário deve ser definido");
		}
	}
	
	public int getIdProjeto() {
		return this.issue.getIdProjeto();
	}

	public void setIdProjeto(int idProjeto) throws Exception {
		this.validarIdProjeto(idProjeto);
		this.issue.setIdProjeto(idProjeto);
	}

	public int getIdUsuario() {
		return this.issue.getIdUsuario();
	}

	public void setIdUsuario(int idUsuario) throws Exception {
		this.validarIdUsuario(idUsuario);
		this.issue.setIdUsuario(idUsuario);
	}

	public int getIdIssue() {
		return this.issue.getIdIssue();
	}

	public String getDescricao() {
		return this.issue.getDescricao();
	}

	public void setDescricao(String descricao) throws Exception {
		this.validarDescricao(descricao);
		this.issue.setDescricao(descricao);
	}
	
	public String getTitulo() {
		return this.issue.getTitulo();
	}
	
	public void setTitulo(String titulo) throws Exception {
		this.validarTitulo(titulo);
		this.issue.setTitulo(titulo);
	}
	
	public String getCriticidade() {
		return this.issue.getCriticidade();
	}
	
	public void setCriticidade(String criticidade) throws Exception {
		this.validarCriticidade(criticidade);
		this.issue.setCriticidade(criticidade);
	}
	
	public String getTipo() {
		return this.issue.getTipo();
	}
	
	public void setTipo(String tipo) throws Exception {
		this.validarTipo(tipo);
		this.issue.setTipo(tipo);
	}
	
	public String getStatus() {
		return this.issue.getStatus();
	}
	
	public void setStatus(String status) throws Exception {
		this.validarStatus(status);
		this.issue.setStatus(status);
	}
}
