package controller;

import model.Usuario;
import estruturas.Vector;
import exceptions.UsuarioInvalidoException;


public class Login {
	public Usuario autenticaUsuario(Usuario user) throws UsuarioInvalidoException {
		ArquivosController arquivo = new ArquivosController(user.getNomeArquivo());
		Vector<String> usuarios = new Vector<String>();

		usuarios = arquivo.getRegistros();

		if (usuarios.getSize() > 0) {
			for (String usuario : usuarios.asArray()) {
				String[] usuAux = usuario.split("##");

				if (user.getUsername().equals(usuAux[2])
						&& user.getSenha().equals(usuAux[1])
				) {
					user.setNome(usuAux[0]);
					return user;
				}
			}
		}

		throw new UsuarioInvalidoException();
	}
}