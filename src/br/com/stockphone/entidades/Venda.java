package br.com.stockphone.entidades;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Venda")
@SequenceGenerator(name = "seqVenda", sequenceName = "seq_Venda", allocationSize = 1)
public class Venda {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "seqVenda")
	private int id;
	
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name= "id_cliente", referencedColumnName = "id")
	private Cliente id_cliente;
	
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name= "id_produto", referencedColumnName = "id")
	private Produto id_produto;
	
	@Column(name="quantidade")
	private int quantidade;
	
	
	public Cliente getId_cliente() {
		return id_cliente;
	}
	public void setId_cliente(Cliente id_cliente) {
		this.id_cliente = id_cliente;
	}
	public Produto getId_produto() {
		return id_produto;
	}
	public void setId_produto(Produto id_produto) {
		this.id_produto = id_produto;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	
	
}
