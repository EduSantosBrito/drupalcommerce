/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.virtualshop.action;

import br.com.virtualshop.dao.PedidoDAO;
import br.com.virtualshop.model.Pedido;
import br.com.virtualshop.model.Usuario;
import java.sql.SQLException;

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
    
    public void alertarClientes(Pedido pedido) throws SQLException, ClassNotFoundException{
        Usuario usuario = PedidoDAO.getInstance().getAllEstadoAlterado(pedido);
        usuario.alertaEstadoPedido(pedido);
    }
}
