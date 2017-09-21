/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Action;

import Controller.Action;
import DAO.ProdutoDAO;
import Model.Produto;
import Model.Usuario;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Automateasy
 */
public class RemoverProdutoCarrinhoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
        Integer codigo = Integer.parseInt(request.getParameter("id"));
        try {
            Produto produto = ProdutoDAO.getInstance().getProdutoByID(codigo);
            usuario.getCarrinho().remove(produto);
            
            VisualizarPedidoAction v = new VisualizarPedidoAction();
            v.execute(request, response);
        }
        catch(Exception e){
            try {
                throw e;
            } catch (Exception ex) {
                Logger.getLogger(RemoverProdutoCarrinhoAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
