package br.com.stockphone.business;

import java.util.List;

import br.com.stockphone.dao.IGenericDAO;
import br.com.stockphone.entidades.Cliente;

public interface ClienteBusiness extends IGenericDAO<Cliente> {
	
	public Cliente salvar(Cliente cliente) throws Exception;
	public List<Cliente>getConsultaCliente(Cliente cliente);
	List<Cliente> getClientesAtivos() throws Exception;
	
}
