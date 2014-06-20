package app;

import model.Usuario;
import controller.Login;
import controller.UsuarioController;
import exceptions.UsuarioInvalidoException;


public class Final {

	public static void main(String[] args) {

		/*BLOCO PARA CADASTRAR USUARIOS*/
		UsuarioController user = new UsuarioController();
		try {
			user.salvarUsuario("jolie", "jolie2014","jolizinha");
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}

		/*BLOCO PARA TESTAR LOGIN*/
		Login login = new Login();
		try {
			login.setUsername("jolizinha");
			login.setSenha("jolie2014");
			Usuario usuario = login.autenticarUsuario();
			System.out.println(String.format("ID: %d - Nome: %s - Senha: %s - Username: %s", usuario.getIdUsuario(),
					                                                                         usuario.getNome(),
					                                                                         usuario.getSenha(),
					                                                                         usuario.getUsername()));
		} catch (UsuarioInvalidoException e) {
			System.out.println(e.getMessage());
		}
	}

}
