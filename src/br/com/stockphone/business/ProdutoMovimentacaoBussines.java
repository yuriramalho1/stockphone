package br.com.stockphone.business;

import br.com.stockphone.dao.IGenericDAO;
import br.com.stockphone.entidades.ProdutoMovimentacao;

public interface ProdutoMovimentacaoBussines extends IGenericDAO<ProdutoMovimentacao> {
	
	public ProdutoMovimentacao salvar(ProdutoMovimentacao produto) throws Exception;


}
