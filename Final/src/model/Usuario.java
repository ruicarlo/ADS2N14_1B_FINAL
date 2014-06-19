package model;

import controller.ArquivosController;

public class Usuario {
	final String nomeArquivo = "data/usuarios.txt";
	private String nome;
	private String senha;
	private String username;

	public String getNome() {
		return nome;
	}
	public String getNomeArquivo() {
		return this.nomeArquivo;
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

    private String getDadosParaSalvarArquivo() {
        return String.format("%s##%s##%s", this.nome, this.senha, this.username);
    }

    public void salvarUsuario() throws Exception {
    	this.getDadosParaSalvarArquivo();
    }

    public void armazenarUsuarioNoArquivo() {
        ArquivosController arquivo = new ArquivosController(this.nomeArquivo);
        String[] conteudo = {this.getDadosParaSalvarArquivo()}; 
        arquivo.escrever(conteudo, true);
    }
}
