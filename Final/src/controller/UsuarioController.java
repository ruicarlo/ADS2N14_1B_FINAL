package controller;

import view.UsuarioView;
import estruturas.Vector;
import exceptions.controllers.UsuarioException;
import exceptions.controllers.UsuarioException.*;
import model.Usuario;

public class UsuarioController {
	Usuario user = new Usuario();
	UsuarioView usuarioV = new UsuarioView();

	public void salvarUsuario() throws Exception  {
		this.validarNome();
		this.validarSenha();
		this.validarUsername();
		this.verificarSeUsuarioJaExiste();
		this.user.salvarUsuario();
	}

	private void validarNome() throws Exception {
		if(this.user.getNome().isEmpty()) {
			throw new Exception("Para cadastrar um usu�rio o nome deve ser definido");
		}
	}
	
	private void validarSenha() throws Exception {
		if(this.user.getSenha().isEmpty()) {
			throw new Exception("Para cadastrar um usu�rio a senha deve ser definida");
		}
	}

	private void validarUsername() throws Exception {
		if(this.user.getUsername().isEmpty()) {
			throw new Exception("Para cadastrar um usu�rio a senha deve ser definida");
		}
	}

	public void setUsuario(Usuario usuario) {
		this.user.setNome(usuario.getNome());;
		this.user.setUsername(usuario.getUsername());;
		this.user.setSenha(usuario.getSenha());
	}

    private void verificarSeUsuarioJaExiste() throws Exception {
    	Vector<String> usuarios = this.user.retornarListaUsuarios();
    	if(usuarios.getSize()<1){
    		return;
    	}
    	for(String usuario : usuarios.asArray()) {
    		String[] usuarioAux = this.user.arquivo.explodirLinhaDoArquivo(usuario);
    		if(!usuarioAux[3].isEmpty() && usuarioAux[3].equalsIgnoreCase(this.user.getUsername())) {
    			throw new UsuarioException.UsuarioJaCadastradoException();
    		}
    	}
    }

    public void autenticarUsuario() throws FalhaDeAutenticacaoException {
    	Vector<String> listaUsuarios = this.user.retornarListaUsuarios();

    	if(listaUsuarios.getSize() > 0) {
    		for(String usuario : listaUsuarios.asArray()) {
    			String[] usuarioAux = this.user.arquivo.explodirLinhaDoArquivo(usuario);
    			if(usuarioAux[3].equalsIgnoreCase(this.user.getUsername())
    					&& usuarioAux[2].equalsIgnoreCase(this.user.getSenha())) {
    				this.user.setIdUsuario(Integer.parseInt(usuarioAux[0]));
    				this.user.setNome(usuarioAux[1]);
    				this.user.setSenha(usuarioAux[2]);
    				this.user.setUsername(usuarioAux[3]);
    				return;
    			}
    		}
    	}
    	throw new UsuarioException.FalhaDeAutenticacaoException();
    }

	public Usuario login() throws FalhaDeAutenticacaoException {
		try {
			this.user.setUsername(usuarioV.solicitaLogin());

			try {
				this.user.exists();
				this.user.setSenha(usuarioV.solicitaSenha());
			} catch(Exception e) {
				// caso n�o exista usu�rio
				if(usuarioV.menuLogin() == 1) {
					this.cadastrarUsuario();
				} else {
					return this.login();
				}
			}

			this.autenticarUsuario();
			return this.user;
		} catch (FalhaDeAutenticacaoException fda) {
			usuarioV.printMsgln(fda.getMessage());
			return this.login();
		}
	}

	private void cadastrarUsuario() {
		String dadosUsuario[] = this.usuarioV.formularioCadUsuario();

		this.user.setNome(dadosUsuario[0]);
		this.user.setSenha(dadosUsuario[1]);
		this.user.setUsername(dadosUsuario[2]);

		try {
			this.salvarUsuario();
			this.usuarioV.msgUsuarioCadastrado();
		} catch (Exception e) {
			this.usuarioV.printMsgln(e.getMessage());
			cadastrarUsuario();
		}
	}
}