/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Strategy.Pagamento;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author sandr
 */
public class Carrinho {
    
    private final Usuario usuario;
    private List<Item> itens = new ArrayList<>();
    private Double total = 0.0;
    private Pagamento pagamento;

    public Carrinho(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }
    
    public void adiciona(Item item){
        this.itens.add(item);
        this.total += item.getProduto().getPreco() * item.getQuantidade();
    }
    
    public void remove(Produto produto){
        Iterator<Item> iter = itens.iterator();
        while(iter.hasNext()) {
            Item i = iter.next();
            if(produto.equals(i.getProduto())){
                iter.remove();
                total -= i.getProduto().getPreco() * i.getQuantidade();
            }
        }
    }
    
    public void finalizar(){
        this.itens.clear();
        this.total = 0d;
    }
    
    public Integer getQuantidadeItens(){
        return itens.size();
    }
}
