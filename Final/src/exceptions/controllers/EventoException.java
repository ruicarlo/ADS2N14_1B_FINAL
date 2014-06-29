package exceptions.controllers;

public class EventoException {
	public static class DataInvalidaException extends Exception {
		private static final long serialVersionUID = 1L;

		public DataInvalidaException() {
			super("Para cadastrar um evento a data deve ser definida");
		}
	}

	public static class ComentarioInvalidoException extends Exception {
		private static final long serialVersionUID = 1L;

		public ComentarioInvalidoException() {
			super("Para cadastrar um evento o comentario deve ser definido");
		}
	}

	public static class IssueInvalidoException extends Exception {
		private static final long serialVersionUID = 1L;

		public IssueInvalidoException() {
			super("Para cadastrar um evento o issue deve ser definido");
		}
	}
	
	public static class UsuarioInvalidoException extends Exception {
		private static final long serialVersionUID = 1L;

		public UsuarioInvalidoException() {
			super("Para cadastrar um evento o usuario deve ser definido");
		}
	}
}
