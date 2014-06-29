package controller;

import view.EventoView;
import exceptions.controllers.EventoException;
import exceptions.controllers.EventoException.*;
import exceptions.controllers.UsuarioException;
import model.Issue;
import model.Usuario;
import model.Evento;

public class EventoController {
	Evento evento = new Evento();
	EventoView eventoV = new EventoView();
	public void salvarEvento() throws Exception {
		this.validarComentario();
		this.validarData();
		this.validarIdIssue();
		this.validarUsuario();
		this.evento.armazenarEventoNoArquivo();
	}

	public void menuEventoController(){
		if(eventoV.menuEvento() == 1) {
			//chamar o metodo criarIssue
			eventoV.msgIssueCriada();
		}
		else if(eventoV.menuEvento() == 2){
			//chamar o metodo marcarIssueComoValida
			eventoV.msgMarcouIssueValida();
		}
		else if(eventoV.menuEvento() == 3){
			//chamar o metodo alterarCriticidade
			eventoV.msgCriticidadeAlterada();
		}
		else if(eventoV.menuEvento() == 4){
			//chamar o metodo alterarTipo
			eventoV.msgTipoAlterado();
		}
		else if(eventoV.menuEvento() == 5){
			//chamar o metodo inserirComentario
			eventoV.msgComentarioInserido();
		}
		else if(eventoV.menuEvento() == 6){
			//chamar o metodo atribuirIssue
			eventoV.msgIssueAtribuida();
		}
		else if(eventoV.menuEvento() == 7){
			//chamar o metodo iniciarDesenvolvimento
			eventoV.msgDesenvolvimentoIniciado();
		}
		else if(eventoV.menuEvento() == 8){
			//chamar o metodo marcarComoDuplicado
			eventoV.msgMarcarComoDuplicado();
		}
		else if(eventoV.menuEvento() == 9){
			//chamar o metodo fecharIssue 
			eventoV.msgIssueFechada();
		}
		else if(eventoV.menuEvento() == 10){
			//chamar o metodo marcarWontFix 
			eventoV.msgMarcadaComoWontFix();
		}

		
	}
	private void validarData() throws DataInvalidaException {
		if(this.evento.getData() == null || this.evento.getData().equals("")) {
			throw new EventoException.DataInvalidaException();
		}
	}
	
	private void validarComentario() throws ComentarioInvalidoException {
		if(this.evento.getComentario() == null || this.evento.getComentario().equals("")) {
			throw new EventoException.ComentarioInvalidoException();
		}
	}

	private void validarIdIssue() throws IssueInvalidoException {
		if(this.evento.getIdIssue() < 1) {
			throw new EventoException.IssueInvalidoException();
		}
	}
	
	private void validarUsuario() throws exceptions.controllers.EventoException.UsuarioInvalidoException  {
		if(this.evento.getIdUsuario() < 1) {
			throw new EventoException.UsuarioInvalidoException();
		}
	}
	
	public int getIdIssue() {
		return this.evento.getIdIssue();
	}

	public void setIssue(Issue issue) throws Exception {
		this.evento.setIdIssue(issue.getIdIssue());
		this.validarIdIssue();
	}

	public int getIdUsuario() {
		return this.evento.getIdUsuario();
	}

	public void setUsuario(Usuario usuario) throws UsuarioException.UsuarioInvalidoException {
		usuario.exists();
		this.evento.setIdUsuario(usuario.getIdUsuario());
	}

	public int getIdEvento() {
		return this.evento.getIdEvento();
	}

	public String getData() {
		return this.evento.getData();
	}
	
	public void setData(String data) throws DataInvalidaException {
		this.evento.setData(data);
		this.validarData();
	}
	
	public String getComentario() {
		return this.evento.getComentario();
	}
	
	public void setComentario(String comentario) throws ComentarioInvalidoException {
		this.evento.setComentario(comentario);
		this.validarComentario();
	}
}
