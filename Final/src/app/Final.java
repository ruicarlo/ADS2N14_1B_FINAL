package app;

import static java.lang.System.out;
import model.Usuario;
import controller.ProjetoController;
import controller.UsuarioController;
import exceptions.controllers.UsuarioException.*;

public class Final {

	public static void main(String[] args) throws FalhaDeAutenticacaoException, Exception {
		Usuario usuarioLogado = new Usuario();
		out.println("Sistema de Issues!");

		/* LOGIN */
		UsuarioController usuarioC = new UsuarioController();
		usuarioLogado = usuarioC.login();

		while (true) {
			ProjetoController projetoC = new ProjetoController(usuarioLogado);
			projetoC.telaInicialApp();
		}
	}

}
