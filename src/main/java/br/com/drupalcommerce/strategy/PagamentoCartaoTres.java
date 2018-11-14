/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.drupalcommerce.strategy;

/**
 *
 * @author Automateasy
 */
public class PagamentoCartaoTres implements Pagamento{
    
    @Override
    public int obterDesconto() {
        return 5;
    }

    @Override
    public String obterPromocao() {
        return "Três vezes - desconto de 5%";
    }
    
}
