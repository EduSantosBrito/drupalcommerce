/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.drupalcommerce.action;

import br.com.drupalcommerce.model.Produto;
import br.com.drupalcommerce.model.Usuario;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Eduardo
 */
public class AletarInteressadosAction {
    private static AletarInteressadosAction instance = new AletarInteressadosAction();
    
    private AletarInteressadosAction(){}
    
    public static AletarInteressadosAction getInstance(){
        return instance;
    }
    
    public void alertarClientes(Produto produto) throws ClassNotFoundException, SQLException{
        Usuario usuario = new Usuario();
        List<Usuario> clientes = usuario.getUsuariosInteressados(produto);
        for(int i = 0; i < clientes.size(); i++){
            clientes.get(i).gostarProduto(produto);
        }
    }
}
