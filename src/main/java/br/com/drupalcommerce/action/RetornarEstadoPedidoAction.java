/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.drupalcommerce.action;

import br.com.drupalcommerce.controller.Action;
import br.com.drupalcommerce.model.EstadosSalvosSingleton;
import br.com.drupalcommerce.model.Pedido;
import br.com.drupalcommerce.model.PedidoMemento;
import br.com.drupalcommerce.model.PosicionamentoEstados;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RetornarEstadoPedidoAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String codigoPedido = request.getParameter("idRetorno");
        
        try{
            Pedido pedido = new Pedido();
            pedido = pedido.getPedido(Integer.parseInt(codigoPedido));
            PosicionamentoEstados estados = EstadosSalvosSingleton.getInstance().getMapaEstados().get(pedido);
            PedidoMemento m = new PedidoMemento(pedido.getEstado());
            
            try{
                List<PedidoMemento> mementos = estados.getListaMemento();
            
                if(mementos != null){
                boolean teste = true;

                    for(PedidoMemento mm : mementos){
                        if(mm.getEstadoSalvo().estado().equals(m.getEstadoSalvo().estado())){
                            teste = false;
                        }
                    }

                    if(teste){
                        EstadosSalvosSingleton.getInstance().setMapaEstados(pedido, m);
                    }
                }
            }
            catch(Exception e){
            }
            PedidoMemento memento = EstadosSalvosSingleton.getInstance().retornarEstado(pedido);
            if(memento != null){
                pedido.restoreFromMemento(memento);
                pedido.alterarPedido();
                request.setAttribute("alteracaoEstado", "Estado restaurado para: " + pedido.getEstado().estado());
            } else {
                request.setAttribute("alteracaoEstado", "Não ha estado a ser recuperado");
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
