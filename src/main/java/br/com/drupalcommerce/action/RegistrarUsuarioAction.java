/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.drupalcommerce.action;

import br.com.drupalcommerce.controller.Action;
import br.com.drupalcommerce.dao.UsuarioDAO;
import br.com.drupalcommerce.model.Usuario;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Eduardo
 */
public class RegistrarUsuarioAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try{
            Usuario usuario = new Usuario();
            usuario.capturarAtributos(request);
            
            Usuario u = new Usuario();
            u = u.getUsuarioByEmail();
            
            if(u.getCodigo() != null){
                request.getSession().setAttribute("error", "Email já cadastrado!");
                RequestDispatcher rd = request.getRequestDispatcher("/Usuario/login.jsp");
            if(rd != null)
                rd.forward(request, response);
            }
            
            usuario = UsuarioDAO.getInstance().salvar(usuario);
            request.getSession().setAttribute("usuario", usuario);
            RequestDispatcher rd = request.getRequestDispatcher("/index");
            if(rd != null)
                rd.forward(request, response);
        }
        catch(Exception e){
            try {
                throw e;
            } catch (Exception ex) {
                Logger.getLogger(RegistrarUsuarioAction.class.getName()).log(Level.SEVERE, null, ex);
            }
            RequestDispatcher rd = request.getRequestDispatcher("/Usuario/login.jsp");
            if(rd != null)
                try {
                    rd.forward(request, response);
            } catch (ServletException ex) {
                Logger.getLogger(RegistrarUsuarioAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
