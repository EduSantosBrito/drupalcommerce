/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Action;

import Controller.Action;
import Controller.ActionFactory;
import Model.Usuario;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Automateasy
 */
public class VerificarAutenticacaoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
        String pagina = request.getParameter("pagina");
        try{
            if(usuario == null){
                RequestDispatcher rd = request.getRequestDispatcher("/Usuario/login.jsp");
                if(rd != null)
                    rd.forward(request, response);
            }else {
                Action actionObject = null;
                if(pagina == null || pagina.equals(""))
                    response.sendRedirect("index.jsp");
                if(pagina.equals("perfil")){
                    RequestDispatcher rd = request.getRequestDispatcher("/Usuario/" + pagina + ".jsp");
                    if(rd != null)
                        rd.forward(request, response);
                }
                actionObject = ActionFactory.create(pagina);
                if(actionObject != null)
                    actionObject.execute(request, response);
            }
        }
        catch(Exception e){
            try {
                throw e;
            } catch (Exception ex) {
                Logger.getLogger(VerificarAutenticacaoAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
