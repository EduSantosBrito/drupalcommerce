/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.drupalcommerce.action;
import br.com.drupalcommerce.controller.Action;
import br.com.drupalcommerce.dao.PedidoDAO;
import br.com.drupalcommerce.dao.ProdutoDAO;
import br.com.drupalcommerce.dao.PromocaoDAO;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author Eduardo
 */
public class AtualizarPaginaAdminAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        
        try{
            request.setAttribute("promocoes", PromocaoDAO.getInstance().getAllPromocao());
            request.setAttribute("produtos", ProdutoDAO.getInstance().getAllProduto());
            request.setAttribute("pedidos", PedidoDAO.getInstance().getAllPedido());
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Admin/index.jsp");
            if(rd != null)
                rd.forward(request, response);
        }
        catch(Exception e){
            try {
                throw e;
            } catch (Exception ex) {
                Logger.getLogger(AtualizarPaginaAdminAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
