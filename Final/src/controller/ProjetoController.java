package controller;

import exceptions.TituloInvalidoException;
import model.Projeto;

public class ProjetoController {
	Projeto projeto = new Projeto();
	
	public void salvarProjeto(String titulo) throws Exception {
		this.validarTitulo(titulo);
		this.projeto.setTitulo(titulo);
	}

	private void validarTitulo(String titulo) throws TituloInvalidoException {
		if(titulo.isEmpty()) {
			throw new TituloInvalidoException();
		}
	}
		
}