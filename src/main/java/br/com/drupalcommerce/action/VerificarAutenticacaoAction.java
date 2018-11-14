package br.com.drupalcommerce.action;

import br.com.drupalcommerce.controller.Action;
import br.com.drupalcommerce.controller.ActionFactory;
import br.com.drupalcommerce.model.Usuario;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
                
                usuario = usuario.autenticar();
                request.getSession().removeAttribute("usuario");
                request.getSession().setAttribute("usuario", usuario);
                
                Action actionObject;
                if(pagina == null || pagina.equals(""))
                    response.sendRedirect("/index");
                else if("perfil".equals(pagina)){
                    RequestDispatcher rd = request.getRequestDispatcher("/Usuario/" + pagina + ".jsp");
                    if(rd != null)
                        rd.forward(request, response);
                }
                else if("admin".equals(pagina)){
                    AtualizarPaginaAdminAction apa = new AtualizarPaginaAdminAction();
                    apa.execute(request, response);
                }
                else{
                    actionObject = ActionFactory.create(pagina);
                    if(actionObject != null)
                        actionObject.execute(request, response);
                }
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