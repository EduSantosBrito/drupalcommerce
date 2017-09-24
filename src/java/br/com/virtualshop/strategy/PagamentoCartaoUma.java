/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.virtualshop.strategy;

/**
 *
 * @author Automateasy
 */
public class PagamentoCartaoUma implements Pagamento{
    
    @Override
    public int obterDesconto() {
        return 10;
    }

    @Override
    public String obterPromocao() {
        return "À vista - desconto de 10%";
    }
    
}
