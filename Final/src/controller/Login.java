package controller;

import model.Usuario;
import controller.UsuarioController;
import exceptions.UsuarioInvalidoException;

public class Login {
	String username;
	String senha;

	public void setUsername(String username) {
		this.username = username;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Usuario autenticarUsuario() throws UsuarioInvalidoException {
		UsuarioController usuario = new UsuarioController();
		try {
			return usuario.autenticarUsuario(this.username, this.senha);
		} catch(UsuarioInvalidoException e) {
			throw new UsuarioInvalidoException();
		}
	}
}