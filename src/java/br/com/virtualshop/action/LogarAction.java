/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.virtualshop.action;

import br.com.virtualshop.controller.Action;
import br.com.virtualshop.dao.UsuarioDAO;
import br.com.virtualshop.model.Usuario;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Automateasy
 */
public class LogarAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String email = request.getParameter("email_login");
        String senha = request.getParameter("senha_login");
        Usuario usuario = new Usuario();
        usuario.setEmail(email);
        usuario.setSenha(senha);
        try {
            usuario = UsuarioDAO.getInstance().autentica(usuario);
            if(usuario.getCodigo() == null){
                request.getSession().setAttribute("errorLogin", "Email ou senha incorretos!");
                RequestDispatcher rd = request.getRequestDispatcher("/Usuario/login.jsp");
                if(rd != null)
                    rd.forward(request, response);
            }else{
                request.getSession().setAttribute("errorLogin", "");
                request.getSession().setAttribute("usuario", usuario);
                RequestDispatcher rd = request.getRequestDispatcher("/index");
                if(rd != null)
                    rd.forward(request, response);
            }
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
