package br.com.stockphone.enumeration;

public enum TipoMovimentacao {
	
	ENTRADA("Entrada"),
	SAIDA("Saída"),
	BAIXA("Baixa");
	
	private String descricao;
	
	private TipoMovimentacao(String descricao) {
		this.descricao = descricao;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
