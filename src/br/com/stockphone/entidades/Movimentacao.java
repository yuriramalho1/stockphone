package br.com.stockphone.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.engine.profile.Fetch;

import br.com.stockphone.enumeration.TipoMovimentacao;

@Entity
@SequenceGenerator(name = "seqMovimentacao", sequenceName = "seq_Movimentacao", allocationSize = 1)
public class Movimentacao implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = -6788520567555985810L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "seqMovimentacao")
	private Long id;
	
	@Column(name="TIPO_MOVIMENTACAO", nullable = false)
	@Enumerated(EnumType.STRING)
	private TipoMovimentacao tipoMovimentacao;

	
	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(obj instanceof Fornecedor)
			if(((Movimentacao)obj).getId().equals(this.id)) return true;
		
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

	public TipoMovimentacao getTipoMovimentacao() {
		return tipoMovimentacao;
	}

	public void setTipoMovimentacao(TipoMovimentacao tipoMovimentacao) {
		this.tipoMovimentacao = tipoMovimentacao;
	}
	
	
	
	
}
