package model;

import estruturas.Arquivos;
import estruturas.Vector;

public class Projeto {
	final String nomeArquivo = "data/projetos.txt";
	private int idProjeto;
	private int idCriador;
	private String titulo;
	private String descricao;

	public Arquivos arquivo = new Arquivos(this.nomeArquivo);

	public int getIdCriador() {
		return idCriador;
	}

	public void setIdCriador(int idCriador) {
		this.idCriador = idCriador;
	}

	public int getIdProjeto() {
		return idProjeto;
	}

	public void setIdProjeto(int idProjeto) {
		this.idProjeto = idProjeto;
	}

	public String getNomeArquivo() {
		return this.nomeArquivo;
	}

	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

    private String getDadosParaSalvarArquivo() {
        return String.format("%d##%d##%s##%s", this.getProximoIdProjeto(),
        		                              this.idCriador,
        		                              this.titulo,
        		                              this.descricao);
    }

    public void armazenarProjetoNoArquivo() {
        Arquivos arquivo = new Arquivos(this.nomeArquivo);
        String[] conteudo = {this.getDadosParaSalvarArquivo()}; 
        arquivo.escrever(conteudo, false);
    }

    private int getProximoIdProjeto() {
    	return new Arquivos(this.nomeArquivo).getRegistros().getSize()+1;
    }

	public Vector<String> retornarListaProjetos() {
    	return this.arquivo.getRegistros();
	}
}