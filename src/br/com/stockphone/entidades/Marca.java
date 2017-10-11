package br.com.stockphone.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "seqMarca", sequenceName = "seq_marca", allocationSize = 1)
public class Marca implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8011622423690606211L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqMarca")
	private Long id;

	@Column(name = "nome")
	private String nome;

	@Column
	private boolean ativo;

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(obj instanceof Fornecedor)
			if(((Marca)obj).getId().equals(this.id)) return true;
		
		return false;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
