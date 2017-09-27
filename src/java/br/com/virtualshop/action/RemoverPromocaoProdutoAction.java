/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.virtualshop.action;

import br.com.virtualshop.controller.Action;
import br.com.virtualshop.dao.ProdutoDAO;
import br.com.virtualshop.dao.PromocaoDAO;
import br.com.virtualshop.model.Produto;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Automateasy
 */
public class RemoverPromocaoProdutoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String codigoProduto = request.getParameter("produto-codigo");
        
        try{
            if(codigoProduto != null){
                Produto produto = ProdutoDAO.getInstance().getProdutoByID(Integer.parseInt(codigoProduto));
                PromocaoDAO.getInstance().removerPromocaoProduto(produto);
                AtualizarPaginaAdminAction apa = new AtualizarPaginaAdminAction();
                apa.execute(request, response);
            }
            else{
                request.setAttribute("erroRemocao", "Nenhum produto selecionado");
                AtualizarPaginaAdminAction apa = new AtualizarPaginaAdminAction();
                apa.execute(request, response);
            }
        }
        catch(Exception e){
            try {
                throw e;
            } catch (Exception ex) {
                Logger.getLogger(RemoverPromocaoProdutoAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
