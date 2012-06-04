package br.com.caelum.notasfiscais.mb;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.caelum.notasfiscais.dao.DAO;
import br.com.caelum.notasfiscais.modelo.Usuario;

@ManagedBean @ViewScoped
public class UsuarioBean implements Serializable{

	private Usuario usuario = new Usuario();
	private List<Usuario> usuarios;
	
	public UsuarioBean() {
		System.out.println("Instanciou UsuarioBean!");
	}
	
	public void grava(){
		DAO<Usuario> dao = new DAO<Usuario>(Usuario.class);
		
		if(this.usuario.getId() == null){
			dao.adiciona(this.usuario);
		}else{
			dao.atualiza(this.usuario);
		}
		this.usuario = new Usuario();
		this.usuarios = dao.listaTodos();
	}
	
	public void limpaFormulario(){
		this.usuario = new Usuario();
	}

	public List<Usuario> getUsuarios(){
		if(this.usuarios == null){
			System.out.println("Carregando usuarios...");
			this.usuarios = new DAO<Usuario>(Usuario.class).listaTodos();
		}
		return this.usuarios;
	}
	
	public void remove(Usuario usuario){
		DAO<Usuario> dao = new DAO<Usuario>(Usuario.class);
		dao.remove(usuario);
		this.usuarios = dao.listaTodos();
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
