package view;

import java.util.InputMismatchException;

import model.Criticidade;
import model.Estado;
import model.Issue;
import model.Tipo;
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

        this.setTeclado();
        return comando;
    }

	public void imprimirSelecioneComando() {
		printMsg("Digite C para Cadastrar Nova Issue, "
				+ "ID da Issue para ver os Detalhes "
				+ "ou V para voltar: "
		);
	}
	
	public void imprimirListaDeIssues(Vector<String> lista) {
    	printMsgln("Lista de Issues do projeto:");

    	if(lista.getSize() > 0) {
    		int[] posicoes = {0,4,6,7};
    		Tabela tab = new Tabela(this.verificarMaiorTexto(lista,posicoes));
    		tab.printLinha(4);
    		for(String itemLista : lista.asArray()) {
    			String[] registro = arquivo.explodirLinhaDoArquivo(itemLista);
    			tab.printCelula(registro[0], true ,false);
    			tab.printCelula(registro[4], false ,false);
    			tab.printCelula(registro[6], false ,false);
    			tab.printCelula(registro[7], false ,true);
    			tab.printLinha(4);
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
		printMsg("Digite o titulo da issue: ");
	}

	public void imprimirCriticidade() {
		for(Criticidade crit: Criticidade.values()) {
			printMsg(String.format("%s - %d; ", crit.getDescricao(), crit.getOrdem()));
		}
		printMsgln(" ");
		printMsg("Digite a criticidade da issue: ");
	}

	public void imprimirDigiteDescricao() {
		printMsg("Digite a descricao da issue: ");
	}

	public void imprimirEstado() {
		for(Estado est: Estado.values()) {
			printMsg(String.format("%s - %d; ", est.getDescricao(), est.getOrdem()));
		}
		printMsgln(" ");
		printMsgln("Digite o estado da issue: ");
	}

	public void imprimirTipo() {
		for(Tipo tipo: Tipo.values()) {
			printMsg(String.format("%s - %d; ", tipo.getDescricao(), tipo.getOrdem()));
		}
		printMsgln(" ");
		printMsg("Digite o tipo da issue: ");
		
	}
}

