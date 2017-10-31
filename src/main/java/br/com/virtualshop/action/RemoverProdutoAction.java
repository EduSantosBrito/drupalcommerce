/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.virtualshop.action;

import br.com.virtualshop.controller.Action;
import br.com.virtualshop.dao.ProdutoDAO;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Automateasy
 */
public class RemoverProdutoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String codigo = request.getParameter("produto-codigo");
        
        try{
            if(codigo == null){
                request.setAttribute("erroRemocaoProduto", "Nenhum produto selecionado");
                AtualizarPaginaAdminAction apa = new AtualizarPaginaAdminAction();
                apa.execute(request, response);
            }else{
                ProdutoDAO.getInstance().removerProduto(ProdutoDAO.getInstance().getProdutoByID(Integer.parseInt(codigo)));
                AtualizarPaginaAdminAction apa = new AtualizarPaginaAdminAction();
                apa.execute(request, response);
            }
        }
        catch(Exception e){
            try {
                throw e;
            } catch (Exception ex) {
                Logger.getLogger(RemoverProdutoAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}