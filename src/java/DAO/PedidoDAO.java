/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Carrinho;
import Model.Item;
import Model.Pedido;
import Model.Usuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Automateasy
 */
public class PedidoDAO {
    private static PedidoDAO instance = new PedidoDAO();
    private Connection conn = null;
    private Statement st = null;
    
    private PedidoDAO(){}
    
    public static PedidoDAO getInstance() {
        return instance;
    }
    
    public void salvarPedido(Usuario usuario, Item item) throws SQLException, ClassNotFoundException{
        String sql = "INSERT INTO tb_pdd (cdg_usr, cdg_prdt, qtd_prdt, prc_pdd, dt_pdd) VALUES " +
                "(" + usuario.getCodigo() +
                ", " + item.getProduto().getCodigo() +
                ", " + item.getQuantidade() +
                ", " + item.getProduto().getPreco() * item.getQuantidade() + 
                ", " + LocalDate.now() +
                ")";
        
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute(sql);
        }
        catch(SQLException e) {
            throw e;
        }
        finally {
            closeResources(conn, st);
        }
    }
    
    public List<Pedido> getPedidoByUsuario(Usuario usuario) throws SQLException, ClassNotFoundException{
        List<Pedido> pedidos = new ArrayList<>();
        String sql = "SELECT p.cdg_pdd, p.cdg_prdt, p.qtd_prdt, p.prc_pdd, p.dt_pdd " +
                     "FROM tb_pdd p, tb_usr u WHERE u.cdg_usr = " + usuario.getCodigo() +
                     " AND u.cdg_usr = p.cdg_usr";
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                Pedido pedido = new Pedido(usuario);
                pedido.setCodigo(Integer.parseInt(rs.getString("cdg_pdd")));
                pedido.setProduto(ProdutoDAO.getInstance().getProdutoByID(Integer.parseInt(rs.getString("cdg_prdt"))));
                pedido.setPreco(Double.parseDouble(rs.getString("prc_pdd")));
                pedido.setQuantidade(Integer.parseInt(rs.getString("qtd_prdt")));
                
                pedidos.add(pedido);
            }
        }
        catch(SQLException e) {
            throw e;
        }
        finally {
            closeResources(conn, st);
        }
        
        return pedidos;
    }
    
    public void closeResources(Connection conn, Statement st) throws SQLException {
        try {
            if(st != null) st.close();
            if(conn != null) conn.close();
        }
        catch(SQLException e){
            throw e;
        }
    }
}
