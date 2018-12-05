/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.drupalcommerce.controller;

import br.com.drupalcommerce.strategy.Pagamento;

/**
 *
 * @author Eduardo
 */
public class PagamentoFactory extends Factory {
    public static Pagamento createAction(String action) throws Exception{
        String nomeClasse = "br.com.drupalcommerce.strategy.Pagamento" + action;
        Object object = create(nomeClasse);
        if(!(object instanceof Pagamento)) return null;
        return (Pagamento) object;
    }
}
