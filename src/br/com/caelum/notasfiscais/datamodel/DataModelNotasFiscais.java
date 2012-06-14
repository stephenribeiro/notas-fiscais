package br.com.caelum.notasfiscais.datamodel;

import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;

import br.com.caelum.notasfiscais.dao.DAO;
import br.com.caelum.notasfiscais.modelo.NotaFiscal;

public class DataModelNotasFiscais extends LazyDataModel<NotaFiscal>{

	public DataModelNotasFiscais(int total) {
		this.setRowCount(total);
	}
	
	@Override
	public List<NotaFiscal> load(int inicio, int quantidade, String campoOrdenacao, boolean sentidoOrdenacao,
			Map<String, String> filtros) {
		
		DAO<NotaFiscal> dao = new DAO<NotaFiscal>(NotaFiscal.class);
		return dao.listaTodosPaginada(inicio, quantidade);
	}

}
