/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Action;

import Controller.Action;
import DAO.ProdutoDAO;
import Model.Produto;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Automateasy
 */
public class ListaProdutosSubCategoriaAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String subCategoria = request.getParameter("subCategoria");
        
        try {
            List<Produto> produtos = ProdutoDAO.getInstance().getProdutoBySubCategoria(subCategoria);
            if(produtos == null){
                RequestDispatcher rd = request.getRequestDispatcher("/index");
                if(rd != null)
                    rd.forward(request, response);
            }else{
                request.setAttribute("produtos", produtos);
                RequestDispatcher rd = request.getRequestDispatcher("/Produto/produtos.jsp");
                if(rd != null)
                    rd.forward(request, response);
            }
        }
        catch(Exception e){
            try {
                throw e;
            } catch (Exception ex) {
                Logger.getLogger(RegistrarUsuarioAction.class.getName()).log(Level.SEVERE, null, ex);
            }
            RequestDispatcher rd = request.getRequestDispatcher("/index");
            if(rd != null)
                try {
                    rd.forward(request, response);
            } catch (ServletException ex) {
                Logger.getLogger(RegistrarUsuarioAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
