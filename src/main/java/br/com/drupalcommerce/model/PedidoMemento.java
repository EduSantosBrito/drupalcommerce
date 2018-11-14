package br.com.drupalcommerce.model;

import br.com.drupalcommerce.state.PedidoEstado;
import java.util.Objects;

public class PedidoMemento {

    private PedidoEstado estado;

    public PedidoMemento(PedidoEstado estado){
        this.estado = estado;
    }
    
    public PedidoMemento(){}
    
    public PedidoEstado getEstadoSalvo(){
        return estado;
    }
    
    public PedidoMemento getEstadoAtualPedido(Pedido pedido) {
        return EstadosSalvosSingleton.getInstance().avancarEstado(pedido);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.estado);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PedidoMemento other = (PedidoMemento) obj;
        if (!Objects.equals(this.estado, other.estado)) {
            return false;
        }
        return true;
    }
    
    

}
