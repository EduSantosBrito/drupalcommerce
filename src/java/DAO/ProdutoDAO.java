/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Produto;
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
public class ProdutoDAO {
    private static ProdutoDAO instance = new ProdutoDAO();
    private Connection conn = null;
    private Statement st = null;
    
    private ProdutoDAO(){}
    
    public static ProdutoDAO getInstance(){
        return instance;
    }
    
    public List<Produto> getProdutoByCategoria(String categoria) throws SQLException, ClassNotFoundException {
        List<Produto> produtos = new ArrayList<>();
        
        String sql = "SELECT * FROM tb_prdt WHERE ctgr_prdt = '" + categoria + "'";
        
        try{
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                Produto produto = new Produto();
                produto.setCodigo(Integer.parseInt(rs.getString("cdg_prdt")));
                produto.setDescricao(rs.getString("dscr_prdt"));
                produto.setMarca(rs.getString("mrc_prdt"));
                produto.setPreco(Double.parseDouble(rs.getString("prc_prdt")));
                produto.setQuantidade(Integer.parseInt(rs.getString("qtd_estq_prdt")));
                produto.setTitulo(rs.getString("ttl_prdt"));
                produto.setCategoria(rs.getString("ctgr_prdt"));
                produto.setSubCategoria(rs.getString("sb_ctgr_prdt"));
                
                produtos.add(produto);
            }
        }
        catch(SQLException e) {
            throw e;
        }
        finally {
            closeResources(conn, st);
        }
        
        return produtos;
    }
    
    public List<Produto> getProdutoBySubCategoria(String subCategoria) throws SQLException, ClassNotFoundException {
        List<Produto> produtos = new ArrayList<>();
        
        String sql = "SELECT * FROM tb_prdt WHERE sb_ctgr_prdt = '" + subCategoria + "'";
        
        try{
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                Produto produto = new Produto();
                produto.setCodigo(Integer.parseInt(rs.getString("cdg_prdt")));
                produto.setDescricao(rs.getString("dscr_prdt"));
                produto.setMarca(rs.getString("mrc_prdt"));
                produto.setPreco(Double.parseDouble(rs.getString("prc_prdt")));
                produto.setQuantidade(Integer.parseInt(rs.getString("qtd_estq_prdt")));
                produto.setTitulo(rs.getString("ttl_prdt"));
                produto.setCategoria(rs.getString("ctgr_prdt"));
                produto.setSubCategoria(rs.getString("sb_ctgr_prdt"));
                
                produtos.add(produto);
            }
        }
        catch(SQLException e) {
            throw e;
        }
        finally {
            closeResources(conn, st);
        }
        
        return produtos;
    }
    
    public Produto getProdutoByID(int codigo) throws SQLException, ClassNotFoundException{
        Produto produto = new Produto();
        
        String sql = "SELECT * FROM tb_prdt WHERE cdg_prdt = " + codigo;
        
        try{
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                produto.setCodigo(Integer.parseInt(rs.getString("cdg_prdt")));
                produto.setDescricao(rs.getString("dscr_prdt"));
                produto.setMarca(rs.getString("mrc_prdt"));
                produto.setPreco(Double.parseDouble(rs.getString("prc_prdt")));
                produto.setQuantidade(Integer.parseInt(rs.getString("qtd_estq_prdt")));
                produto.setTitulo(rs.getString("ttl_prdt"));
                produto.setCategoria(rs.getString("ctgr_prdt"));
                produto.setSubCategoria(rs.getString("sb_ctgr_prdt"));
            }
        }
        catch(SQLException e) {
            throw e;
        }
        finally {
            closeResources(conn, st);
        }
        
        return produto;
    }
    
    public List<Produto> getAllProduto() throws ClassNotFoundException, SQLException{
        List<Produto> produtos = new ArrayList<>();
        
        String sql = "SELECT * FROM tb_prdt";
        
        try{
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                Produto produto = new Produto();
                produto.setCodigo(Integer.parseInt(rs.getString("cdg_prdt")));
                produto.setDataCadastro(LocalDate.parse(rs.getString("dt_cdstr_prdt")));
                produto.setDescricao(rs.getString("dscr_prdt"));
                produto.setMarca(rs.getString("mrc_prdt"));
                produto.setPreco(Double.parseDouble(rs.getString("prc_prdt")));
                produto.setQuantidade(Integer.parseInt(rs.getString("qtd_estq_prdt")));
                produto.setTitulo(rs.getString("ttl_prdt"));
                produto.setCategoria(rs.getString("ctgr_prdt"));
                produto.setSubCategoria(rs.getString("sb_ctgr_prdt"));
                
                produtos.add(produto);
            }
        }
        catch(SQLException e) {
            throw e;
        }
        finally {
            closeResources(conn, st);
        }
        
        return produtos;
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
