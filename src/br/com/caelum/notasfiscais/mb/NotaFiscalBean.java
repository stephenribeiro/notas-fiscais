package br.com.caelum.notasfiscais.mb;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.caelum.notasfiscais.dao.DAO;
import br.com.caelum.notasfiscais.modelo.Item;
import br.com.caelum.notasfiscais.modelo.NotaFiscal;
import br.com.caelum.notasfiscais.modelo.Produto;

@ManagedBean @ViewScoped
public class NotaFiscalBean implements Serializable{

	private NotaFiscal notaFiscal = new NotaFiscal();
	private Item item = new Item();
	private Long idProduto;
	
	public void guardaItem(){
		DAO<Produto> dao = new DAO<Produto>(Produto.class);
		
		Produto produto = dao.buscaPorId(this.idProduto);
		this.item.setProduto(produto);
		this.item.setValorUnitario(produto.getPreco());
		this.item.setNotaFiscal(this.notaFiscal);
		
		this.notaFiscal.getItens().add(this.item);
		
		this.item = new Item();
	}
	
	public void gravar(){
		DAO<NotaFiscal> dao = new DAO<NotaFiscal>(NotaFiscal.class);
		dao.adiciona(this.notaFiscal);
		
		this.notaFiscal = new NotaFiscal();
		this.item = new Item();
	}

	public NotaFiscal getNotaFiscal() {
		return notaFiscal;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}
	
}
