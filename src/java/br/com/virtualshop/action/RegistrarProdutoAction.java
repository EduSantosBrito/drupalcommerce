package br.com.virtualshop.action;

import br.com.virtualshop.controller.Action;
import br.com.virtualshop.dao.ProdutoDAO;
import br.com.virtualshop.model.Produto;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrarProdutoAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String titulo = request.getParameter("titulo");
        Integer qtd = Integer.parseInt(request.getParameter("qtd"));
        String descricao = request.getParameter("descricao");
        String marca = request.getParameter("marca");
        Double preco = Double.parseDouble(request.getParameter("preco"));
        String categoria = request.getParameter("produto-categoria");
        String subCategoria = request.getParameter("produto-sub-categoria");
        
        Produto produto = new Produto(titulo, descricao, marca, categoria, subCategoria, qtd, preco);
        
        try{
            ProdutoDAO.getInstance().salvarProduto(produto);
            
            AtualizarPaginaAdminAction apa = new AtualizarPaginaAdminAction();
            apa.execute(request, response);
        }
        catch(Exception e){
            
        }
    }
}