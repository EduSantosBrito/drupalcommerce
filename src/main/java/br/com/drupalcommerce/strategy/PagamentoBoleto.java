/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.drupalcommerce.strategy;

/**
 *
 * @author Eduardo
 */
public class PagamentoBoleto implements Pagamento{

    @Override
    public int obterDesconto() {
        return 15;
    }

    @Override
    public String obterPromocao() {
        return "Boleto - desconto de 15%";
    }
    
}
