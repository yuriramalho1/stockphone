package br.com.stockphone.bo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.TypedQuery;

import br.com.stockphone.business.ProdutoBusiness;
import br.com.stockphone.dao.GenericHibernateDAO;
import br.com.stockphone.entidades.Produto;

public class ProdutoBO extends GenericHibernateDAO<Produto> implements Serializable, ProdutoBusiness  {

	
	private static final long serialVersionUID = 1567738457434515706L;
	
	public ProdutoBO() {
		super(Produto.class);
	}
	
	@Override
	public Produto salvar(Produto produto) throws Exception{
		if(produto.getId() == null){
			super.create(produto);
		}else
			super.update(produto);
			return produto;
	}


	
	@Override	
	public List<Produto> getProdutosAtivos() throws Exception {
		// TODO Auto-generated method stub
		return  em.createQuery("SELECT u FROM Produto u WHERE u.ativo =:ativo").setParameter("ativo", true).getResultList();
	}
	
	@Override
	public List<Produto>getConsultaProduto(Produto produto) {
		Map<String, Object> parametros = new HashMap<String, Object>();
		StringBuilder query = new StringBuilder("SELECT p FROM Produto p WHERE 1=1");
		
		if(produto.getNome() != null && !produto.getNome().equals("")){
			query.append(" AND p.nome =:nome");
			parametros.put("nome", produto.getNome());
		}
		
		if(produto.getQuantidade() != null){
			query.append(" AND p.quantidade =:quantidade");
			parametros.put("quantidade", produto.getQuantidade());
		}
		
		if(produto.getValor() != null){
			query.append(" AND p.valor =:valor");
			parametros.put("valor", produto.getQuantidade());
		}
		query.append(" AND p.ativo =:ativo");
		parametros.put("ativo", true);
		TypedQuery<Produto> q = em.createQuery(query.toString(), Produto.class);
		if(parametros != null && !parametros.isEmpty()){
			for(Entry<String, Object> entry : parametros.entrySet()){
				q.setParameter(entry.getKey(), entry.getValue());
			}
		}
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Produto> selectAll() {
		return super.em.createQuery("SELECT f FROM Produto f").getResultList();
	}



	
	

}
