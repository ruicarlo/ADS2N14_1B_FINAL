package model;

import controller.ArquivosController;
import estruturas.Vector;

public class Usuario {
	final String nomeArquivo = "data/usuarios.txt";
	private int idUsuario;
	private String nome;
	private String senha;
	private String username;

	public ArquivosController arquivo = new ArquivosController(this.nomeArquivo);

    public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNomeArquivo() {
		return nomeArquivo;
	}

	private String getDadosParaSalvarArquivo() {
        return String.format("%d##%s##%s##%s", this.getProximoIdUsuario(), 
        		                               this.nome,
        		                               this.senha,
        		                               this.username);
    }

    public void salvarUsuario() throws Exception {
    	this.armazenarUsuarioNoArquivo();
    	
    }

    private void armazenarUsuarioNoArquivo() {
        ArquivosController arquivo = new ArquivosController(this.nomeArquivo);
        String[] conteudo = {this.getDadosParaSalvarArquivo()}; 
        arquivo.escrever(conteudo, false);
    }

    private int getProximoIdUsuario() {
    	return new ArquivosController(this.nomeArquivo).getRegistros().getSize()+1;
    }

	public Vector<String> retornarListaUsuarios() {
    	return this.arquivo.getRegistros();
	}
}