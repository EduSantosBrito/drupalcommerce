package br.com.virtualshop.model;

import br.com.virtualshop.state.PedidoEstado;
import java.util.Objects;

public class PedidoMemento {

    private PedidoEstado estado;

    public PedidoMemento(PedidoEstado estado){
        this.estado = estado;
    }
    
    public PedidoEstado getEstadoSalvo(){
        return estado;
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
