package app;

import static java.lang.System.out;
import controller.UsuarioController;
<<<<<<< HEAD
import exceptions.controllers.UsuarioException.*;
=======
>>>>>>> origin/master

/**
 * Classe Final responsavel por cadastrar usuarios e efetuar login.
 */
public class Final {

<<<<<<< HEAD
	public static void main(String[] args) throws FalhaDeAutenticacaoException {

		/*BLOCO PARA CADASTRAR USUARIOS*/

		UsuarioController user = new UsuarioController();
		try {
			user.salvarUsuario("jolie", "jolie2014","jolizinha");
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}

		/*BLOCO PARA TESTAR LOGIN*/

		try {
			Usuario usuario = user.autenticarUsuario("jolizinha", "jolie2014");
			System.out.println(String.format("ID: %d - Nome: %s - Senha: %s - Username: %s", usuario.getIdUsuario(),
					                                                                         usuario.getNome(),
					                                                                         usuario.getSenha(),
					                                                                         usuario.getUsername()));
		} catch (FalhaDeAutenticacaoException e) {
			System.out.println(e.getMessage());
		}

=======
	public static void main(String[] args) {
		out.println("Sistema de Issues!");

		/* LOGIN */
		UsuarioController usuarioC = new UsuarioController();
		usuarioC.login();
>>>>>>> origin/master
	}

}
