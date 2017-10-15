package br.com.stockphone.managedBeans;

import java.io.Serializable;
import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;

import br.com.stockphone.bo.ProdutoBO;
import br.com.stockphone.entidades.Produto;

@Named
@ViewScoped
public class ProdutoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2240035381163804128L;

	@Inject
	private ProdutoBO produtoBO;
	
	private Produto produto;

	private List<Produto> listaProdutos;
	private List<Produto> listaFiltroProduto;

	public ProdutoBean() {
		// TODO Auto-generated constructor stub
		// if(produto == null){
		// produto = new Produto();
		// }
		// if(listaProdutos == null){
		// listaProdutos = new ArrayList<Produto>();
		// }

	}

	@PostConstruct
	public void init() {
		if (produto == null) {
			produto = new Produto();
		}
	}
	
	
	// boolean filterByPrice(Object value, Object filter, Locale locale) {
	  //      String filterText = (filter == null) ? null : filter.toString().trim();
	    //    if(filterText == null||filterText.equals("")) {
	      //      return true;
	        //}
	         
	//        if(value == null) {
	  //          return false;
	    //    }
	         
	      //  return ((Comparable) value).compareTo(Integer.valueOf(filterText)) > 0;
	   // }

	public void limpaBean() {
		produto = new Produto();
	}

	public void cadastroProduto() {
		try {
			if (produto.getId() == null) {
				produto.setAtivo(true);
			}
			produtoBO.salvar(produto);
			this.limpaBean();
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							"Um novo produto foi salvo com sucesso.",
							"Produto Cadastrado !"));

			this.pesquisaProduto();
		} catch (Exception e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e
							.getMessage(), null));
		}

	}

	public void pesquisaProduto() {
		
		this.listaProdutos = produtoBO.getConsultaProduto(this.produto);
		if (listaProdutos == null || listaProdutos.isEmpty()) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Nenhum produto foi encontrado.", ""));
		}
			}

	public void alterarProduto(Produto produto){
		setProduto(produto);
	}
	
	public void removerProduto(Produto produto) throws Exception{
		this.produto = produto;
		produto.setAtivo(false);
		produtoBO.salvar(this.produto);
		
	}
	
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<Produto> getListaProdutos() {
		return listaProdutos;
	}

	public void setListaProdutos(List<Produto> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}

	public ProdutoBO getProdutoBO() {
		return produtoBO;
	}

	public void setProdutoBO(ProdutoBO produtoBO) {
		this.produtoBO = produtoBO;
	}

	public List<Produto> getListaFiltroProduto() {
		return listaFiltroProduto;
	}

	public void setListaFiltroProduto(List<Produto> listaFiltroProduto) {
		this.listaFiltroProduto = listaFiltroProduto;
	}

}
