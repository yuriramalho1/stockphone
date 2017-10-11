package br.com.stockphone.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="cliente")
@SequenceGenerator(name = "seqCliente", sequenceName = "seq_cliente", allocationSize = 1)
public class Cliente implements Serializable {
	
	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "seqCliente")
	private Long id;
	
	private static final long serialVersionUID = 2600348106297697618L;
	

	@Column(name="email")
	private String email;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="cpfCnpj")
	private String cpfCnpj;
	
	@Column(name="telefone")
	private String telefone;
	
	@Column
	private boolean ativo;
	
	public String getCpfCnpj() {
		return cpfCnpj;
	}
	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}
	private VendaFornecedor fornecedorCliente;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public VendaFornecedor getFornecedorCliente() {
		return fornecedorCliente;
	}
	public void setFornecedorCliente(VendaFornecedor fornecedorCliente) {
		this.fornecedorCliente = fornecedorCliente;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	 
	public Long getId() {
		return id;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
		
	}
}
