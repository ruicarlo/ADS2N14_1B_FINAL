package view;

import static java.lang.System.in;
import static java.lang.System.out;

import java.util.Scanner;

import estruturas.Arquivos;

public class PadraoView {
	Scanner teclado;
	Arquivos arquivo;
	
	public PadraoView() {
		this.setTeclado();
		this.arquivo = new Arquivos();
	}

	protected void setTeclado() {
        this.teclado = new Scanner(System.in);
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
}
