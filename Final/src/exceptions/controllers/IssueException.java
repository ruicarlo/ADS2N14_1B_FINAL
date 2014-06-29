package exceptions.controllers;

public class IssueException {
	public static class TituloInvalidoException extends Exception {
		private static final long serialVersionUID = 1L;

		public TituloInvalidoException() {
			super("Para cadastrar um issue o titulo deve ser definido");
		}
	}

	public static class CriticidadeInvalidaException extends Exception {
		private static final long serialVersionUID = 1L;

		public CriticidadeInvalidaException() {
			super("Para cadastrar um issue a criticidade deve ser definida");
		}
	}
	
	public static class TipoInvalidoException extends Exception {
		private static final long serialVersionUID = 1L;

		public TipoInvalidoException() {
			super("Para cadastrar um issue o tipo deve ser definido");
		}
	}

	public static class StatusInvalidoException extends Exception {
		private static final long serialVersionUID = 1L;

		public StatusInvalidoException() {
			super("Para cadastrar um issue o status deve ser definido");
		}
	}
	
	public static class DescricaoInvalidaException extends Exception {
		private static final long serialVersionUID = 1L;

		public DescricaoInvalidaException() {
			super("Para cadastrar um issue a descricao deve ser definida");
		}
	}

	public static class ProjetoInvalidoException extends Exception {
		private static final long serialVersionUID = 1L;

		public ProjetoInvalidoException() {
			super("Para cadastrar um issue o projeto deve ser definido");
		}
	}
	
	public static class UsuarioInvalidoException extends Exception {
		private static final long serialVersionUID = 1L;

		public UsuarioInvalidoException() {
			super("Para cadastrar um issue o usuario deve ser definido");
		}
	}
}