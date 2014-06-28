package app;

import model.Usuario;
import controller.IssueController;
import controller.UsuarioController;
import exceptions.UsuarioInvalidoException;

/**
 * Classe Final responsavel por cadastrar usuarios e efetuar login.
 */
public class Final {

	public static void main(String[] args) {

		/*BLOCO PARA CADASTRAR ISSUE*/
		IssueController issue = new IssueController();
		try {
			issue.setCriticidade("Alta");
			issue.setDescricao("Criar sistema de issue de acordo com a solicitacao");
			issue.setIdProjeto(1);
			issue.setIdUsuario(1);
			issue.setStatus("N");
			issue.setTipo("B");
			issue.setTitulo("Sistema de issues");
			issue.salvarIssue();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}

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
		} catch (UsuarioInvalidoException e) {
			System.out.println(e.getMessage());
		}

	}

}
