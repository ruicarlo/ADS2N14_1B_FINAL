package view;

public class Tabela extends PadraoView {
	private int tamanhoColuna = 0;
	private String desenhoLinha = "";
	private final String inicio = "+";
	private final String linha  = "-";

	public Tabela(int maiorTexto) {
		this.tamanhoColuna = maiorTexto;
	}
	
	private void setDesenhoLinha() {
		this.desenhoLinha = "";

		for(int i=0; i<this.tamanhoColuna+2; i++) {
			this.desenhoLinha += this.linha;
		}
		this.desenhoLinha += this.inicio;
	}

	private String getDesenhoLinha(boolean esquerda) {
		return (esquerda ? this.inicio : "") + this.desenhoLinha;
	}

	public void printLinha(int iColunas) {
		this.setDesenhoLinha();
		String conteudoLinhas = "";
		for(int i=0; i<iColunas; i++) {
			conteudoLinhas += this.getDesenhoLinha(i==0);
		}
		printMsgln(conteudoLinhas);
	}

	public void printCelula(String valor, boolean primeiraColuna, boolean novaLinha) {
		for(int i=valor.length(); i< this.tamanhoColuna; i++) {
			valor += " ";
		}
		valor = (primeiraColuna ? "| " : " ") + valor + " |";
		if(novaLinha) {
			printMsgln(valor);	
		} else {
			printMsg(valor);
		}
	}
}