package br.com.virtualshop.model;

import br.com.virtualshop.strategy.Pagamento;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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