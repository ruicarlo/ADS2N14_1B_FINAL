package view;

import java.util.Scanner;
import java.util.InputMismatchException;

import estruturas.Vector;

public class ProjetoView extends PadraoView {
	String[] dadosProjeto = new String[2];	
	
	public void imprimirSelecioneComando() {
    	printMsg("Selecione um comando (L para Listar Projetos, C para Cadastrar Novo Projeto: ");
    }

    public void imprimirDigiteTitulo() {
    	printMsg("Digite o titulo do projeto: ");
    }

    public void imprimirDigiteDescricao() {
    	printMsg("Digite a descricao do projeto: ");
    }

    public void imprimirDigiteTaxa() {
    	printMsg("Digite a taxa de investimento: ");
    }


    public int lerNumeroConta() {
        int numConta = 0;
        boolean validado = false;

        do {
            try {
                this.imprimirDigiteNumeroConta();
                numConta = this.teclado.nextInt();          
                validado = true;
            } catch(InputMismatchException e) {
                System.out.println("Numero de conta invalido");
                this.setTeclado();
            } catch(Exception e) {
                System.out.println(e.getMessage());
            }
        } while(!validado);
        return numConta;
    }

    public char lerComando() {
        char comando   = 'Q';
        boolean validado = false;

        do {
            try {
                this.imprimirSelecioneComando();
                comando = Character.toUpperCase(this.teclado.next().charAt(0));System.out.println(comando);
                validado = true;
            } catch(InputMismatchException e) {
                System.out.println("Comando invalido");
                this.setTeclado();
            } catch(Exception e) {
                System.out.println(e.getMessage());
            }
        } while(!validado);
        return comando;
    }

    public void imprimirListaDeProjetos(Vector<String> lista) {
    	if(lista.getSize() > 0) {
    		for(String itemLista : lista.asArray()) {
    			String[] registro = arquivo.explodirLinhaDoArquivo(itemLista);
    			printMsgln(registro[2]);
    		}
		}
    }
}