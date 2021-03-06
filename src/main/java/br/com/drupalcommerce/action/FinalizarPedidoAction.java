package br.com.drupalcommerce.action;

import br.com.drupalcommerce.controller.Action;
import br.com.drupalcommerce.controller.PagamentoFactory;
import br.com.drupalcommerce.model.Item;
import br.com.drupalcommerce.model.Usuario;
import br.com.drupalcommerce.strategy.Pagamento;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FinalizarPedidoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
        String pagamento = request.getParameter("pagamento");
        try {
            //Pagamento factory
            Pagamento actionObject = null;
            if(pagamento == null || pagamento.equals(""))
                response.sendRedirect("/index");
            actionObject = (Pagamento) PagamentoFactory.create(pagamento);
            if(actionObject != null)
                usuario.getCarrinho().setPagamento(actionObject);
            
            for(Item item : usuario.getCarrinho().getItens() ){
                usuario.salvarPedido(item);
            }
            
            usuario.getCarrinho().finalizar();
            VisualizarPedidoAction visualizarPedidoAction = new VisualizarPedidoAction();
            visualizarPedidoAction.execute(request, response);
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
