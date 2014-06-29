package controller;

import view.ProjetoView;
import exceptions.controllers.ProjetoException;
import exceptions.controllers.ProjetoException.*;
import model.Projeto;
import model.Usuario;

public class ProjetoController {
	Projeto projeto = new Projeto();
	ProjetoView projetoV = new ProjetoView();
	
	public void salvarProjeto() throws TituloInvalidoException,
	                                   DescricaoInvalidaException,
	                                   CriadorInvalidoException {
		this.validarTitulo();
		this.validarDescricao();
		this.validarCriador();
		this.projeto.armazenarProjetoNoArquivo();
	}

	private void validarTitulo() throws TituloInvalidoException {
		if(this.projeto.getTitulo() == null || this.projeto.getTitulo().equals("")) {
			throw new ProjetoException.TituloInvalidoException();
		}
	}

	private void validarDescricao() throws DescricaoInvalidaException {
		if(this.projeto.getDescricao() == null || this.projeto.getDescricao().equals("")) {
			throw new ProjetoException.DescricaoInvalidaException();
		}
	}
	
	private void validarCriador() throws CriadorInvalidoException {
		if(this.projeto.getIdCriador() < 0) {
			throw new ProjetoException.CriadorInvalidoException();
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
	
	public void telaInicialApp() {
		this.executarComandoTeclado(projetoV.lerComando());
	}

	private void executarComandoTeclado(char comando) {
		switch(comando) {
			case 'L':
				projetoV.imprimirListaDeProjetos(projeto.retornarListaProjetos());
			break;
			case 'C':
				this.cadastrarProjeto();
			break;
		}
	}

	private void cadastrarProjeto() {
    	try {
    		projetoV.imprimirDigiteTitulo();
    		this.setTitulo(projetoV.lerString());
    		
    		projetoV.imprimirDigiteDescricao();
    		this.setDescricao(projetoV.lerString());
    		
			this.salvarProjeto();
    	} catch(Exception e) {
    		projetoV.printMsg(e.getMessage());
    	}
	}
}