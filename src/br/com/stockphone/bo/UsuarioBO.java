package br.com.stockphone.bo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.stockphone.business.UsuarioBussiness;
import br.com.stockphone.dao.GenericHibernateDAO;
import br.com.stockphone.entidades.Produto;
import br.com.stockphone.entidades.Usuario;

public class UsuarioBO extends GenericHibernateDAO<Usuario> implements Serializable, UsuarioBussiness {

	
	private static final long serialVersionUID = -993922103518301094L;

	/**
	 * 
	 */
	
	public UsuarioBO(){
		super(Usuario.class);
	}
	
	@Override
	public Usuario salvar(Usuario usuario) throws Exception{
		if(usuario.getId() == null){
			super.create(usuario);
		}else
			super.update(usuario);
			return usuario;
	} 
	
	@Override
	public List<Usuario> getUsuarioAtivos() throws Exception {
		// TODO Auto-generated method stub
		return  em.createQuery("SELECT u FROM Usuario u WHERE u.ativo =:ativo").setParameter("ativo", true).getResultList();
	}
	
	@Override
	public List<Usuario>getConsultaUsuario(Usuario usuario) {
		Map<String, Object> parametros = new HashMap<String, Object>();
		StringBuilder query = new StringBuilder("SELECT f FROM Usuario f WHERE 1=1");
		
		if(usuario.getLogin() != null && !usuario.getLogin().isEmpty()){
			query.append(" AND LOWER(u.login) LIKE LOWER(:login)");
			parametros.put("login", "%"+usuario.getLogin()+"%");
		}
		
		if(usuario.getSenha() != null && ! usuario.getSenha().equals(null)){
			query.append(" AND u.senha =: senha");
			parametros.put("senha",usuario.getSenha());
		}
		
		query.append(" AND u.ativo =:ativo");
		parametros.put("ativo", true);
		TypedQuery<Usuario> q = em.createQuery(query.toString(), Usuario.class);
		if(parametros != null && !parametros.isEmpty()){
			for(Entry<String, Object> entry : parametros.entrySet()){
				q.setParameter(entry.getKey(), entry.getValue());
			}
		}
		return q.getResultList();
	}
	
	
	public Usuario verificaLogin(String login, String senha) {
		try {
			TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE u.login =:login AND u.senha =:senha", Usuario.class);
			query.setParameter("login", login);
			query.setParameter("senha", senha);
			return query.getResultList().iterator().next();

		} catch(NoResultException e) {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> selectAll() {
		return super.em.createQuery("SELECT u FROM Usuario u").getResultList();
	}

	
	
}
