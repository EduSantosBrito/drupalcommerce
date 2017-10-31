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
import br.com.virtualshop.model.PedidoMemento;
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
        String codigoPedido = request.getParameter("idAvanco");
        
        try{
            Pedido pedido = PedidoDAO.getInstance().getPedidoByID(Integer.parseInt(codigoPedido));
            PedidoMemento memento = EstadosSalvosSingleton.getInstance().avancarEstado(pedido);
            if(memento != null){
                pedido.restoreFromMemento(memento);
                PedidoDAO.getInstance().updatePedido(pedido);
                request.setAttribute("alteracaoEstado", "Estado avançado para: " + pedido.getEstado().estado());
            } else {
                request.setAttribute("alteracaoEstado", "Não ha estado a ser avançado");
            }
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
