/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.virtualshop.action;

import br.com.virtualshop.controller.Action;
import br.com.virtualshop.dao.PromocaoDAO;
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
public class AdicionarPromocaoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String titulo = request.getParameter("titulo");
        Integer desconto = Integer.parseInt(request.getParameter("desconto"));
        
        try{
            PromocaoGenerica promocao = new PromocaoGenerica();
            promocao.setTituloPromocao(titulo);
            promocao.setDescontoPromocao(desconto);
            
            PromocaoDAO.getInstance().salvarPromocao(promocao);
            
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
