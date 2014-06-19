package app;

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
		user.armazenarUsuarioNoArquivo();
System.out.println("teste");
	}

}
