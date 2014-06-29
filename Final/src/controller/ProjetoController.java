package controller;

import exceptions.TituloInvalidoException;
import model.Projeto;
import model.Usuario;

public class ProjetoController {
	Projeto projeto = new Projeto();
	
	public void salvarProjeto() throws Exception {
		this.validarTitulo();
		this.validarDescricao();
		this.validarCriador();
		this.projeto.armazenarProjetoNoArquivo();
	}

	private void validarTitulo() throws TituloInvalidoException {
		if(this.projeto.getTitulo() == null || this.projeto.getTitulo().equals("")) {
			throw new TituloInvalidoException();
		}
	}

	private void validarDescricao() throws Exception {
		if(this.projeto.getDescricao() == null || this.projeto.getDescricao().equals("")) {
			throw new Exception("Para cadastrar um projeto a descricao deve ser definido");
		}
	}
	
	private void validarCriador() throws Exception {
		if(this.projeto.getIdCriador() < 0) {
			throw new Exception("Para cadastrar um projeto o usuario deve ser definido");
		}
	}

	public int getIdProjeto() {
		return this.projeto.getIdProjeto();
	}

	public String getTitulo() {
		return this.projeto.getTitulo();
	}

	public void setTitulo(String titulo) throws Exception {
		this.projeto.setTitulo(titulo);
		this.validarTitulo();
	}
	
	public String getDescricao() {
		return this.projeto.getDescricao();
	}

	public void setDescricao(String descricao) throws Exception {
		this.projeto.setDescricao(descricao);
		this.validarDescricao();
	}
	
	public int getIdCriador() {
		return this.projeto.getIdCriador();
	}

	public void setCriador(Usuario usuario) throws Exception {
		usuario.exists();
		this.projeto.setIdCriador(usuario.getIdUsuario());
	}
}