/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.virtualshop.action;

import br.com.virtualshop.controller.Action;
import br.com.virtualshop.dao.PedidoDAO;
import br.com.virtualshop.model.EstadosSalvosSingleton;
import br.com.virtualshop.model.Pedido;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author macanha
 */
public class AvancarEstadoPedidoAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String codigoPedido = request.getParameter("pedido-codigo");
        
        try{
            Pedido pedido = PedidoDAO.getInstance().getPedidoByID(Integer.parseInt(codigoPedido));
            pedido.restoreFromMemento(EstadosSalvosSingleton.getInstance().avancarEstado(pedido));
            PedidoDAO.getInstance().updatePedido(pedido);

            request.setAttribute("alteracaoEstado", "Estado restaurado para: " + pedido.getEstado().estado());
            AtualizarPaginaAdminAction apa = new AtualizarPaginaAdminAction();
            apa.execute(request, response);
        }
        catch(Exception e){
            try {
                throw e;
            } catch (Exception ex) {
                Logger.getLogger(RetornarEstadoPedidoAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
