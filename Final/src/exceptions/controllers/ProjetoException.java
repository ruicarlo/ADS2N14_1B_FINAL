package exceptions.controllers;

public class ProjetoException {
	public static class TituloInvalidoException extends Exception {
		private static final long serialVersionUID = 1L;

		public TituloInvalidoException() {
			super("Para cadastrar um projeto o titulo deve ser definido");
		}
	}
	
	public static class DescricaoInvalidaException extends Exception {
		private static final long serialVersionUID = 1L;

		public DescricaoInvalidaException() {
			super("Para cadastrar um projeto a descricao deve ser definida");
		}
	}
	
	public static class CriadorInvalidoException extends Exception {
		private static final long serialVersionUID = 1L;

		public CriadorInvalidoException() {
			super("Para cadastrar um projeto o usuario deve ser definido");
		}
	}
	public static class ProjetoNaoEcontrado extends Exception {
		private static final long serialVersionUID = 1L;
		
		public ProjetoNaoEcontrado() {
			super("Projeto nao encontrado"); 
		}
	}
}
