package br.com.stockphone.business;

import br.com.stockphone.dao.IGenericDAO;
import br.com.stockphone.entidades.Movimentacao;

public interface MovimentacaoBussines extends IGenericDAO<Movimentacao> {
	
	public Movimentacao salvar(Movimentacao movimentacao) throws Exception;


}