package br.com.stockphone.business;

import java.util.List;

import br.com.stockphone.dao.IGenericDAO;
import br.com.stockphone.entidades.Produto;
import br.com.stockphone.entidades.Usuario;

public interface UsuarioBussiness extends IGenericDAO<Usuario> {
	public Usuario salvar(Usuario usuario) throws Exception;
	public List<Usuario> getUsuarioAtivos() throws Exception;
	public List<Usuario> getConsultaUsuario(Usuario usuario);
	
}
