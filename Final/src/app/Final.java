package app;

import static java.lang.System.out;
import model.Projeto;
import model.Usuario;
import controller.IssueController;
//import controller.IssueController;
import controller.ProjetoController;
import controller.UsuarioController;
import exceptions.controllers.UsuarioException.*;

/**
 * Classe Final responsavel por cadastrar usuarios e efetuar login.
 */
public class Final {

	public static void main(String[] args) throws FalhaDeAutenticacaoException, Exception {
		Usuario usuarioLogado = new Usuario();
		out.println("Sistema de Issues!");

		/* LOGIN */
		UsuarioController usuarioC = new UsuarioController();
		usuarioLogado = usuarioC.login();

		while (true) {
			ProjetoController projetoC = new ProjetoController(usuarioLogado);
			Projeto projeto = projetoC.telaInicialApp();
			
			IssueController issueC = new IssueController(projeto);
			issueC.gerenciarIssues();
		}
	}

}
