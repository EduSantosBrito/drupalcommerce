package br.com.drupalcommerce.state;

import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class HelperLog {

	public static void logException(Exception e) {
		try {
		    throw e;
		} catch (Exception ex) {
		    Logger.getLogger(PedidoEstadoAnalise.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
}
