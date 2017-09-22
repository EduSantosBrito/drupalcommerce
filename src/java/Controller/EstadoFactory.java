/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import State.PedidoState;

/**
 *
 * @author Automateasy
 */
public class EstadoFactory {
    public static PedidoState create(String action) throws Exception{
        PedidoState actionObject = null;
        String nomeClasse = "State.PedidoEstado" + action;
        Class classe = null;
        Object object = null;
        try {
            classe = Class.forName(nomeClasse);
            object = classe.newInstance();
        }
        catch(Exception ex){
            throw ex;
        }
        if(!(object instanceof PedidoState)) return null;
        actionObject = (PedidoState) object;
        return actionObject;
    }
}
