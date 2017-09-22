/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Action;

import Controller.Action;
import DAO.PedidoDAO;
import DAO.ProdutoDAO;
import Model.Produto;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Automateasy
 */
public class RegistrarProdutoAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String titulo = request.getParameter("titulo");
        Integer qtd = Integer.parseInt(request.getParameter("qtd"));
        String descricao = request.getParameter("descricao");
        String marca = request.getParameter("marca");
        Double preco = Double.parseDouble(request.getParameter("preco"));
        String categoria = request.getParameter("produto-categoria");
        String subCategoria = request.getParameter("produto-sub-categoria");
        
        Produto produto = new Produto(titulo, descricao, marca, categoria, subCategoria, qtd, preco);
        
        try{
            ProdutoDAO.getInstance().salvarProduto(produto);
            
            request.setAttribute("produtos", ProdutoDAO.getInstance().getAllProduto());
            request.setAttribute("pedidos", PedidoDAO.getInstance().getAllPedido());
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Admin/index.jsp");
            if(rd != null)
                rd.forward(request, response);
        }
        catch(Exception e){
            
        }
    }
}
