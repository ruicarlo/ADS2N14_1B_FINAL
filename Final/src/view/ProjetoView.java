package view;

import java.util.InputMismatchException;

import estruturas.Vector;

public class ProjetoView extends PadraoView {
	String[] dadosProjeto = new String[2];	

	public void imprimirProjetoCadastradoComSucesso() {
    	printMsgln("Projeto cadastrado com sucesso");
    }

	public void imprimirUsuarioSemProjeto() {
    	printMsgln("Este usuario nao possui projetos.");
    }

	public void imprimirSelecioneComando() {
    	printMsg("Selecione um comando (L para Listar Projetos, C para Cadastrar Novo Projeto ou ID do Projeto para gerenciar Issues: ");
    }

    public void imprimirDigiteTitulo() {
    	printMsg("Digite o titulo do projeto: ");
    }

    public void imprimirDigiteDescricao() {
    	printMsg("Digite a descricao do projeto: ");
    }

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

    public void imprimirListaDeProjetos(Vector<String> lista) {
    	if(lista.getSize() > 0) {
    		for(String itemLista : lista.asArray()) {
    			String[] registro = arquivo.explodirLinhaDoArquivo(itemLista);
    			printMsgln(String.format("%d - %s",Integer.parseInt(registro[0]),registro[2]));
    		}
		}
    }
}