package br.com.drupalcommerce.controller;

public class Factory {

	public static Object create(String nomeClasse) throws Exception {
	    Class classe = null;
	    Object object = null;
	    try {
	        classe = Class.forName(nomeClasse);
	        object = classe.newInstance();
	    }
	    catch(Exception ex){
	        throw ex;
	    }
	    return object;
	}

	public Factory() {
		super();
	}

}