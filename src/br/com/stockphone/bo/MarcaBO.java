package br.com.stockphone.bo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.TypedQuery;

import br.com.stockphone.business.MarcaBussines;
import br.com.stockphone.dao.GenericHibernateDAO;
import br.com.stockphone.entidades.Marca;
import br.com.stockphone.entidades.Produto;

public class MarcaBO extends GenericHibernateDAO<Marca> implements Serializable, MarcaBussines {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6964442363602658822L;

	public MarcaBO() {
		super(Marca.class);
	}
	
	@Override
	public Marca salvar(Marca marca) throws Exception{
		if(marca.getId() == null){
			super.create(marca);
		}else
			super.update(marca);
			return marca;
	}

	@Override
	public List<Marca> getMarcasAtivos() throws Exception {
		// TODO Auto-generated method stub
		return  em.createQuery("SELECT u FROM Marca u WHERE u.ativo =:ativo").setParameter("ativo", true).getResultList();
	}
	
	@Override
	public List<Marca>getConsultaMarca(Marca marca) {
		Map<String, Object> parametros = new HashMap<String, Object>();
		StringBuilder query = new StringBuilder("SELECT p FROM Produto p WHERE 1=1");
		
		if(marca.getNome() != null && ! marca.getNome().isEmpty()){
			query.append(" AND LOWER(p.nome) LIKE LOWER(:nome)");
			parametros.put("nome", "%"+marca.getNome()+"%");
		}
	
		query.append(" AND p.ativo =:ativo");
		parametros.put("ativo", true);
		TypedQuery<Marca> q = em.createQuery(query.toString(), Marca.class);
		if(parametros != null && !parametros.isEmpty()){
			for(Entry<String, Object> entry : parametros.entrySet()){
				q.setParameter(entry.getKey(), entry.getValue());
			}
		}
		return q.getResultList();
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Marca> selectAll() {
		return super.em.createQuery("SELECT f FROM Marca f").getResultList();
	}

	

}
