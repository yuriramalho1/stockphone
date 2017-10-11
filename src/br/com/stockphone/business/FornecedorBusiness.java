package br.com.stockphone.business;

import java.util.List;

import br.com.stockphone.dao.IGenericDAO;
import br.com.stockphone.entidades.Fornecedor;

public interface FornecedorBusiness extends IGenericDAO<Fornecedor>{
	public Fornecedor salvar(Fornecedor user) throws Exception;
	public List<Fornecedor> getFornecedoresAtivos() throws Exception;
	public List<Fornecedor>getConsultaFornecedodorCNPJ(Fornecedor fornecedor);
	public List<Fornecedor> selectAll();
}
