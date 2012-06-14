package br.com.caelum.notasfiscais.mb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.caelum.notasfiscais.dao.UsuarioDAO;
import br.com.caelum.notasfiscais.modelo.Usuario;

@ManagedBean @SessionScoped
public class LoginBean {

	private Usuario usuario = new Usuario();

	public String efetuaLogout(){
		this.usuario = new Usuario();
		return "login?faces-redirect=true";
	}
	
	//action com outcome
	public String efetuaLogin(){
		UsuarioDAO dao = new UsuarioDAO();
		boolean loginValido = dao.existe(this.usuario);
		if(loginValido){
			return "produto?faces-redirect=true";
		}else{
			this.usuario = new Usuario();
			return "login";
		}
	}
	
	public boolean isLogado(){
		return this.usuario.getLogin() != null;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

}
