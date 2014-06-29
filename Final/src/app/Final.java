package app;

import static java.lang.System.out;
import controller.UsuarioController;

/**
 * Classe Final responsavel por cadastrar usuarios e efetuar login.
 */
public class Final {

	public static void main(String[] args) {
		out.println("Sistema de Issues!");

		/* LOGIN */
		UsuarioController usuarioC = new UsuarioController();
		usuarioC.login();
	}

}
