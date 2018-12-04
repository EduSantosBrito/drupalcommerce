/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.drupalcommerce.action;

import br.com.drupalcommerce.controller.Action;
import br.com.drupalcommerce.model.Produto;
import br.com.drupalcommerce.model.PromocaoGenerica;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Eduardo
 */
public class RemoverPromocaoProdutoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String codigoProduto = request.getParameter("produto-codigo");
        
        try{
            if(codigoProduto != null){
                Produto produto = new Produto();
                produto = produto.getProduto(Integer.parseInt(codigoProduto));
                PromocaoGenerica promocao = new PromocaoGenerica();
                promocao.removerPromocaoProduto(produto);
                AtualizarPaginaAdminAction apa = new AtualizarPaginaAdminAction();
                apa.execute(request, response);
            }
            else{
                request.setAttribute("erroRemocaoPromocao", "Nenhum produto selecionado");
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
