package br.com.stockphone.bo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.TypedQuery;

import br.com.stockphone.business.FornecedorBusiness;
import br.com.stockphone.dao.GenericHibernateDAO;
import br.com.stockphone.entidades.Fornecedor;

public class FornecedorBO extends GenericHibernateDAO<Fornecedor> implements FornecedorBusiness,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1482262853120477742L;
	
	public FornecedorBO(){
		super(Fornecedor.class);
	}
	
	@Override
	public Fornecedor salvar(Fornecedor fornecedor) throws Exception{
		if(fornecedor.getId()== null){
			super.create(fornecedor);
		}else
			super.update(fornecedor);
			return fornecedor;
	}
	
	@Override
	public List<Fornecedor> getFornecedoresAtivos() throws Exception {
		return em.createQuery("SELECT u FROM Fornecedor u WHERE u.ativo =:ativo").setParameter("ativo", true).getResultList();
	}
	
	@Override
	public List<Fornecedor>getConsultaFornecedodorCNPJ(Fornecedor fornecedor) {
		Map<String, Object> parametros = new HashMap<String, Object>();
		StringBuilder query = new StringBuilder("SELECT f FROM Fornecedor f WHERE 1=1");
		
		if(fornecedor.getNome() != null && !fornecedor.getNome().isEmpty()){
			query.append(" AND LOWER(f.nome) LIKE LOWER(:nome)");
			parametros.put("nome", "%"+fornecedor.getNome()+"%");
		}
		
		if(fornecedor.getCnpj() != null && !fornecedor.getCnpj().isEmpty()){
			query.append(" AND f.cnpj =:cnpj");
			parametros.put("cnpj", fornecedor.getCnpj());
		}
		query.append(" AND f.ativo =:ativo");
		parametros.put("ativo", true);
		TypedQuery<Fornecedor> q = em.createQuery(query.toString(), Fornecedor.class);
		if(parametros != null && !parametros.isEmpty()){
			for(Entry<String, Object> entry : parametros.entrySet()){
				q.setParameter(entry.getKey(), entry.getValue());
			}
		}
		return q.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Fornecedor> selectAll() {
		return super.em.createQuery("SELECT f FROM Fornecedor f").getResultList();
	}
}
