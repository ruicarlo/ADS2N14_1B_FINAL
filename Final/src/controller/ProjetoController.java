package controller;

import exceptions.TituloInvalidoException;
import model.Projeto;
import model.Usuario;

public class ProjetoController {
	Projeto projeto = new Projeto();
	
	public void salvarProjeto(String titulo, String descricao, Usuario usuario) throws Exception {
		usuario.exists();
		this.validarTitulo(titulo);

		this.projeto.setTitulo(titulo);
		this.projeto.setDescricao(descricao);
		this.projeto.setIdCriador(usuario.getIdUsuario());
		this.projeto.armazenarProjetoNoArquivo();
	}

	private void validarTitulo(String titulo) throws TituloInvalidoException {
		if(titulo.isEmpty()) {
			throw new TituloInvalidoException();
		}
	}
}