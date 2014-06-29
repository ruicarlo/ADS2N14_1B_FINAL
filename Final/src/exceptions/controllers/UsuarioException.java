package exceptions.controllers;

public class UsuarioException {
	public static class UsuarioInvalidoException extends Exception {
		private static final long serialVersionUID = 1L;

		public UsuarioInvalidoException() {
			super("Usuário invalida.");
		}
	}

	public static class FalhaDeAutenticacaoException extends Exception {
		private static final long serialVersionUID = 1L;

		public FalhaDeAutenticacaoException() {
			super("Usuário ou senha invalidos.");
		}
	}

	public static class UsuarioJaCadastradoException extends Exception {
		private static final long serialVersionUID = 1L;

		public UsuarioJaCadastradoException() {
			super("Este usuario ja esta cadastrado no sistema.");
		}
	}

	public static class NomeInvalidoException extends Exception {
		private static final long serialVersionUID = 1L;

		public NomeInvalidoException() {
			super("Para cadastrar um usuario o nome deve ser definido.");
		}
	}

	public static class UsernameInvalidoException extends Exception {
		private static final long serialVersionUID = 1L;

		public UsernameInvalidoException() {
			super("Para cadastrar um usuario o username deve ser definido.");
		}
	}

	public static class SenhaInvalidaException extends Exception {
		private static final long serialVersionUID = 1L;

		public SenhaInvalidaException() {
			super("Para cadastrar um usuario a senha deve ser definida.");
		}
	}
}