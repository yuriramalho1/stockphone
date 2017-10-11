package br.com.stockphone.util;


public class NavigationUtil {

	public static final String TO_HOME = "home";
	public static final String TO_PAGES_HOME = "pages/home";
	public static final String TO_LOGIN = "login";
	public static final String TO_PRIMEIRO_ACESSO = "primeiroAcesso";
	public static final String TO_ALTERAR_SENHA = "alterarSenha";
	public static final String TO_USUARIO_CADASTRO = "cadastroUsuarios";
	public static final String TO_CONSULTA_USUARIO = "consultaNovoUsuario";
	public static final String TO_USUARIO = "usuario";
	

	private NavigationUtil() { }

	public static void toHome() {
		FacesUtil.redirectTo(TO_HOME);
	}

	public static void toPagesHome() {
		FacesUtil.redirectTo(TO_PAGES_HOME);
	}

	public static void toLogin() {
		FacesUtil.obterFacesContext().getExternalContext().getSession(true);
		FacesUtil.redirectTo(FacesUtil.obterCaminhoContexto() + "/" + TO_LOGIN);
	}

	public static void toPrimeiroAcesso() {
		FacesUtil.redirectTo(TO_PRIMEIRO_ACESSO);
	}

	public static void toUsuarioCadastro() {
		FacesUtil.redirectTo(TO_USUARIO_CADASTRO);
	}
	
	public static void toConsultaUsuario() {
		FacesUtil.redirectTo(TO_CONSULTA_USUARIO);
	}

	public static void toAlterarSenha() {
		FacesUtil.redirectTo(TO_ALTERAR_SENHA);
	}

	public static void toUsuario() {
		FacesUtil.redirectTo(TO_USUARIO);
	}
	
	
}
