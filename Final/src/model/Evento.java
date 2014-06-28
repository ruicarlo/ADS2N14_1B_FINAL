package model;

import estruturas.Arquivos;
import estruturas.Vector;

public class Evento {
	final String nomeArquivo = "data/eventos.txt";
	
	private String data;
	private String comentario;
	private int idEvento;
	private int idIssue;
	private int idUsuario;
	
	public Arquivos arquivo = new Arquivos(this.nomeArquivo);

	public String getNomeArquivo() {
		return this.nomeArquivo;
	}

	public int getIdEvento() {
		return idEvento;
	}
	public void setIdEvento(int idEvento) {
		this.idEvento = idEvento;
	}
	public int getIdIssue() {
		return idIssue;
	}
	public void setIdIssue(int idIssue) {
		this.idIssue = idIssue;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

    private String getDadosParaSalvarArquivo() {
        return String.format("%d##%d##%d##%s##%s",this.getProximoIdEvento(),
        		                                  this.idIssue,
                                                  this.idUsuario,
        		                                  this.data,
        		                                  this.comentario);
    }

    public void armazenarIssueNoArquivo() {
        Arquivos arquivo = new Arquivos(this.nomeArquivo);
        String[] conteudo = {this.getDadosParaSalvarArquivo()};
        arquivo.escrever(conteudo, false);
    }

    private int getProximoIdEvento() {
    	return new Arquivos(this.nomeArquivo).getRegistros().getSize()+1;
    }

	public Vector<String> retornarListaEventos() {
    	return this.arquivo.getRegistros();
	}
}