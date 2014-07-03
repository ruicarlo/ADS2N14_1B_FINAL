package view;

public class UsuarioView extends PadraoView {

	public String solicitaLogin() {

		printMsg("Usu�rio: ");
		String username = lerString();

		return username;
	}

	public String solicitaSenha() {

		printMsg("Senha: ");
		String senha = lerString();

		return senha;
	}

	public int menuLogin() {
		printMsgln("Usu�rio n�o cadastrado.");
		printMsgln("Deseja cadastrar novo usu�rio? (sim/nao)");
		printMsg("Para tentar o login novamente escolha \"nao\".");
		String opcao = lerString(); 

		switch (opcao.toLowerCase()) {
			case "sim":
				return 1;

			case "nao":
				return 0;
	
			default:
				printMsgln("Op��o inv�lida!");
				return menuLogin();
		}
	}

	public String[] formularioCadUsuario() {
		String[] dadosUsuario = new String[3];

		printMsgln("..::Cadastro de Usuario::..");

		printMsg("Nome:");
		dadosUsuario[0] = lerString();
		printMsg("Usu�rio:");
		dadosUsuario[2] = lerString();
		printMsg("Senha:");
		dadosUsuario[1] = lerString();

		return dadosUsuario;
	}

	public void msgUsuarioCadastrado() {
		printMsgln("Usu�rio cadastrado com sucesso.");
	}
}
