/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.virtualshop.controller;

import br.com.virtualshop.state.PedidoEstado;

/**
 *
 * @author Automateasy
 */
public class EstadoFactory {
    public static PedidoEstado create(String action) throws Exception{
        PedidoEstado actionObject = null;
        String nomeClasse = "br.com.virtualshop.state.PedidoEstado" + action;
        Class classe = null;
        Object object = null;
        try {
            classe = Class.forName(nomeClasse);
            object = classe.newInstance();
        }
        catch(Exception ex){
            throw ex;
        }
        if(!(object instanceof PedidoEstado)) return null;
        actionObject = (PedidoEstado) object;
        return actionObject;
    }
}
