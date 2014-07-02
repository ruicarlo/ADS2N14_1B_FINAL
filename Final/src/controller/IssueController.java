package controller;

import view.IssueView;
import estruturas.Vector;
import exceptions.controllers.IssueException;
import exceptions.controllers.ProjetoException.ProjetoNaoEcontrado;
import exceptions.controllers.UsuarioException.UsuarioInvalidoException;
import exceptions.controllers.IssueException.*;
import exceptions.controllers.UsuarioException;
import model.Criticidade;
import model.Estado;
import model.Issue;
import model.Projeto;
import model.Tipo;
import model.Usuario;

public class IssueController {
	Issue issue = new Issue();
	IssueView issueV = new IssueView();
	EventoController eventoC;
	
	public IssueController(Projeto projeto, Usuario usuario) throws Exception {
		this.setProjeto(projeto);
		this.setUsuario(usuario);
		this.eventoC = new EventoController(this, usuario);	
	}

	public void salvarIssue() throws CriticidadeInvalidaException,
	                                 DescricaoInvalidaException,
	                                 ProjetoInvalidoException,
	                                 IssueException.UsuarioInvalidoException,
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
		if(!(this.issue.getCriticidade() instanceof Criticidade)) {
			throw new IssueException.CriticidadeInvalidaException();
		}
	}

	private void validarTipo() throws TipoInvalidoException {
		if(!(this.issue.getTipo() instanceof Tipo)) {
			throw new IssueException.TipoInvalidoException();
		}
	}

	private void validarStatus() throws StatusInvalidoException {
		if(!(this.issue.getStatus() instanceof Estado)) {
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

	public void setProjeto(Projeto projeto) throws ProjetoNaoEcontrado {
		projeto.exists();
		this.issue.setIdProjeto(projeto.getIdProjeto());
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
	
	public Criticidade getCriticidade() {
		return this.issue.getCriticidade();
	}
	
	public void setCriticidade(Criticidade criticidade) throws CriticidadeInvalidaException {
		this.issue.setCriticidade(criticidade);
		this.validarCriticidade();
	}
	
	public Tipo getTipo() {
		return this.issue.getTipo();
	}
	
	public void setTipo(Tipo tipo) throws TipoInvalidoException {
		this.issue.setTipo(tipo);
		this.validarTipo();
	}
	
	public Estado getStatus() {
		return this.issue.getStatus();
	}
	
	public void setStatus(Estado status) throws StatusInvalidoException {
		this.issue.setStatus(status);
		this.validarStatus();
	}
	
	public Issue gerenciarIssues() {
		return this.executarComandoTeclado(issueV.lerComando());
	}

	private Issue executarComandoTeclado(String comando) {
		switch(comando) {
			case "L":
				issueV.imprimirListaDeIssues(this.retornarIssuesDoProjeto());
			break;
			case "C":
				this.cadastrarIssue();
				break;

			default:
				try {
					this.issue = this.buscarIssue(Integer.parseInt(comando));
					issueV.mostrarDadosIssue(issue);
					return this.issue;
				} catch (NumberFormatException nfe) {
					issueV.printMsgln("Opção inválida.");
				} catch (IssueNaoEcontradaException ine) {
					issueV.printMsgln(ine.getMessage());
				}
			}

			return this.gerenciarIssues();
	}

	private void cadastrarIssue() {
		try {
    		issueV.setTeclado();
    		issueV.imprimirDigiteTitulo();
    		this.setTitulo(issueV.lerString());
    		
    		issueV.imprimirDigiteDescricao();
    		this.setDescricao(issueV.lerString());
    		
    		issueV.imprimirCriticidade();
    		this.setCriticidade(Criticidade.getEnumById(issueV.lerInt()));
    		
    		issueV.imprimirEstado();
    		this.setStatus(Estado.getEnumById(issueV.lerInt()));
    		
    		issueV.imprimirTipo();
    		this.setTipo(Tipo.getEnumById(issueV.lerInt()));
    		
			this.salvarIssue();
			this.getIdIssue();
			this.eventoC.eventoCriarIssue();
//			issueV.imprimirIssueCadastradaComSucesso();
    	} catch(Exception e) {
    		issueV.printMsg(e.getMessage());
    	}
	}

	public Vector<String> retornarIssuesDoProjeto() {
		Vector<String> todasIssues = issue.retornarListaIssues();
		Vector<String> issuesFiltrados = new Vector<String>();
		for(String registro : todasIssues.asArray()){
			if(Integer.parseInt(issue.arquivo.explodirLinhaDoArquivo(registro)[2]) == issue.getIdProjeto()){
				issuesFiltrados.append(registro);
			}
		}
		return issuesFiltrados;
	}

	public Issue buscarIssue(int idIssue) throws IssueNaoEcontradaException {
		Issue issueRetorno = new Issue();
		for (String issu : this.retornarIssuesDoProjeto().asArray()) {
			String[] registro = this.issue.arquivo.explodirLinhaDoArquivo(issu);
			if(Integer.parseInt(registro[0]) == idIssue) {
				issueRetorno.setIdIssue(Integer.parseInt(registro[0]));
				issueRetorno.setIdUsuario(Integer.parseInt(registro[1]));
				issueRetorno.setIdProjeto(Integer.parseInt(registro[2]));
				issueRetorno.setDescricao(registro[3]);
				issueRetorno.setTitulo(registro[4]);
				issueRetorno.setCriticidade(Criticidade.getEnumByDescricao(registro[5]));
				issueRetorno.setTipo(Tipo.getEnumByDescricao(registro[6]));
				issueRetorno.setStatus(Estado.getEnumByDescricao(registro[7]));
				return issueRetorno;
			}
		}
		throw new IssueNaoEcontradaException();
	}
}
