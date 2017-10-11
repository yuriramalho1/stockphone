package br.com.stockphone.enumeration;


public enum PerfilAcesso {
	ADMINISTRADOR("Administrador"),
	GRAVACAO("Leitura e Gravação"),
	CONSULTA("Consulta");
	
	private String descricao;
	
	PerfilAcesso(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao(){
		return descricao;
	}
	
	@Override
	public String toString() {
		return descricao;
	}
}
