package view;

import java.util.InputMismatchException;

import estruturas.Vector;

public class IssueView extends PadraoView {

   public char lerComando() {
        char comando   = 'Q';
        boolean validado = false;

        do {
            try {
                this.imprimirSelecioneComando();
                comando = Character.toUpperCase(this.teclado.next().charAt(0));
                validado = true;
            } catch(InputMismatchException e) {
            	printMsgln("Comando invalido");
                this.setTeclado();
            } catch(Exception e) {
            	printMsgln(e.getMessage());
            }
        } while(!validado);
        return comando;
    }

	public void imprimirSelecioneComando() {
		printMsg("Selecione um comando (L para Listar Issues, C para Cadastrar Nova Issue: ");
	}
	
	public void imprimirListaDeIssues(Vector<String> lista) {
    	printMsgln("Lista de Issues do projeto:");

    	if(lista.getSize() > 0) {
    		for(String itemLista : lista.asArray()) {
    			String[] registro = arquivo.explodirLinhaDoArquivo(itemLista);
    			printMsgln(String.format("%d - %s - %s - %s",
    					Integer.parseInt(registro[0]),registro[4],registro[6],registro[7])
    			);
    		}
		}
    }
}
