/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.drupalcommerce.model;
public abstract class Promocao {
    
    public abstract String getTitulo();
    public abstract Integer getDesconto();

    public String getDescricaoPromocao(){
        return "Promoção de " + getTitulo() + ", Desconto de " + getDesconto() + "%";
    }
    
}
