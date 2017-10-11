package br.com.stockphone.entidades;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "seqVendaFornecedor", sequenceName = "seq_VendaFornecedor", allocationSize = 1)
public class VendaFornecedor implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2345407243846305721L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "seqVendaFornecedor")
	private int id;
	
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name= "id_fornecedor", referencedColumnName = "id")
	private Fornecedor fornecedor;
	
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name= "id_produto", referencedColumnName = "id")
	private Produto produto;
	
	public Fornecedor getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	
	
	
}
