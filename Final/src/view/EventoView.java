package view;

import estruturas.Vector;

public class EventoView extends PadraoView {
	
	public int menuEvento() {
		printMsgln("	Menu de Eventos");
		printMsgln("Digite	'1' para Criar nova nssue ");
		printMsgln("Digite	'2' para Marcar a issue como valida ");
		printMsgln("Digite	'3' para Alterar a criticidade da issue ");
		printMsgln("Digite	'4' para Alterar o tipo ");
		printMsgln("Digite	'5' para Inserir comentario ");
		printMsgln("Digite	'6' para Atribuir a issue ");
		printMsgln("Digite	'7' para Iniciar o desenvolvimento ");
		printMsgln("Digite	'8' para Marcar como duplicado ");
		printMsgln("Digite	'9' para Fechar uma issue ");
		printMsgln("Digite	'10' para Marcar como 'Won`t Fix' ");
					
		String opcao = lerString(); 

		switch (opcao.toLowerCase()) {
			case "1":
				return 1;

			case "2":
				return 2;
				
			case "3":
				return 3;
				
			case "4":
				return 4;

			case "5":
				return 5;
				
			case "6":
				return 6;
				
			case "7":
				return 7;
				
			case "8":
				return 8;
				
			case "9":
				return 9;

			case "10":
				return 10;
	
			default:
				printMsgln("Opção inválida!");
				return menuEvento();
		}
	}
	
	public void msgIssueCriada(){
		printMsgln(getMsgIssueCriada());
	}
	public String getMsgIssueCriada(){
		return "Issue criada com sucesso.";
	}
	
	public void msgMarcouIssueValida(){
		printMsgln(getMsgMarcouIssueValida());
	}
	public String getMsgMarcouIssueValida(){
		return "Usuario " + "userX" + " marcou a issue como valida.";
	}
	
	public void msgCriticidadeAlterada(){
		printMsgln(getMsgCriticidadeAlterada());
	}
	public String getMsgCriticidadeAlterada(){
		return "Usuario " + "userX" + " alterou a criticidade para " + "criticidadeY";
	}
	
	public void msgTipoAlterado(){
		printMsgln(getMsgTipoAlterado());
	}
	public String getMsgTipoAlterado(){
		return "Usuario " + "userX" + " alterou o tipo para " + "tipoY";
	}

	public void msgComentarioInserido(){
		printMsgln(getMsgComentarioInserido());
	}
	public String getMsgComentarioInserido(){
		return "Comentario inserido.";
	}
	
	public void msgIssueAtribuida(){
		printMsgln(getMsgIssueAtribuida());
	}
	public String getMsgIssueAtribuida(){
		return "Issue atribuida para usuario " + "userX";
	}
	
	public void msgDesenvolvimentoIniciado(){
		printMsgln(getMsgDesenvolvimentoIniciado());
	}
	public String getMsgDesenvolvimentoIniciado(){
		return "Desenvolvimento iniciado.";
	}
	
	public void msgMarcarComoDuplicado(){
		printMsgln(getMsgMarcarComoDuplicado());
	}
	public String getMsgMarcarComoDuplicado(){
		return "lerCommentsToUserX " + " - "+ " Issue marcada como duplicado pelo usuario " + "userX";
	}
	
	public void msgIssueFechada(){
		printMsgln(getMsgIssueFechada());
	}
	public String getMsgIssueFechada(){
		return "Issue finalizada.";
	}
	
	public void msgMarcadaComoWontFix(){
		printMsgln(getMsgMarcadaComoWontFix());
	}
	public String getMsgMarcadaComoWontFix(){
		return "Issue marcada como Wont Fix";
	}

	public void imprimirListaDeEventos(Vector<String> lista) {
    	if(lista.getSize() > 0) {
    		for(String itemLista : lista.asArray()) {
    			String[] registro = arquivo.explodirLinhaDoArquivo(itemLista);
    			printMsgln(String.format("%d - %s %s"
    					, Integer.parseInt(registro[0]), registro[2], registro[4]));
    		}
		}
    }
	
}
