/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.virtualshop.action;

import br.com.virtualshop.controller.Action;
import br.com.virtualshop.dao.PedidoDAO;
import br.com.virtualshop.dao.ProdutoDAO;
import br.com.virtualshop.model.Produto;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sandr
 */
public class AlterarProdutoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer codigo = Integer.parseInt(request.getParameter("codigo-produto"));
        String titulo = request.getParameter("titulo");
        Integer qtd = Integer.parseInt(request.getParameter("qtd"));
        String descricao = request.getParameter("descricao");
        String marca = request.getParameter("marca");
        Double preco = Double.parseDouble(request.getParameter("preco"));
        String categoria = request.getParameter("produto-categoria");
        String subCategoria = request.getParameter("produto-sub-categoria");
  
        try{
            Produto produto = ProdutoDAO.getInstance().getProdutoByID(codigo);
            produto.setTitulo(titulo);
            produto.setDescricao(descricao);
            produto.setMarca(marca);
            produto.setPreco(preco);
            produto.setCategoria(categoria);
            produto.setSubCategoria(subCategoria);
            produto.setQuantidadeUpdate(qtd);
            
            ProdutoDAO.getInstance().alterarProduto(produto);
            
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
                Logger.getLogger(AlterarProdutoAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
