package view;

public class AppView extends PadraoView {
	public void telaInicial() {
		printMsgln("..::Sistema de Issues::..");	
	}

	public void imprimirMsgBemVindo(String nomeUsuario) {
		printMsgln(String.format("Bem-vindo %s", nomeUsuario));
	}
}
