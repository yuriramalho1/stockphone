package br.com.stockphone.managedBeans;

import java.io.Serializable;

import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;

@Named
@ViewScoped
public class VendaFornecedor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 668292554760535807L;

	private VendaFornecedor vendaFornecedor;

	public VendaFornecedor getVendaFornecedor() {
		return vendaFornecedor;
	}

	public void setVendaFornecedor(VendaFornecedor vendaFornecedor) {
		this.vendaFornecedor = vendaFornecedor;
	}

}
