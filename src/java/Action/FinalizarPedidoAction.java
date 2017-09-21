/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Action;

import Controller.Action;
import DAO.PedidoDAO;
import Model.Item;
import Model.Usuario;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Automateasy
 */
public class FinalizarPedidoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
        try {
            for(Item item : usuario.getCarrinho().getItens() ){
                PedidoDAO.getInstance().salvarPedido(usuario, item);
            }
            usuario.getCarrinho().finalizar();
            VisualizarPedidoAction v = new VisualizarPedidoAction();
            v.execute(request, response);
        }
        catch(Exception e){
            try {
                VisualizarPedidoAction v = new VisualizarPedidoAction();
                v.execute(request, response);
                throw e;
            } catch (Exception ex) {
                Logger.getLogger(FinalizarPedidoAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
