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
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdicionarPromocaoProdutoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer codigoProduto = Integer.parseInt(request.getParameter("produto-codigo"));
        Integer codigoPromocao = Integer.parseInt(request.getParameter("promocao-codigo"));
        
        try{
            Produto produto = new Produto();
            produto = produto.getProduto(codigoProduto);
            PromocaoGenerica promocao = new PromocaoGenerica();
            promocao = promocao.getPromocao(codigoPromocao);
            
            if( produto.getPromocao() != null || Objects.equals(produto.getCodigo(), promocao.getCodigo()) ){
                request.setAttribute("erroAdicionarPromocao", "O Produto já possui uma promoção!");
                AtualizarPaginaAdminAction apa = new AtualizarPaginaAdminAction();
                apa.execute(request, response);
            }
            else{
                promocao.removerPromocaoProduto(produto);
                promocao.salvarPromocaoProduto(produto);

                AtualizarPaginaAdminAction apa = new AtualizarPaginaAdminAction();
                apa.execute(request, response);
            }
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
