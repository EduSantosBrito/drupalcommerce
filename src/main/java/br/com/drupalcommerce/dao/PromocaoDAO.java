/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.drupalcommerce.dao;

import br.com.drupalcommerce.model.Produto;
import br.com.drupalcommerce.model.Promocao;
import br.com.drupalcommerce.model.PromocaoGenerica;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author macanha
 */
public class PromocaoDAO {
    private static PromocaoDAO instance = new PromocaoDAO();
    private Connection conn = null;
    private Statement st = null;
    
    private PromocaoDAO(){}
    
    public static PromocaoDAO getInstance(){
        return instance;
    }
    
    public void salvarPromocao(Promocao promocao) throws SQLException, ClassNotFoundException{
        String sql = "INSERT INTO tb_prm(ttl_prm, dscnt_prm) VALUES ('" + promocao.getTitulo() + "'," + promocao.getDesconto() + ")";
        
        try{
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
    
    public List<PromocaoGenerica> getAllPromocao() throws SQLException, ClassNotFoundException{
        List<PromocaoGenerica> promocoes = new ArrayList<>();
        String sql = "SELECT * FROM tb_prm";
        
        try{
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                PromocaoGenerica pg = new PromocaoGenerica();
                pg.receberAtributosDAO(rs);
                promocoes.add(pg);
            }
        }
        catch(SQLException e) {
            throw e;
        }
        finally {
            closeResources(conn, st);
        }
        
        return promocoes;
    }
    
    public PromocaoGenerica getPromocaoByID(Integer id) throws ClassNotFoundException, SQLException{
        String sql = "SELECT * FROM tb_prm WHERE cdg_prm = " + id;
        PromocaoGenerica promocao = new PromocaoGenerica();
        try{
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                promocao.receberAtributosDAO(rs);
            }
        }
        catch(SQLException e) {
            throw e;
        }
        finally {
            closeResources(conn, st);
        }
        
        return promocao;
    }
    
    public void salvarPromocaoProduto(PromocaoGenerica promocao, Produto produto) throws SQLException, ClassNotFoundException{
        String sql = "INSERT INTO tb_prmprdt(cdg_prdt, cdg_prm) VALUES (" + produto.getCodigo() + ", " + promocao.getCodigo() + ")";
        
        try{
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
    
    public void removerPromocaoProduto(Produto produto) throws SQLException, ClassNotFoundException{
        String sql = "DELETE FROM tb_prmprdt WHERE cdg_prdt = " + produto.getCodigo();
        
        try{
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
