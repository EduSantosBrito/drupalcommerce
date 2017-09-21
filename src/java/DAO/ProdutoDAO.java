/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Produto;
import Model.Usuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

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
    
    public List<Produto> getNovosProdutos() throws SQLException, ClassNotFoundException{
        List<Produto> produtos = new ArrayList<>();
        
        String sql = "SELECT cdg_prdt, ttl_prdt, dscr_prdt, mrc_prdt, ctgr_prdt, sb_ctgr_prdt, qtd_estq_prdt, prc_prdt FROM tb_prdt ORDER BY dt_cdstr_prdt LIMIT 10";
        
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
    
    public void salvarInteresse(Usuario usuario, Produto produto) throws ClassNotFoundException, SQLException{
        try {
            conn=DatabaseLocator.getInstance().getConnection();
            st= conn.createStatement();
            st.execute("INSERT INTO tb_intrc(cdg_usr, cdg_prdt) VALUES (" + produto.getCodigo() + ", " + usuario.getCodigo() + ")");
        }
        catch(SQLException e){
            throw e;
        }finally{
            closeResources(conn, st);
        }
    }
    
    public List<Observable> getInteressadoByUsuario(Usuario usuario) throws SQLException, ClassNotFoundException{
        List<Observable> produtos = new ArrayList<>();
        conn=DatabaseLocator.getInstance().getConnection();
        st= conn.createStatement();
        ResultSet rs = st.executeQuery(
                "SELECT u.cdg_usr, p.cdg_prdt, p.ttl_prdt, p.dscr_prdt, p.mrc_prdt, p.ctgr_prdt, p.sb_ctgr_prdt, p.qtd_estq_prdt, p.prc_prdt " +
                "FROM tb_usr u, tb_prdt p, tb_intrc i " +
                "WHERE p.cdg_prdt = i.cdg_prdt " +
                "AND u.cdg_usr = " + usuario.getCodigo() + " " +
                "GROUP BY p.cdg_prdt"
        );
        
        while(rs.next()){
            Produto produto = new Produto();
            produto.setCodigo(Integer.parseInt(rs.getString("cdg_prdt")));
            produto.setTitulo(rs.getString("ttl_prdt"));
            produto.setDescricao(rs.getString("dscr_prdt"));
            produto.setMarca(rs.getString("mrc_prdt"));
            produto.setPreco(Double.parseDouble(rs.getString("prc_prdt")));
            produto.setCategoria(rs.getString("ctgr_prdt"));
            produto.setSubCategoria(rs.getString("sb_ctgr_prdt"));
            produto.setQuantidade(Integer.parseInt(rs.getString("qtd_estq_prdt")));
            produtos.add(produto);
        }
        
        return produtos;
    }
    
    public List<Usuario> getAllInteressadosByProduto(Produto produto) throws SQLException, ClassNotFoundException{
        try{
            List<Usuario> usuarios = new ArrayList<>();
            conn=DatabaseLocator.getInstance().getConnection();
            st= conn.createStatement();
            ResultSet rs = st.executeQuery(
                    "SELECT u.cdg_usr, u.nm_usr, u.eml_usr, u.ndrc_usr, u.tlfn_usr " +
                    "FROM tb_usr u, tb_prdt p, tb_intrc i " +
                    "WHERE c.cdg_usr = i.cdg_usr " +
                    "AND p.cdg_prdt = i.cdg_prdt " +
                    "AND p.cdg_prdt = " + produto.getCodigo());
            while(rs.next()){
                Usuario u = new Usuario();
                u.setCodigo(Integer.parseInt(rs.getString("cdg_usr")));
                u.setEmail(rs.getString("eml_usr"));
                u.setNome(rs.getString("nm_usr"));
                u.setEndereco(rs.getString("ndrc_usr"));
                u.setTelefone(Integer.parseInt(rs.getString("tlfn_usr")));
                
                usuarios.add(u);
            }
            return usuarios;
        }
        catch(SQLException e){
            throw e;
        }finally{
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
