package interfaces;

import model.Usuario;
import exceptions.UsuarioInvalidoException;

public interface IUsuarioController {
	public Usuario autenticarUsuario(String username, String senha) throws UsuarioInvalidoException;
}
