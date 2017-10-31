/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.virtualshop.state;

import br.com.virtualshop.model.Pedido;

/**
 *
 * @author Automateasy
 */
public class PedidoEstadoCancelado implements PedidoEstado {

    @Override
    public String estado() {
        return "Cancelado";
    }

    @Override
    public String analise(Pedido pedido) {
        return "O estado do pedido não pode ser alterado para análise";
    }

    @Override
    public String atraso(Pedido pedido) {
        return "O estado do pedido não pode ser alterado para atraso";
    }

    @Override
    public String separacao(Pedido pedido) {
        return "O estado do pedido não pode ser alterado para separação";
    }

    @Override
    public String cancelado(Pedido pedido) {
        return "O pedido já foi cancelado";
    }

    @Override
    public String enviado(Pedido pedido) {
        return "O estado do pedido não pode ser alterado para enviado";
    }
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
    }
    
}
