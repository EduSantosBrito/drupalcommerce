/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.virtualshop.state;

import br.com.virtualshop.model.Pedido;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Automateasy
 */
public class PedidoEstadoAtraso implements PedidoEstado {

    @Override
    public String estado() {
        return "Atraso";
    }

    @Override
    public String analise(Pedido pedido) {
        return "O estado do pedido não pode ser alterado para análise";
    }

    @Override
    public String atraso(Pedido pedido) {
        return "O pedido já esta em atraso";
    }

    @Override
    public String separacao(Pedido pedido) {
        try {
            pedido.setEstadoUpdate(new PedidoEstadoSeparacao());
        } catch (Exception e) {
            try {
                throw e;
            } catch (Exception ex) {
                Logger.getLogger(PedidoEstadoAnalise.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return "O estado do pedido foi alterado para separação";
    }

    @Override
    public String cancelado(Pedido pedido) {
        try {
            pedido.setEstadoUpdate(new PedidoEstadoCancelado());
        } catch (Exception e) {
            try {
                throw e;
            } catch (Exception ex) {
                Logger.getLogger(PedidoEstadoAnalise.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return "O estado do pedido foi alterado para cancelado";
    }

    @Override
    public String enviado(Pedido pedido) {
        try {
            pedido.setEstadoUpdate(new PedidoEstadoEnviado());
        } catch (Exception e) {
            try {
                throw e;
            } catch (Exception ex) {
                Logger.getLogger(PedidoEstadoAnalise.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return "O estado do pedido foi alterado para enviado";
    }
    
}
