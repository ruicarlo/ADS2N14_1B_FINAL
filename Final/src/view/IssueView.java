package view;

import java.util.InputMismatchException;

import model.Issue;
import estruturas.Vector;

public class IssueView extends PadraoView {

	public String lerComando() {
        String comando   = "Q";
        boolean validado = false;

        do {
            try {
                this.imprimirSelecioneComando();
                comando = this.lerString().toUpperCase();
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
		printMsg("Digite C para Cadastrar Nova Issue, "
				+ "ID da Issue para ver os Detalhes "
				+ "ou V para voltar"
		);
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

	public void mostrarDadosIssue(Issue issue) {
		printMsgln(String.format("%d - %s", issue.getIdIssue(), issue.getTitulo()));
		printMsgln(issue.getDescricao());
		printMsgln(String.format("Criticidade: %s - Tipo: %s - Status: %s"
				, issue.getCriticidade(), issue.getTipo(), issue.getStatus())
		);
	}

	public void imprimirDigiteTitulo() {
		printMsgln("Digite o titulo da issue");
	}

	public void imprimirCriticidade() {
		printMsgln("Digite a criticidade da issue");
	}

	public void imprimirDigiteDescricao() {
		printMsgln("Digite a descricao da issue");
	}

	public void imprimirEstado() {
		printMsgln("Digite o estado da issue");
	}

	public void imprimirTipo() {
		printMsgln("Digite o tipo da issue");
		
	}
}

