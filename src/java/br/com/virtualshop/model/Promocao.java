/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.virtualshop.model;

/**
 *
 * @author macanha
 */
public abstract class Promocao {
    
    public abstract String getTitulo();
    public abstract Integer getDesconto();

    public String getDescricaoPromocao(){
        return "Promoção de " + getTitulo() + ", Desconto de " + getDesconto() + "%";
    }
    
    public Double getValorDescontado(Produto produto){
        return produto.getPreco() - (produto.getPreco() * (getDesconto() / 100));
    }
}
