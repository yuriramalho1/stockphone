package br.com.stockphone.managedBeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.stockphone.bo.ClienteBO;
import br.com.stockphone.entidades.Cliente;

@Named
@org.omnifaces.cdi.ViewScoped
public class ClienteBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -613976440567641129L;

	
	@Inject
	private ClienteBO clienteBO;
	
	private Cliente cliente;

	private List<Cliente> listaClientes;
	private List<Cliente> listaFiltroCliente;

	public ClienteBean() {
		// TODO Auto-generated constructor stub
		// if(Cliente == null){
		// Cliente = new Cliente();
		// }
		// if(listaClientes == null){
		// listaClientes = new ArrayList<Cliente>();
		// }

	}

	@PostConstruct
	public void init() {
		if (cliente == null) {
			cliente = new Cliente();
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
		cliente = new Cliente();
	}

	public void cadastroCliente() {
		try {
			if (cliente.getId() == null) {
				cliente.setAtivo(true);
			}
			clienteBO.salvar(cliente);
			this.limpaBean();
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							"Um novo cliente foi salvo com sucesso.",
							"Cliente Cadastrado !"));

			this.pesquisaCliente();
		} catch (Exception e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e
							.getMessage(), null));
		}

	}

	public void pesquisaCliente() {
		this.listaClientes = clienteBO.getConsultaCliente(this.cliente);
		if (listaClientes == null || listaClientes.isEmpty()) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Nenhum Cliente foi encontrado.", ""));
		}
			}

	public void alterarCliente(Cliente Cliente){
		this.cliente = Cliente;
		
	}
	
	public void removerCliente(Cliente Cliente) throws Exception{
		this.cliente = Cliente;
		cliente.setAtivo(false);
		clienteBO.salvar(Cliente);
		
	}
	
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public ClienteBO getClienteBO() {
		return clienteBO;
	}

	public void setClienteBO(ClienteBO clienteBO) {
		this.clienteBO = clienteBO;
	}

	public List<Cliente> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

	public List<Cliente> getListaFiltroCliente() {
		return listaFiltroCliente;
	}

	public void setListaFiltroCliente(List<Cliente> listaFiltroCliente) {
		this.listaFiltroCliente = listaFiltroCliente;
	}

}
