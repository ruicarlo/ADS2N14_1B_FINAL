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
	Usuario usuarioLogado;

	public ProjetoController(Usuario usuarioLogado) throws Exception {
		this.usuarioLogado = usuarioLogado;
		this.setCriador(usuarioLogado);
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

	private void executarComandoTeclado(String comando) {
		switch(comando) {
			case "L":
				Vector<String> listaProjetos = this.retornarListaProjetosDoUsuario();
				if(listaProjetos.getSize() > 0) {
					projetoV.imprimirListaDeProjetos(listaProjetos);
				} else {
					projetoV.imprimirUsuarioSemProjeto();
					
					this.telaInicialApp();
				}
			break;
			case "C":
				this.cadastrarProjeto();
			break;
			case "Q":
				projetoV.printMsg("Encerrando sistema!");
				System.exit(0);
			default:  
				try {
					this.exibirDetalhesProjeto(comando);
					return;
				} catch (NumberFormatException nfe) {
					projetoV.printMsgln("Op��o inv�lida.");
				} catch (ProjetoNaoEcontrado pne) {
					projetoV.printMsgln(pne.getMessage());
				} catch (Exception e) {}
		}

		this.telaInicialApp();
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
    		projetoV.printMsgln(e.getMessage());
    	}
	}

	public Vector<String> retornarListaProjetosDoUsuario() {
		Vector<String> todosProjetos = projeto.retornarListaProjetos();
		Vector<String> projetosFiltrados = new Vector<String>();
		for(String registro : todosProjetos.asArray()){
			if(Integer.parseInt(projeto.arquivo.explodirLinhaDoArquivo(registro)[1]) == projeto.getIdCriador()){
				projetosFiltrados.append(registro+"##(owner)");
			}
		}
		return projetosFiltrados;
	}

	public Projeto buscarProjeto(int idProjeto) throws ProjetoNaoEcontrado {
		Projeto projetoRetorno = new Projeto();
		for (String proj : retornarListaProjetosDoUsuario().asArray()) {
			String[] registro = this.projeto.arquivo.explodirLinhaDoArquivo(proj);
			if(Integer.parseInt(registro[0]) == idProjeto) {
				projetoRetorno.setIdProjeto(Integer.parseInt(registro[0]));
				projetoRetorno.setIdCriador(Integer.parseInt(registro[1]));
				projetoRetorno.setTitulo(registro[2]);
				projetoRetorno.setDescricao(registro[3]);
				return projetoRetorno;
			}
		}
		throw new ProjetoException.ProjetoNaoEcontrado();
	}

	public void exibirDetalhesProjeto(String idProjeto) throws Exception {
		projeto = this.buscarProjeto(Integer.parseInt(idProjeto));

		boolean voltar = false;
		do {
			projetoV.mostrarDadosProjeto(projeto);

			String comando  = projetoV.lerString();
			switch(comando.toUpperCase()) {
				case "X":
					projetoV.imprimirProjetoEXcluido(
							projeto.arquivo.excluirRegisro(idProjeto, 0)
					);
				break;
				case "L":
					IssueController issueC = new IssueController(projeto, usuarioLogado);
					issueC.gerenciarIssues();
				break;
				case "V":
					voltar  = true;
				break;
				default:
					projetoV.printMsgln("Op��o inv�lida.");
			}
		} while(!voltar);
	}
}