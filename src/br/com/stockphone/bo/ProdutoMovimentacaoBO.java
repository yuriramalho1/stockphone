package br.com.stockphone.bo;

import java.io.Serializable;

import br.com.stockphone.business.ProdutoMovimentacaoBussines;
import br.com.stockphone.dao.GenericHibernateDAO;
import br.com.stockphone.entidades.ProdutoMovimentacao;

public class ProdutoMovimentacaoBO extends GenericHibernateDAO<ProdutoMovimentacao> implements ProdutoMovimentacaoBussines, Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1170607704433363311L;

	public ProdutoMovimentacaoBO(){
		super(ProdutoMovimentacao.class);
	}
	
	@Override
	public ProdutoMovimentacao salvar(ProdutoMovimentacao produtoMovimentacao) throws Exception{
		if(produtoMovimentacao.getId()== null){
			super.create(produtoMovimentacao);
		}else
			super.update(produtoMovimentacao);
			return produtoMovimentacao;
	}
	
}
