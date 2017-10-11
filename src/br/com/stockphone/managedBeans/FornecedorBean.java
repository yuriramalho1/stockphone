package br.com.stockphone.managedBeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;

import br.com.stockphone.bo.FornecedorBO;
import br.com.stockphone.entidades.Fornecedor;

@Named
@ViewScoped
public class FornecedorBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1635112829067987590L;

	@Inject
	private FornecedorBO fornecedorBO;

	private Fornecedor fornecedor;

	private List<Fornecedor> listaFornecedor;

	public FornecedorBean() {
		// TODO Auto-generated constructor stub

		// if (fornecedor == null) {
		// fornecedor = new Fornecedor();
		// }
	}

	@PostConstruct
	public void init() {
		if (fornecedor == null) {
			fornecedor = new Fornecedor();
		}
	}

	public void limpaBean() {
		fornecedor = new Fornecedor();
	}

	public void cadastroFornecedor() {
		try {
			if (fornecedor.getId() == null) {
				fornecedor.setAtivo(true);
			}
			fornecedorBO.salvar(fornecedor);
			this.limpaBean();
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							"Um novo fornecedor foi salvo com sucesso.",
							"Fornecedor Cadastrado !"));

			this.pesquisaFornecedor();
		} catch (Exception e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e
							.getMessage(), null));
		}

	}

	public void pesquisaFornecedor() {
		this.listaFornecedor = fornecedorBO
				.getConsultaFornecedodorCNPJ(this.fornecedor);
		if (listaFornecedor == null || listaFornecedor.isEmpty()) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Nenhum fornecedor foi encontrado.", ""));
		}
	}
	
	public void alterarFornecedor(Fornecedor fornecedor){
		this.fornecedor = fornecedor;
	}
	
	public void removerFornecedor(Fornecedor fornecedor) throws Exception{
		this.fornecedor = fornecedor;
		fornecedor.setAtivo(false);
		fornecedorBO.salvar(fornecedor);
	}
	

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public FornecedorBO getFornecedorBO() {
		return fornecedorBO;
	}

	public void setFornecedorBO(FornecedorBO fornecedorBO) {
		this.fornecedorBO = fornecedorBO;
	}

	public List<Fornecedor> getListaFornecedor() {
		return listaFornecedor;
	}

	public void setListaFornecedor(List<Fornecedor> listaFornecedor) {
		this.listaFornecedor = listaFornecedor;
	}

}
