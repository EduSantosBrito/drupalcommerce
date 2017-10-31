package br.com.virtualshop.state;

import br.com.virtualshop.model.Pedido;

public interface PedidoEstado {
    
    public String estado();
    public String analise(Pedido pedido);
    public String atraso(Pedido pedido);
    public String separacao(Pedido pedido);
    public String cancelado(Pedido pedido);
    public String enviado(Pedido pedido);

    @Override
    public boolean equals(Object obj);
 
}