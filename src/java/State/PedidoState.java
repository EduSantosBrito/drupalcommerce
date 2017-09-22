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
