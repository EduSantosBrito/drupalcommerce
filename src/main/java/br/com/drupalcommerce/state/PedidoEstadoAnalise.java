/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.drupalcommerce.state;

import br.com.drupalcommerce.model.Pedido;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Eduardo
 */
public class PedidoEstadoAnalise implements PedidoEstado {

    @Override
    public String estado() {
        return "Analise";
    }

    @Override
    public String analise(Pedido pedido) {
        return "O Pedido já está em análise";
    }

    @Override
    public String atraso(Pedido pedido) {
        try {
            pedido.setEstadoUpdate(new PedidoEstadoAtraso());
        } catch (Exception e) {
            logException(e);
        }
        return "O estado do pedido foi alterado para atraso";
    }

	private void logException(Exception e) {
		try {
		    throw e;
		} catch (Exception ex) {
		    Logger.getLogger(PedidoEstadoAnalise.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

    @Override
    public String separacao(Pedido pedido) {
        try {
            pedido.setEstadoUpdate(new PedidoEstadoSeparacao());
        } catch (Exception e) {
            logException(e);
        }
        return "O estado do pedido foi alterado para separação";
    }

    @Override
    public String cancelado(Pedido pedido) {
        try {
            pedido.setEstadoUpdate(new PedidoEstadoCancelado());
        } catch (Exception e) {
            logException(e);
        }
        return "O estado do pedido foi alterado para cancelado";
    }

    @Override
    public String enviado(Pedido pedido) {
        try {
            pedido.setEstadoUpdate(new PedidoEstadoEnviado());
        } catch (Exception e) {
            logException(e);
        }
        return "O estado do pedido foi alterado para enviado";
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
    }
    
}
