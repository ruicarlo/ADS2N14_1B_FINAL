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
			System.out.println("Issue criada com sucesso.");
			//chamar o metodo criarIssue
		}
		else if(eventoV.menuEvento() == 2){
			System.out.println("Usuario" + "userX" + "marcou a issue como valida.");
			//chamar o metodo marcarIssueComoValida
		}
		else if(eventoV.menuEvento() == 3){
			System.out.println("Usuario" + "userX" + "alterou a criticidade para " + "criticidadeY");
			//chamar o metodo alterarCriticidade
		}
		else if(eventoV.menuEvento() == 4){
			System.out.println("Usuario" + "userX" + "alterou o tipo para " + "tipoY");
			//chamar o metodo alterarTipo
		}
		else if(eventoV.menuEvento() == 5){
			System.out.println("Comentario inserido com sucesso.");
			//chamar o metodo inserirComentario
		}
		else if(eventoV.menuEvento() == 6){
			System.out.println("Issue atribuida para usuario " + "userX");
			//chamar o metodo atribuirIssue
		}
		else if(eventoV.menuEvento() == 7){
			System.out.println("Desenvolvimento iniciado.");
			//chamar o metodo iniciarDesenvolvimento
		}
		else if(eventoV.menuEvento() == 8){
			System.out.println("commentsToUserX" + " - "+ "Issue marcada como duplicado pelo usuario" + "userX");
			//chamar o metodo marcarComoDuplicado 
		}
		else if(eventoV.menuEvento() == 9){
			System.out.println("Issue finalizada.");
			//chamar o metodo fecharIssue 
		}
		else if(eventoV.menuEvento() == 10){
			System.out.println("Issue marcada como Wont Fix");
			//chamar o metodo marcarWontFix 
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
