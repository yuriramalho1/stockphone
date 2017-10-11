package br.com.stockphone.business;

import java.util.List;

import br.com.stockphone.dao.IGenericDAO;
import br.com.stockphone.entidades.Produto;

public interface ProdutoBusiness extends IGenericDAO<Produto> {
	public Produto salvar(Produto user) throws Exception;
	public List<Produto> getProdutosAtivos() throws Exception;
	public List<Produto> selectAll();
	public List<Produto>getConsultaProduto(Produto produto);
	
}
