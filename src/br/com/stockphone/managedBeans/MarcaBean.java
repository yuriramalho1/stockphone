package br.com.stockphone.managedBeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;

import br.com.stockphone.bo.MarcaBO;
import br.com.stockphone.entidades.Marca;

@Named
@ViewScoped
public class MarcaBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7585707951336048989L;
	
	@Inject
	private MarcaBO marcaBO;
	private Marca marca;
	private List<Marca> listaMarcas;
	
	public MarcaBean(){
		
	}
	
	@PostConstruct
	public void init() {
		if (marca == null) {
			marca = new Marca();
		}
	}

	public void limpaBean() {
		marca = new Marca();
	}

	public void cadastroProduto() {
		try {
			if (marca.getId() == null) {
				marca.setAtivo(true);
			}
			marcaBO.salvar(marca);
			this.limpaBean();
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							"Marca salva com sucesso.",
							"Marca Cadastrado !"));

			this.pesquisaMarca();
		} catch (Exception e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e
							.getMessage(), null));
		}

	}

	private void pesquisaMarca() {
		this.listaMarcas = marcaBO.getConsultaMarca(this.marca);
		if (listaMarcas == null || listaMarcas.isEmpty()) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Nenhuma marca foi encontrado.", ""));
		}
		
	}


	public void alterarProduto(Marca marca){
		this.marca = marca;
		
	}
	
	
	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public List<Marca> getListaMarcas() {
		return listaMarcas;
	}

	public void setListaProdutos(List<Marca> listaMarcas) {
		this.listaMarcas = listaMarcas;
	}

	public MarcaBO getMarcaBO() {
		return marcaBO;
	}

	public void setMarcaBO(MarcaBO marcaBO) {
		this.marcaBO = marcaBO;
	}
	
}
