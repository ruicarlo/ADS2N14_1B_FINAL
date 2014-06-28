package controller;

import model.Issue;

public class IssueController {
	Issue issue = new Issue();
	
	public void salvarIssue() throws Exception {
		this.validarCriticidade();
		this.validarDescricao();
		this.validarIdProjeto();
		this.validarIdUsuario();
		this.validarStatus();
		this.validarTipo();
		this.validarTitulo();
		this.issue.armazenarIssueNoArquivo();
	}

	private void validarTitulo() throws Exception {
		if(this.issue.getTitulo() == null || this.issue.getTitulo().equals("")) {
			throw new Exception("Para cadastrar um issue o titulo deve ser definido");
		}
	}
	
	private void validarCriticidade() throws Exception {
		if(this.issue.getCriticidade() == null || this.issue.getCriticidade().equals("")) {
			throw new Exception("Para cadastrar um issue a criticidade deve ser definida");
		}
	}

	private void validarTipo() throws Exception {
		if(this.issue.getTipo() == null || this.issue.getTipo().equals("")) {
			throw new Exception("Para cadastrar um issue o tipo deve ser definido");
		}
	}

	private void validarStatus() throws Exception {
		if(this.issue.getStatus() == null || this.issue.getStatus().equals("")) {
			throw new Exception("Para cadastrar um issue o status deve ser definido");
		}
	}

	private void validarDescricao() throws Exception {
		if(this.issue.getDescricao() == null || this.issue.getDescricao().equals("")) {
			throw new Exception("Para cadastrar um issue a descri��o deve ser definida");
		}
	}

	private void validarIdProjeto() throws Exception {
		if(this.issue.getIdProjeto() < 1) {
			throw new Exception("Para cadastrar um issue o projeto deve ser definido");
		}
	}
	
	private void validarIdUsuario() throws Exception {
		if(this.issue.getIdUsuario() < 1) {
			throw new Exception("Para cadastrar um issue o usu�rio deve ser definido");
		}
	}
	
	public int getIdProjeto() {
		return this.issue.getIdProjeto();
	}

	public void setIdProjeto(int idProjeto) throws Exception {
		this.issue.setIdProjeto(idProjeto);
		this.validarIdProjeto();
	}

	public int getIdUsuario() {
		return this.issue.getIdUsuario();
	}

	public void setIdUsuario(int idUsuario) throws Exception {
		this.issue.setIdUsuario(idUsuario);
		this.validarIdUsuario();
	}

	public int getIdIssue() {
		return this.issue.getIdIssue();
	}

	public String getDescricao() {
		return this.issue.getDescricao();
	}

	public void setDescricao(String descricao) throws Exception {
		this.issue.setDescricao(descricao);
		this.validarDescricao();
	}
	
	public String getTitulo() {
		return this.issue.getTitulo();
	}
	
	public void setTitulo(String titulo) throws Exception {
		this.issue.setTitulo(titulo);
		this.validarTitulo();
	}
	
	public String getCriticidade() {
		return this.issue.getCriticidade();
	}
	
	public void setCriticidade(String criticidade) throws Exception {
		this.issue.setCriticidade(criticidade);
		this.validarCriticidade();
	}
	
	public String getTipo() {
		return this.issue.getTipo();
	}
	
	public void setTipo(String tipo) throws Exception {
		this.issue.setTipo(tipo);
		this.validarTipo();
	}
	
	public String getStatus() {
		return this.issue.getStatus();
	}
	
	public void setStatus(String status) throws Exception {
		this.issue.setStatus(status);
		this.validarStatus();
	}
}
