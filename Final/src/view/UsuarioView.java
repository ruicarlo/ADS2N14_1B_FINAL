package view;

public class UsuarioView extends PadraoView {

	public String solicitaLogin() {

		printMsg("Usuário: ");
		String username = lerString();

		return username;
	}

	public String solicitaSenha() {

		printMsg("Senha: ");
		String senha = lerString();

		return senha;
	}

	public int menuLogin() {
		printMsgln("Usuário não cadastrado.");
		printMsgln("Deseja cadastrar novo usuário? (sim/nao)");
		printMsg("Para tentar o login novamente escolha \"nao\".");
		String opcao = lerString(); 

		switch (opcao.toLowerCase()) {
			case "sim":
				return 1;

			case "nao":
				return 0;
	
			default:
				printMsgln("Opção inválida!");
				return menuLogin();
		}
	}

	public String[] formularioCadUsuario() {
		String[] dadosUsuario = new String[3];

		printMsgln("..::Cadastro de Usuario::..");

		printMsg("Nome:");
		dadosUsuario[0] = lerString();
		printMsg("Usuário:");
		dadosUsuario[2] = lerString();
		printMsg("Senha:");
		dadosUsuario[1] = lerString();

		return dadosUsuario;
	}

	public void msgUsuarioCadastrado() {
		printMsgln("Usuário cadastrado com sucesso.");
	}
}
