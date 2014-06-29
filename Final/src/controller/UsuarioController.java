package controller;

import view.UsuarioView;
import estruturas.Vector;
import exceptions.controllers.UsuarioException;
import exceptions.controllers.UsuarioException.*;
import model.Usuario;

public class UsuarioController {
	Usuario user = new Usuario();
	UsuarioView usuarioV = new UsuarioView();
	
<<<<<<< HEAD
	public void salvarUsuario(String nome, String senha, String username) throws NomeInvalidoException,
	                                                                             SenhaInvalidaException,
	                                                                             UsernameInvalidoException,
	                                                                             UsuarioJaCadastradoException,
	                                                                             Exception {
		this.validarNome(nome);
		this.validarSenha(senha);
		this.validarUsername(username);
		this.verificarSeUsuarioJaExiste(username);
		this.user.setNome(nome);
		this.user.setSenha(senha);
		this.user.setUsername(username);
		this.user.salvarUsuario();
	}

	private void validarNome(String nome) throws NomeInvalidoException {
		if(nome.isEmpty()) {
			throw new UsuarioException.NomeInvalidoException();
		}
	}
	
	private void validarSenha(String senha) throws SenhaInvalidaException {
		if(senha.isEmpty()) {
			throw new UsuarioException.SenhaInvalidaException();
		}
	}

	private void validarUsername(String username) throws UsernameInvalidoException {
		if(username.isEmpty()) {
			throw new UsuarioException.UsernameInvalidoException();
		}
	}

    private void verificarSeUsuarioJaExiste(String username) throws UsuarioJaCadastradoException {
=======
	public void salvarUsuario() throws Exception {
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
>>>>>>> origin/master
    	Vector<String> usuarios = this.user.retornarListaUsuarios();
    	if(usuarios.getSize()<1){
    		return;
    	}
    	for(String usuario : usuarios.asArray()) {
    		String[] usuarioAux = this.user.arquivo.explodirLinhaDoArquivo(usuario);
<<<<<<< HEAD
    		if(!usuarioAux[3].isEmpty() && usuarioAux[3].equalsIgnoreCase(username)) {
    			throw new UsuarioException.UsuarioJaCadastradoException();
=======
    		if(!usuarioAux[3].isEmpty() && usuarioAux[3].equalsIgnoreCase(this.user.getUsername())) {
    			throw new Exception("Este usu�rio j� est� cadastrado no sistema");
>>>>>>> origin/master
    		}
    	}
    }

    public Usuario autenticarUsuario(String username, String senha) throws FalhaDeAutenticacaoException {
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
    	throw new UsuarioException.FalhaDeAutenticacaoException();
    }

	public void login() {
		try {
			String dadosUsuario[] = usuarioV.solicitaLogin();

			this.autenticarUsuario(dadosUsuario[2], dadosUsuario[1]);

			usuarioV.printMsgln("Logado");
		} catch (UsuarioInvalidoException uI) {
			usuarioV.printMsg(uI.getMessage());

			if(usuarioV.menuLogin() == 1) {
				this.cadastrarUsuario();
			}

			this.login();
		}
	}

	private void cadastrarUsuario() {
		String dadosUsuario[] = this.usuarioV.formularioCadUsuario();

		this.user.setNome(dadosUsuario[0]);
		this.user.setSenha(dadosUsuario[1]);
		this.user.setUsername(dadosUsuario[2]);

		try {
			this.salvarUsuario();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}