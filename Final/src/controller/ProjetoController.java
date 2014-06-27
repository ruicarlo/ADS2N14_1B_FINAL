package controller;

import estruturas.Vector;
import exceptions.TituloInvalidoException;
import model.Projeto;

public class ProjetoController {
	Projeto projeto = new Projeto();
	
	public void salvarProjeto(String titulo) throws Exception {
		this.validarTitulo(titulo);
		this.projeto.setTitulo(titulo);
	}

	private void validarTitulo(String titulo) throws Exception {
		if(titulo.isEmpty()) {
			throw new Exception("Para cadastrar um titulo um titulo deve ser definido");
		}
	}
		
	private void verificarSeTitulojaExiste(String titulo) throws Exception {
    	Vector<String> projeto = this.projeto.retornarListaProjetos();
    	if(projeto.getSize()<1){
    		return;
    	}
    	for(String titulo : projetos.asArray()) {
    		String[] projetoAux = this.projeto.arquivo.explodirLinhaDoArquivo(titulo);
    		if(!projetoAux[3].isEmpty() && projetoAux[3].equalsIgnoreCase(titulo)) {
    			throw new Exception("Este titulo j� est� cadastrado no sistema");
    		}
    	}
    }

    public Projeto autenticarTitulos(String titulo) throws TituloInvalidoException {
    	Vector<String> listaTitulos = this.projeto.retornarListaProjetos();

    	if(listaTitulos.getSize() > 0) {
    		for(String titulo : listaTitulos.asArray()) {
    			String[] projetoAux = this.projeto.arquivo.explodirLinhaDoArquivo(titulo);
    				this.projeto.setIdProjeto(Integer.parseInt(projetoAux[0]));
    				this.projeto.setTitulo(projetoAux[1]);
    				return this.projeto;
    			
    		}
    	}
    	throw new TituloInvalidoException();
    }
}