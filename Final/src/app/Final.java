package app;

import view.AppView;
import model.Usuario;
import controller.ProjetoController;
import controller.UsuarioController;
import exceptions.controllers.UsuarioException.*;

public class Final {

	public static void main(String[] args) throws FalhaDeAutenticacaoException, Exception {
		AppView appV = new AppView();
		appV.telaInicial();

		/* LOGIN */
		UsuarioController usuarioC = new UsuarioController();
		Usuario usuarioLogado = new Usuario();
		
		usuarioLogado = usuarioC.login();
		ProjetoController projetoC = new ProjetoController(usuarioLogado);

		appV.imprimirMsgBemVindo(usuarioLogado.getNome());
		
		while (true) {
			projetoC.telaInicialApp();
		}
	}

}
