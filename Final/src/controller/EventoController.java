package controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import view.EventoView;
import estruturas.Vector;
import exceptions.controllers.EventoException;
import exceptions.controllers.EventoException.*;
import exceptions.controllers.UsuarioException;
import model.Issue;
import model.Usuario;
import model.Evento;

public class EventoController {
	Evento evento = new Evento();
	EventoView eventoV = new EventoView();

	Usuario usuario = new Usuario();
	private String dataHora;
		
	public EventoController(Issue issue, Usuario usuario) throws Exception{
		this.setIssue(issue);
		this.setUsuario(usuario);
	}
	
	public String dataHora(){
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Date date = new Date();
		dataHora = dateFormat.format(date);
		return dataHora;
	}

	public void salvarEvento() throws Exception {
		this.validarComentario();
		this.validarData();
		this.validarIdIssue();
		this.validarUsuario();
		this.evento.armazenarEventoNoArquivo();
	}
	
	public void eventoCriarIssue() throws Exception{
		this.setComentario(eventoV.getMsgIssueCriada());
		this.setData(this.dataHora());
		this.salvarEvento();
		eventoV.msgIssueCriada();
	}
	
	public void eventoMarcarIssueValida() throws Exception{
		this.setComentario(eventoV.getMsgMarcouIssueValida());
		this.setData(this.dataHora());
		this.salvarEvento();
		eventoV.msgMarcouIssueValida();
	}
	
	public void eventoAlterarCriticidade() throws Exception{
		this.setComentario(eventoV.getMsgCriticidadeAlterada());
		this.setData(this.dataHora());
		this.salvarEvento();
		eventoV.msgCriticidadeAlterada();
	}
	
	public void eventoAlterarTipo() throws Exception{
		this.setComentario(eventoV.getMsgTipoAlterado());
		this.setData(this.dataHora());
		this.salvarEvento();
		eventoV.msgTipoAlterado();
	}
	
	public void eventoInserirComentario() throws Exception{
		this.setComentario(eventoV.getMsgComentarioInserido());
		this.setData(this.dataHora());
		this.salvarEvento();
		eventoV.msgComentarioInserido();
	}
	
	public void eventoAtribuirIssue() throws Exception {
		this.setComentario(eventoV.getMsgIssueAtribuida());
		this.setData(this.dataHora());
		this.salvarEvento();
		eventoV.msgIssueAtribuida();
	}
	
	public void eventoIniciarDesenvolvimento() throws Exception{
		this.setComentario(eventoV.getMsgDesenvolvimentoIniciado());
		this.setData(this.dataHora());
		this.salvarEvento();
		eventoV.msgDesenvolvimentoIniciado();
	}
	
	public void eventoMarcarComoDuplicado() throws Exception{
		this.setComentario(eventoV.getMsgMarcarComoDuplicado());
		this.setData(this.dataHora());
		this.salvarEvento();
		eventoV.msgMarcarComoDuplicado();
	}
	
	public void eventoFecharIssue() throws Exception{
		this.setComentario(eventoV.getMsgIssueFechada());
		this.setData(this.dataHora());
		this.salvarEvento();
		eventoV.msgIssueFechada();
	}
	
	public void eventoMarcarComoWontFix() throws Exception{
		this.setComentario(eventoV.getMsgMarcadaComoWontFix());
		this.setData(this.dataHora());
		this.salvarEvento();
		eventoV.msgMarcadaComoWontFix();
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

	public void setUsuario(Usuario usuarioC) throws UsuarioException.UsuarioInvalidoException {
		usuarioC.exists();
		this.evento.setIdUsuario(usuarioC.getIdUsuario());
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

	public void visualizarEventos() {
		Vector<String> listaEventos = this.retornarListaEventosDaIssue();
		eventoV.imprimirListaDeEventos(listaEventos);
	}

	private Vector<String> retornarListaEventosDaIssue() {
		Vector<String> todosEventos = evento.retornarListaEventos();
		Vector<String> projetosFiltrados = new Vector<String>();
		for(String registro : todosEventos.asArray()){
			if(Integer.parseInt(evento.arquivo.explodirLinhaDoArquivo(registro)[1]) == evento.getIdIssue()){
				projetosFiltrados.append(registro);
			}
		}
		return projetosFiltrados;
	}
}
