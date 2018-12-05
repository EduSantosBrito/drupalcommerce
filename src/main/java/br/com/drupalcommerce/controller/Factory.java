package br.com.drupalcommerce.controller;

import br.com.drupalcommerce.state.PedidoEstado;
import br.com.drupalcommerce.strategy.Pagamento;

public class Factory {

	public static Object create(String nomeClasse) throws Exception {
	    Action actionObject = null;
	    PedidoEstado pedidoObject = null;
	    Pagamento pagamentoObject = null;
	    Class classe = null;
	    Object object = null;
	    try {
	        classe = Class.forName(nomeClasse);
	        object = classe.newInstance();
	    }
	    catch(Exception ex){
	        throw ex;
	    }
	    if(!(object instanceof Action)) {
	    } else {
	    	actionObject = (Action) object;
	    	return actionObject;	    	
	    }
	    if(!(object instanceof PedidoEstado)) {
	    } else {
	    	pedidoObject = (PedidoEstado) object;
	    	return pedidoObject;
	    }
	    if(!(object instanceof Pagamento)) {
	    	return null;
	    } else {
	    	pagamentoObject = (Pagamento) object;
	        return actionObject;
	    }
	}

	public Factory() {
		super();
	}

}