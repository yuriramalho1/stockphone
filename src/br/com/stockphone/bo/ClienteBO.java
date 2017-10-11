package br.com.stockphone.bo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.TypedQuery;

import br.com.stockphone.business.ClienteBusiness;
import br.com.stockphone.dao.GenericHibernateDAO;
import br.com.stockphone.entidades.Cliente;
import br.com.stockphone.entidades.Produto;

public class ClienteBO extends GenericHibernateDAO<Cliente> implements Serializable, ClienteBusiness {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7615976347102613181L;

	public ClienteBO() {
		super(Cliente.class);
	}
	
	@Override
	public Cliente salvar(Cliente cliente) throws Exception{
		if(cliente.getId() == null){
			super.create(cliente);
		}else
			super.update(cliente);
			return cliente;
	}


	
	@Override	
	public List<Cliente> getClientesAtivos() throws Exception {
		// TODO Auto-generated method stub
		return  em.createQuery("SELECT u FROM Cliente u WHERE u.ativo =:ativo").setParameter("ativo", true).getResultList();
	}
	
	@Override
	public List<Cliente>getConsultaCliente(Cliente cliente) {
		Map<String, Object> parametros = new HashMap<String, Object>();
		StringBuilder query = new StringBuilder("SELECT p FROM Cliente p WHERE 1=1");
		
		if(cliente.getNome() != null && !cliente.getNome().equals(null)){
			query.append(" AND p.nome =:nome");
			parametros.put("nome", cliente.getNome());
		}
		
		if(cliente.getEmail() != null && !cliente.getEmail().equals(null)){
			query.append(" AND p.quantidade =: quantidade");
			parametros.put("email", cliente.getEmail());
		}
		
		if(cliente.getCpfCnpj() != null && !cliente.getCpfCnpj().equals(null)){
			query.append(" AND p.valor =: valor");
			parametros.put("Cpf/Cnpj", cliente.getCpfCnpj());
		}
		query.append(" AND p.ativo =:ativo");
		parametros.put("ativo", true);
		TypedQuery<Cliente> q = em.createQuery(query.toString(), Cliente.class);
		if(parametros != null && !parametros.isEmpty()){
			for(Entry<String, Object> entry : parametros.entrySet()){
				q.setParameter(entry.getKey(), entry.getValue());
			}
		}
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> selectAll() {
		return super.em.createQuery("SELECT f FROM Cliente f").getResultList();
	}



	
	

}
