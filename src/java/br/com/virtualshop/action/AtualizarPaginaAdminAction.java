/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.virtualshop.action;
import br.com.virtualshop.controller.Action;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author Automateasy
 */
public class AtualizarPaginaAdminAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        
        try{
            AtualizarPaginaAdminAction apa = new AtualizarPaginaAdminAction();
            apa.execute(request, response);
        }
        catch(Exception e){
            try {
                throw e;
            } catch (Exception ex) {
                Logger.getLogger(AtualizarPaginaAdminAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
