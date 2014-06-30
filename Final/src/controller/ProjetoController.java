package controller;

import view.ProjetoView;
import estruturas.Vector;
import exceptions.controllers.ProjetoException;
import exceptions.controllers.ProjetoException.*;
import model.Projeto;
import model.Usuario;

public class ProjetoController {
	Projeto projeto = new Projeto();
	ProjetoView projetoV = new ProjetoView();
	Usuario criador;

	public ProjetoController(Usuario criador) throws Exception {
		this.criador = criador;
		this.setCriador(criador);
	}

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
				Vector<String> listaProjetos = this.retornarListaProjetosDoUsuario();
				if(listaProjetos.getSize() > 0) {
					projetoV.imprimirListaDeProjetos(listaProjetos);
				} else {
					projetoV.imprimirUsuarioSemProjeto();
					
					this.telaInicialApp();
				}
			break;
			case 'C':
				this.cadastrarProjeto();
			break;
		}
	}

	private void cadastrarProjeto() {
    	try {
    		projetoV.setTeclado();
    		projetoV.imprimirDigiteTitulo();
    		this.setTitulo(projetoV.lerString());
    		
    		projetoV.imprimirDigiteDescricao();
    		this.setDescricao(projetoV.lerString());
    		
			this.salvarProjeto();
			projetoV.imprimirProjetoCadastradoComSucesso();
    	} catch(Exception e) {
    		projetoV.printMsg(e.getMessage());
    	}
	}
	public Vector<String> retornarListaProjetosDoUsuario() {
		Vector<String> todosProjetos = projeto.retornarListaProjetos();
		Vector<String> projetosFiltrados = new Vector<String>();
		for(String registro : todosProjetos.asArray()){
			if(Integer.parseInt(projeto.arquivo.explodirLinhaDoArquivo(registro)[1]) == projeto.getIdCriador()){
				projetosFiltrados.append(registro);
			}
		}
		return projetosFiltrados;
	}

	public ProjetoController buscarProjeto(int idProjeto) throws Exception{
		try {
			ProjetoController projetoRetorno = new ProjetoController(criador);
			for (String proj : retornarListaProjetosDoUsuario().asArray()) {
				String[] registro = this.projeto.arquivo.explodirLinhaDoArquivo(proj);
				if(Integer.parseInt(registro[0]) == idProjeto) {
					projetoRetorno.projeto.setIdProjeto(Integer.parseInt(registro[0]));
					projetoRetorno.projeto.setIdCriador(Integer.parseInt(registro[1]));
					projetoRetorno.projeto.setTitulo(registro[2]);
					projetoRetorno.projeto.setDescricao(registro[3]);
					return projetoRetorno;
				}
			}
			throw new ProjetoException.ProjetoNaoEcontrado();
		}catch(Exception e) {
			throw e;
		}
	}
}