/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Action;

import Controller.Action;
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
public class DeslogarAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().removeAttribute("usuario");
        RequestDispatcher rd = request.getRequestDispatcher("/index");
            if(rd != null)
                try {
                    rd.forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(DeslogarAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
