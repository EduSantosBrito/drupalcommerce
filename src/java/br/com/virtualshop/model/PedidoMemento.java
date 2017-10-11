package br.com.virtualshop.model;

import br.com.virtualshop.state.PedidoEstado;

public class PedidoMemento {
    
    private PedidoEstado estado;
    
    public PedidoMemento(PedidoEstado estado){
        this.estado = estado;
    }
    
    public PedidoEstado getEstadoSalvo(){
        return estado;
    }
}
