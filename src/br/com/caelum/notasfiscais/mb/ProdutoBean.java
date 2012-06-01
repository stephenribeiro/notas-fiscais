package br.com.caelum.notasfiscais.mb;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.caelum.notasfiscais.dao.DAO;
import br.com.caelum.notasfiscais.modelo.Produto;

@ManagedBean @ViewScoped
public class ProdutoBean {

	private Produto produto = new Produto();
	private List<Produto> produtos;

	public void limpaFormulario(){
		this.produto = new Produto();
	}
	
	public void remove(Produto produto){
		DAO<Produto> dao = new DAO<Produto>(Produto.class);
		dao.remove(produto);
		this.produtos = dao.listaTodos();
	}
	
	public Double getSomatorio(){
		double soma = 0.0;
		if(this.produtos != null){
			for (Produto prod : this.produtos) {
				soma += prod.getPreco();
			}
		}
		return soma;
	}
	
	public List<Produto> getProdutos(){
		if(this.produtos == null){
			System.out.println("Carregando produtos...");
			this.produtos = new DAO<Produto>(Produto.class).listaTodos();
		}
		return this.produtos;
	}
	
	public void grava(){
		DAO<Produto> dao = new DAO<Produto>(Produto.class);
		
		if(this.produto.getId() == null){
			dao.adiciona(this.produto);	
		}else{
			dao.atualiza(this.produto);
		}
		
		this.produto = new Produto();
		this.produtos = dao.listaTodos();
	}
	
	public Produto getProduto() {
		return this.produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
}
