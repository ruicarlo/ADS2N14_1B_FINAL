package exceptions;

public class UsuarioInvalidoException extends Exception {
	private static final long serialVersionUID = 1L;

	public UsuarioInvalidoException() {
		super("Usuário ou senha inválido.");
	}
}