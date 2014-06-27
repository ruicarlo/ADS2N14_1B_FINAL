package controller;

import estruturas.Vector;
import exceptions.UsuarioInvalidoException;
import model.Usuario;

public class UsuarioController {
	Usuario user = new Usuario();
	
	public void salvarUsuario(String nome, String senha, String username) throws Exception {
		this.validarNome(nome);
		this.validarSenha(senha);
		this.validarUsername(username);
		this.verificarSeUsuarioJaExiste(username);
		this.user.setNome(nome);
		this.user.setSenha(senha);
		this.user.setUsername(username);
		this.user.salvarUsuario();
	}

	private void validarNome(String nome) throws Exception {
		if(nome.isEmpty()) {
			throw new Exception("Para cadastrar um usu�rio o nome deve ser definido");
		}
	}
	
	private void validarSenha(String senha) throws Exception {
		if(senha.isEmpty()) {
			throw new Exception("Para cadastrar um usu�rio a senha deve ser definida");
		}
	}

	private void validarUsername(String username) throws Exception {
		if(username.isEmpty()) {
			throw new Exception("Para cadastrar um usu�rio a senha deve ser definida");
		}
	}

    private void verificarSeUsuarioJaExiste(String username) throws Exception {
    	Vector<String> usuarios = this.user.retornarListaUsuarios();
    	if(usuarios.getSize()<1){
    		return;
    	}
    	for(String usuario : usuarios.asArray()) {
    		String[] usuarioAux = this.user.arquivo.explodirLinhaDoArquivo(usuario);
    		if(!usuarioAux[3].isEmpty() && usuarioAux[3].equalsIgnoreCase(username)) {
    			throw new Exception("Este usu�rio j� est� cadastrado no sistema");
    		}
    	}
    }

    public Usuario autenticarUsuario(String username, String senha) throws UsuarioInvalidoException {
    	Vector<String> listaUsuarios = this.user.retornarListaUsuarios();

    	if(listaUsuarios.getSize() > 0) {
    		for(String usuario : listaUsuarios.asArray()) {
    			String[] usuarioAux = this.user.arquivo.explodirLinhaDoArquivo(usuario);
    			if(usuarioAux[3].equalsIgnoreCase(username) && usuarioAux[2].equalsIgnoreCase(senha)) {
    				this.user.setIdUsuario(Integer.parseInt(usuarioAux[0]));
    				this.user.setNome(usuarioAux[1]);
    				this.user.setSenha(usuarioAux[2]);
    				this.user.setUsername(usuarioAux[3]);
    				return this.user;
    			}
    		}
    	}
    	throw new UsuarioInvalidoException();
    }
}