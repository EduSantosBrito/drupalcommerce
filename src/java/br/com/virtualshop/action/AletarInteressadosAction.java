/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.virtualshop.action;

import br.com.virtualshop.dao.ProdutoDAO;
import br.com.virtualshop.model.Produto;
import br.com.virtualshop.model.Usuario;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Automateasy
 */
public class AletarInteressadosAction {
    private static AletarInteressadosAction instance = new AletarInteressadosAction();
    
    private AletarInteressadosAction(){}
    
    public static AletarInteressadosAction getInstance(){
        return instance;
    }
    
    public List<Usuario> alertarClientes(Produto produto) throws ClassNotFoundException, SQLException{
        List<Usuario> clientes = ProdutoDAO.getInstance().getAllInteressadosByProduto(produto);
        for(int i = 0; i < clientes.size(); i++){
            clientes.get(i).gostarProduto(produto);
        }
        return clientes;
    }
    
}