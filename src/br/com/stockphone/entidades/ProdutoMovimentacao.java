package br.com.stockphone.entidades;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.engine.profile.Fetch;

import br.com.stockphone.enumeration.TipoMovimentacao;

@Entity
@SequenceGenerator(name = "seqProdutoMovimentacao", sequenceName = "seq_ProdutoMovimentacao", allocationSize = 1)
public class ProdutoMovimentacao implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3636645368509221853L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "seqProdutoMovimentacao")
	private Long id;
	
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name= "id_fornecedor", referencedColumnName = "id")
	private Produto produto;
	
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name= "id_movimentacao", referencedColumnName = "id")
	private Movimentacao movimentacao;
	

	
	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(obj instanceof Fornecedor)
			if(((ProdutoMovimentacao)obj).getId().equals(this.id)) return true;
		
		return false;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Movimentacao getMovimentacao() {
		return movimentacao;
	}

	public void setMovimentacao(Movimentacao movimentacao) {
		this.movimentacao = movimentacao;
	}

	
	
	
}
