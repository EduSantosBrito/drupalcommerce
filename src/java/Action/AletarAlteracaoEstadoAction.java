/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Action;

import Model.Pedido;
import Model.Usuario;
import java.util.List;

/**
 *
 * @author Automateasy
 */
public class AletarAlteracaoEstadoAction {
    private static AletarAlteracaoEstadoAction instance = new AletarAlteracaoEstadoAction();
    
    private AletarAlteracaoEstadoAction(){}
    
    public static AletarAlteracaoEstadoAction getInstance(){
        return instance;
    }
    
    public List<Usuario> alertarClientes(Pedido pedido){
        
        
        return null;
    }
}
