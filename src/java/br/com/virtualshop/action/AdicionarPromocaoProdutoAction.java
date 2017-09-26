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
import br.com.virtualshop.model.Promocao;
import br.com.virtualshop.model.PromocaoGenerica;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author macanha
 */
public class AdicionarPromocaoProdutoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer codigoProduto = Integer.parseInt(request.getParameter("produto-codigo"));
        Integer codigoPromocao = Integer.parseInt(request.getParameter("promocao-codigo"));
        
        try{
            Produto produto = ProdutoDAO.getInstance().getProdutoByID(codigoProduto);
            Promocao promocao = PromocaoDAO.getInstance().getPromocaoByID(codigoPromocao);
            
            PromocaoDAO.getInstance().salvarPromocaoProduto((PromocaoGenerica) promocao, produto);
            
            AtualizarPaginaAdminAction apa = new AtualizarPaginaAdminAction();
            apa.execute(request, response);
        }
        catch(Exception e){
            try {
                throw e;
            } catch (Exception ex) {
                Logger.getLogger(AdicionarPromocaoProdutoAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
}
