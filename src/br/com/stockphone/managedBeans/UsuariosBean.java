package br.com.stockphone.managedBeans;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.omnifaces.cdi.ViewScoped;

import br.com.stockphone.bo.UsuarioBO;
import br.com.stockphone.entidades.Usuario;

@Named
@ViewScoped
public class UsuariosBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4414740154534120122L;
	
	@Inject
	private UsuarioBO usuarioBO;

	private Usuario usuario;

	private List<Usuario> listaUsuarios;

	public UsuariosBean() {

	}

	@PostConstruct
	public void init() {
		if (usuario == null) {
			usuario = new Usuario();
		}
	}

	public void limpaBean() {
		usuario = new Usuario();
	}

	public void cadastrarUsuario() {
		try {
			if (usuario.getId() == null) {
				usuario.setAtivo(true);
			}
			usuarioBO.salvar(usuario);
			this.limpaBean();
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							"Usuario cadastrado com sucesso!","Usuário Cadastrados"));

			this.pesquisaUsuario();
		} catch (Exception e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e
							.getMessage(), null));
		}

	}

	private void pesquisaUsuario() {
		this.listaUsuarios = usuarioBO.getConsultaUsuario(this.usuario);
		if (listaUsuarios == null || listaUsuarios.isEmpty()) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Usuário não foi encontrado.", ""));
		}	
	}

	
	@SuppressWarnings("unused")
	private void verificaLogin(Usuario usuario, ServletResponse response) throws IOException {
		this.listaUsuarios = usuarioBO.getConsultaUsuario(this.usuario);
		HttpServletResponse res = (HttpServletResponse) response;
		if (usuario.getLogin().equals("Seu login") || usuario.getSenha().equals("Sua senha")) {
			
			res.sendRedirect("pages/produto.jsf");;
			
		}
	}
	

	
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
