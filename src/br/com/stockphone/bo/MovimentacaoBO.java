package br.com.stockphone.bo;

import java.io.Serializable;

import br.com.stockphone.business.MovimentacaoBussines;
import br.com.stockphone.dao.GenericHibernateDAO;
import br.com.stockphone.entidades.Movimentacao;

public class MovimentacaoBO extends GenericHibernateDAO<Movimentacao> implements MovimentacaoBussines, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8976565855868196953L;

	public MovimentacaoBO(){
		super(Movimentacao.class);
	}
	
	@Override
	public Movimentacao salvar(Movimentacao movimentacao) throws Exception{
		if(movimentacao.getId()== null){
			super.create(movimentacao);
		}else
			super.update(movimentacao);
			return movimentacao;
	}
	
	
	
}
