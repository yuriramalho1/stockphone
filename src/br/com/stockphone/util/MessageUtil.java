package br.com.stockphone.util;

import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

public class MessageUtil {
	
	public static final ResourceBundle BUNDLE = ResourceBundle.getBundle("message", FacesContext.getCurrentInstance().getViewRoot().getLocale());

	public static void addMessage(String msg, Severity severity) {
		FacesMessage facesMessage = new FacesMessage(severity, msg, msg);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, facesMessage);
	}

	public static void addMessageError(String msg) {
		msg = BUNDLE.getString(msg);
		addMessage(msg, FacesMessage.SEVERITY_ERROR);
	}

	public static void addMessageSucesso(String msg) {
		msg = BUNDLE.getString(msg);
		addMessage(msg, FacesMessage.SEVERITY_INFO);
	}

	public static void addMessageInfo(String msg) {
		msg = BUNDLE.getString(msg);
		addMessage(msg, FacesMessage.SEVERITY_WARN);
	}

}
