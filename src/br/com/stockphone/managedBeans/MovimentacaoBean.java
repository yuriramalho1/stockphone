package br.com.stockphone.managedBeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;

import br.com.stockphone.bo.MovimentacaoBO;
import br.com.stockphone.entidades.Movimentacao;
import br.com.stockphone.entidades.Produto;


@Named
@ViewScoped
public class MovimentacaoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 767262927997544026L;
	
	private MovimentacaoBO movimentacaoBO;
	private Movimentacao movimentacao;
	private List<Movimentacao> listaMovimentacao;
	
	public MovimentacaoBean(){
		
		
	}
	
	@PostConstruct
	public void init() {
		if (movimentacao == null) {
			movimentacao = new Movimentacao();
		}
	}

	public void limpaBean() {
		movimentacao= new Movimentacao();
	}
	
	public void cadastroMovimentacao() {
		try {
			if (movimentacao.getId() == null) {
				movimentacao.setAtivo(true);
			}
			movimentacaoBO.salvar(movimentacao);
			this.limpaBean();
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							"Movimentacao salva com sucesso.",
							""));

			
		} catch (Exception e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e
							.getMessage(), null));
		}

	}
	

	public List<Movimentacao> getListaMovimentacao() {
		return listaMovimentacao;
	}

	public void setListaMovimentacao(List<Movimentacao> listaMovimentacao) {
		this.listaMovimentacao = listaMovimentacao;
	}
	

}
