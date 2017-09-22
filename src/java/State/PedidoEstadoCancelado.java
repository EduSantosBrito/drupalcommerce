/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package State;

/**
 *
 * @author Automateasy
 */
public class PedidoEstadoCancelado implements PedidoState {

    @Override
    public String estado() {
        return "Cancelado";
    }

    @Override
    public String analise() {
        return "";
    }

    @Override
    public String atraso() {
        return "";
    }

    @Override
    public String separacao() {
        return "";
    }

    @Override
    public String cancelado() {
        return "";
    }

    @Override
    public String enviado() {
        return "";
    }
    
}
