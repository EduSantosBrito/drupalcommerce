/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.virtualshop.action;

import br.com.virtualshop.controller.Action;
import br.com.virtualshop.model.EstadosSalvosSingleton;
import br.com.virtualshop.model.Pedido;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sandr
 */
public class AlterarEstadoPedidoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer codigoPedido = Integer.parseInt(request.getParameter("pedido-codigo"));
        String estadoPedido = request.getParameter("estado");
        
        try{
            Pedido pedido = new Pedido();
            pedido = pedido.getPedido(codigoPedido);
            
            String estadoAtual = pedido.getEstado().estado();
            if(!estadoAtual.equals(estadoPedido))
                EstadosSalvosSingleton.getInstance().setMapaEstados(pedido, pedido.saveToMemento());
            
            String estado = pedido.getPedidoEstado(estadoPedido);

            pedido.salvarPedido();
            
            request.setAttribute("alteracaoEstado", estado);
            AtualizarPaginaAdminAction apa = new AtualizarPaginaAdminAction();
            apa.execute(request, response);
        }
        catch(Exception e){
            try {
                throw e;
            } catch (Exception ex) {
                Logger.getLogger(AlterarEstadoPedidoAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
