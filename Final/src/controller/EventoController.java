package controller;

import exceptions.controllers.EventoException;
import exceptions.controllers.EventoException.*;
import exceptions.controllers.UsuarioException;
import exceptions.controllers.UsuarioException.*;
import model.Issue;
import model.Usuario;
import model.Evento;

public class EventoController {
	Evento evento = new Evento();
	
	public void salvarEvento() throws Exception {
		this.validarComentario();
		this.validarData();
		this.validarIdIssue();
		this.validarUsuario();
		this.evento.armazenarEventoNoArquivo();
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

	public void setUsuario(Usuario usuario) throws UsuarioInvalidoException {
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
