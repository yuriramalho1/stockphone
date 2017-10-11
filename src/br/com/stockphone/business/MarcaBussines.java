package br.com.stockphone.business;

import java.util.List;

import br.com.stockphone.dao.IGenericDAO;
import br.com.stockphone.entidades.Marca;

public interface MarcaBussines extends IGenericDAO<Marca>{
	
	public Marca salvar(Marca marca) throws Exception;
	public List<Marca> getMarcasAtivos() throws Exception;
	public List<Marca> selectAll();
	public List<Marca>getConsultaMarca(Marca marca);
	
}
