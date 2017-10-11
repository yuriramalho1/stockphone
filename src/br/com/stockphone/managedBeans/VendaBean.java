package br.com.stockphone.managedBeans;

import java.io.Serializable;

import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;

import br.com.stockphone.entidades.Venda;

@Named
@ViewScoped
public class VendaBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6464506151179900423L;

	private Venda venda;

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

}
