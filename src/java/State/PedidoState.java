<<<<<<< HEAD
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package State;

/**
 *
 * @author Automateasy
 */
public interface PedidoState {
    
    public String estado();
    public String analise();
    public String atraso();
    public String separacao();
    public String cancelado();
    public String enviado();
    
}
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package State;

/**
 *
 * @author Automateasy
 */
public interface PedidoState {
    
    PedidoState analise();
    PedidoState atraso();
    PedidoState separacao();
    PedidoState cancelado();
    PedidoState enviado();
    
}
>>>>>>> c9c8b6bf5d3fb2e451aa96ef91c0a61196a02b4a
