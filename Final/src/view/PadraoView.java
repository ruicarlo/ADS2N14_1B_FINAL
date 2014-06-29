package view;

import static java.lang.System.in;
import static java.lang.System.out;

import java.util.Scanner;

public class PadraoView {
	Scanner teclado;

	public PadraoView() {
		this.setTeclado();
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
