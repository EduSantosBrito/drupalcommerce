/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.drupalcommerce.model;

/**
 *
 * @author sandr
 */
public class Item {
    
    private Produto produto;
    private Integer quantidade;

    public Item(Produto produto, Integer quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }
    
    public Produto getProduto() {
        return produto;
    }

    public Item setProduto(Produto produto) {
        this.produto = produto;
        return this;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public Item setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
        return this;
    }
    
    public void comprarProduto(Produto produto, Usuario usuario){
        usuario.getCarrinho().adiciona(this);
    }
    
}
