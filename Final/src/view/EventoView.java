package view;

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
	
	public void msgEventoCadastrado() {
		printMsgln("Evento" + "X" + "cadastrado com sucesso.");
	}

}
