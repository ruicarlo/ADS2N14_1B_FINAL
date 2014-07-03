package view;

import static java.lang.System.in;
import static java.lang.System.out;

import java.util.Scanner;

import estruturas.Arquivos;
import estruturas.Vector;

public class PadraoView {
	Scanner teclado;
	Arquivos arquivo;
	
	public PadraoView() {
		this.setTeclado();
		this.arquivo = new Arquivos();
	}

	public void setTeclado() {
        this.teclado = new Scanner(in);
    }

	public void printMsg(String msg) {
		out.print(msg);
	}

	public void printMsgln(String msg) {
		out.println(msg);
	}
	
	public String lerString() {
		return teclado.nextLine();
	}
	
	public int lerInt() {
		return teclado.nextInt();
	}
	private boolean verificaSePosicaoUsada(int posicao, int[]posicoes) {
		for(int i=0; i<posicoes.length;i++) {
			if(posicao==posicoes[i]) {
				return true;
			}
		}
		return false;
	}
	public int verificarMaiorTexto(Vector<String> tabela, int[] posicoes) {
		int maior = 0;
		for(String item : tabela.asArray()) {
			String[] registro = arquivo.explodirLinhaDoArquivo(item);
			for(int i=0; i<registro.length;i++ ) {
				if(registro[i].length() > maior && verificaSePosicaoUsada(i, posicoes)) {
					maior = registro[i].length();
				}
			}
		}
		return maior;
	}
}
