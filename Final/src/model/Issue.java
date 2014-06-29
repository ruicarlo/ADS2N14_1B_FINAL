package model;

import estruturas.Arquivos;
import estruturas.Vector;

public class Issue {
	final String nomeArquivo = "data/issues.txt";
	private int idIssue;
	private int idUsuario;
	private int idProjeto;
	private String descricao;
	private String titulo;
	private Criticidade criticidade;
	private Tipo tipo;
	private Estado status;
	
	public Arquivos arquivo = new Arquivos(this.nomeArquivo);

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
	
	public Criticidade getCriticidade() {
		return criticidade;
	}
	
	public void setCriticidade(Criticidade criticidade) {
		this.criticidade = criticidade;
	}
	
	public Tipo getTipo() {
		return tipo;
	}
	
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	
	public Estado getStatus() {
		return status;
	}
	
	public void setStatus(Estado status) {
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
        Arquivos arquivo = new Arquivos(this.nomeArquivo);
        String[] conteudo = {this.getDadosParaSalvarArquivo()}; 
        arquivo.escrever(conteudo, false);
    }

    private int getProximoIdIssue() {
    	return new Arquivos(this.nomeArquivo).getRegistros().getSize()+1;
    }

	public Vector<String> retornarListaIssues() {
    	return this.arquivo.getRegistros();
	}	
}