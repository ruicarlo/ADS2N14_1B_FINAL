package app;

import controller.Login;
import exceptions.UsuarioInvalidoException;
import model.Usuario;

public class Final {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Usuario user = new Usuario();
		user.setNome("rui");
		user.setSenha("1234");
		user.setUsername("ruicarlo");
//		user.armazenarUsuarioNoArquivo();
//		System.out.println("teste");

		Login login = new Login();
		try {
			login.autenticaUsuario(user);
		} catch (UsuarioInvalidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
