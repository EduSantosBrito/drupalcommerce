/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.drupalcommerce.controller;

import br.com.drupalcommerce.state.PedidoEstado;

/**
 *
 * @author Eduardo
 */
public class EstadoFactory extends Factory{
    public static PedidoEstado createAction(String action) throws Exception{
        String nomeClasse = "br.com.drupalcommerce.state.PedidoEstado" + action;
        Object object = create(nomeClasse);
        if(!(object instanceof PedidoEstado)) return null;
        return (PedidoEstado) object;
    }
}
