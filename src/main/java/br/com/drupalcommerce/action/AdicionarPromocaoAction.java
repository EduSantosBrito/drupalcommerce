/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.drupalcommerce.action;

import br.com.drupalcommerce.controller.Action;
import br.com.drupalcommerce.model.PromocaoGenerica;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdicionarPromocaoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String titulo = request.getParameter("titulo");
        Integer desconto = Integer.parseInt(request.getParameter("desconto"));
        
        try{
            PromocaoGenerica promocao = new PromocaoGenerica();
            promocao.setTituloPromocao(titulo);
            promocao.setDescontoPromocao(desconto);
            promocao.salvarPromocao();
            
            AtualizarPaginaAdminAction apa = new AtualizarPaginaAdminAction();
            apa.execute(request, response);
        }
        catch(Exception e){
            try {
                throw e;
            } catch (Exception ex) {
                Logger.getLogger(AdicionarPromocaoAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
            
    }
}
