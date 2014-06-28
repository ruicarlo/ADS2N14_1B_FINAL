package model;

import controller.ArquivosController;
import estruturas.Vector;

public class Issue {
	final String nomeArquivo = "data/issues.txt";
	private int idIssue;
	private int idUsuario;
	private int idProjeto;
	private String descricao;
	private String titulo;
	private String criticidade;
	private String tipo;
	private String status;
	
	public ArquivosController arquivo = new ArquivosController(this.nomeArquivo);

	public int getIdProjeto() {
		return idProjeto;
	}

	public void setIdProjeto(int idProjeto) {
		this.idProjeto = idProjeto;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getIdIssue() {
		return idIssue;
	}

	public void setIdIssue(int idIssue) {
		this.idIssue = idIssue;
	}

	public String getNomeArquivo() {
		return this.nomeArquivo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getCriticidade() {
		return criticidade;
	}
	
	public void setCriticidade(String criticidade) {
		this.criticidade = criticidade;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}

    private String getDadosParaSalvarArquivo() {
        return String.format("%d##%d##%d##%s##%s##%s##%s##%s", this.getProximoIdIssue(), 
        		                                               this.idUsuario,
                                                               this.idProjeto,
        		                                               this.descricao,
        		                                               this.titulo,
        		                                               this.criticidade,
        		                                               this.tipo,
        		                                               this.status);
    }

    public void armazenarIssueNoArquivo() {
        ArquivosController arquivo = new ArquivosController(this.nomeArquivo);
        String[] conteudo = {this.getDadosParaSalvarArquivo()}; 
        arquivo.escrever(conteudo, false);
    }

    private int getProximoIdIssue() {
    	return new ArquivosController(this.nomeArquivo).getRegistros().getSize()+1;
    }

	public Vector<String> retornarListaIssues() {
    	return this.arquivo.getRegistros();
	}	
}