/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.virtualshop.action;

import br.com.virtualshop.controller.Action;
import br.com.virtualshop.dao.ProdutoDAO;
import br.com.virtualshop.model.Produto;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sandr
 */
public class AlterarProdutoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        
        Produto produto = new Produto();
        
        try{
            produto = ProdutoDAO.getInstance().getProdutoByID(produto.getCodigo());
            
            produto.capturarAtributos(request);

            ProdutoDAO.getInstance().alterarProduto(produto);
            
            AtualizarPaginaAdminAction apa = new AtualizarPaginaAdminAction();
            apa.execute(request, response);
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
