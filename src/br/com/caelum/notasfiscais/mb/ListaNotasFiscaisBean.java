package br.com.caelum.notasfiscais.mb;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.LazyDataModel;

import br.com.caelum.notasfiscais.dao.DAO;
import br.com.caelum.notasfiscais.datamodel.DataModelNotasFiscais;
import br.com.caelum.notasfiscais.modelo.NotaFiscal;

@ManagedBean @ViewScoped
public class ListaNotasFiscaisBean implements Serializable{

	private LazyDataModel<NotaFiscal> dataModel;

	public ListaNotasFiscaisBean() {
		DAO<NotaFiscal> dao = new DAO<NotaFiscal>(NotaFiscal.class);
		
		this.dataModel = new DataModelNotasFiscais(dao.contaTodos());
		//this.dataModel.setPageSize(5);
	}

	public LazyDataModel<NotaFiscal> getDataModel() {
		return this.dataModel;
	}
}
