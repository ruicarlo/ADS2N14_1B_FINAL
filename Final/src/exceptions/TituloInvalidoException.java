package exceptions;

public class TituloInvalidoException extends Exception {
	private static final long serialVersionUID = 1L;

	public TituloInvalidoException() {
		super("Titulo inválido.");
	}
}