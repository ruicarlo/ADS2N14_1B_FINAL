package model;

import estruturas.Arquivos;
import estruturas.Vector;
import exceptions.UsuarioInvalidoException;

public class Usuario {
	final String nomeArquivo = "data/usuarios.txt";
	private int idUsuario;
	private String nome;
	private String senha;
	private String username;

	public Arquivos arquivo = new Arquivos(this.nomeArquivo);

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
        Arquivos arquivo = new Arquivos(this.nomeArquivo);
        String[] conteudo = {this.getDadosParaSalvarArquivo()}; 
        arquivo.escrever(conteudo, false);
    }

    private int getProximoIdUsuario() {
    	return new Arquivos(this.nomeArquivo).getRegistros().getSize()+1;
    }

	public Vector<String> retornarListaUsuarios() {
    	return this.arquivo.getRegistros();
	}

    public void exists() throws UsuarioInvalidoException {
    	Vector<String> usuarios = this.retornarListaUsuarios();
    	if(usuarios.getSize()>0) {
	    	for(String usuario : usuarios.asArray()) {
	    		String[] usuarioAux = this.arquivo.explodirLinhaDoArquivo(usuario);
	    		if(usuarioAux[0].equals(Integer.toString(idUsuario))) {
	    			return;
	    		}
	    	}
    	}
    	throw new UsuarioInvalidoException("Este usuário não está cadastrado no sistema.");
    }
}