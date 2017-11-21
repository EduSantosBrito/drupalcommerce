package br.com.virtualshop.action;

import br.com.virtualshop.controller.Action;
import br.com.virtualshop.model.Produto;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrarProdutoAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try{
            Produto produto = new Produto();
            produto.capturarAtributos(request);
            produto.salvarProduto();
            
            AtualizarPaginaAdminAction apa = new AtualizarPaginaAdminAction();
            apa.execute(request, response);
        }
        catch(Exception e){
            
        }
    }
}