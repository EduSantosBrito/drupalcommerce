/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.drupalcommerce.action;

import br.com.drupalcommerce.controller.Action;
import br.com.drupalcommerce.model.Produto;
import br.com.drupalcommerce.model.Usuario;
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
public class InteresseProdutoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
        Integer codigoProduto = Integer.parseInt(request.getParameter("id"));
        try{
            Produto produto = new Produto();
            produto = produto.getProduto(codigoProduto);
            usuario.setProdutos(produto.getInteressadoByUsuario(usuario));
            
            if(usuario.getProdutos().contains(produto)){
                RequestDispatcher rd = request.getRequestDispatcher("/index");
                if(rd != null)
                    rd.forward(request, response);
            }else{
                usuario.gostarProduto(produto);
                RequestDispatcher rd = request.getRequestDispatcher("/index");
                if(rd != null)
                    rd.forward(request, response);
            }
        }
        catch(Exception e){
            try {
                throw e;
            } catch (Exception ex) {
                Logger.getLogger(InteresseProdutoAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
