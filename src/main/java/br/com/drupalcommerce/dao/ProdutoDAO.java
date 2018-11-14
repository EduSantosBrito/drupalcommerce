package br.com.drupalcommerce.dao;

import br.com.drupalcommerce.model.Produto;
import br.com.drupalcommerce.model.PromocaoGenerica;
import br.com.drupalcommerce.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Observable;

public class ProdutoDAO {
    private static ProdutoDAO instance = new ProdutoDAO();
    private Connection conn = null;
    private Statement st = null;
    private PreparedStatement stmt = null; 

    private ProdutoDAO(){}
    
    public static ProdutoDAO getInstance(){
        return instance;
    }
    
    public void salvarProduto(Produto produto) throws SQLException, ClassNotFoundException{
        try{
            String sql = 
            "INSERT INTO tb_prdt(ttl_prdt, dscr_prdt, mrc_prdt, ctgr_prdt, sb_ctgr_prdt, qtd_estq_prdt, prc_prdt, dt_cdstr_prdt) " +
            "VALUES (?,?,?,?,?,?,?,'"+Date.valueOf(LocalDate.now())+"')";
        
            conn = DatabaseLocator.getInstance().getConnection();
            stmt = conn.prepareStatement(sql);

            receberAtributosStmt(produto, stmt);
            
            stmt.execute();
            stmt.close();
        }
        catch(SQLException e) {
            throw e;
        }
        finally {
            closeResources(conn, st);
        }
    }
    
    public void receberAtributosStmt(Produto produto, PreparedStatement stmt) throws SQLException {
        stmt.setString(1, produto.getTitulo());
        stmt.setString(2, produto.getDescricao());
        stmt.setString(3, produto.getMarca());
        stmt.setString(4, produto.getCategoria());
        stmt.setString(5, produto.getSubCategoria());
        stmt.setInt(6, produto.getQuantidade());
        stmt.setDouble(7, produto.getPreco());
    }
    
    public void alterarProduto(Produto produto) throws SQLException, ClassNotFoundException{
        try{
            String sql = 
                "UPDATE tb_prdt SET " +
                "ttl_prdt = ?, " +
                "dscr_prdt = ?, " +
                "mrc_prdt = ?, " +
                "ctgr_prdt = ?, " +
                "sb_ctgr_prdt = ?, " +
                "qtd_estq_prdt = ?, " + 
                "prc_prdt = ? " +
                "WHERE cdg_prdt = " + produto.getCodigo();
        
            conn = DatabaseLocator.getInstance().getConnection();
            stmt = conn.prepareStatement(sql);
            receberAtributosStmt(produto, stmt);
            stmt.execute();
            stmt.close();
        }
        catch(SQLException e) {
            throw e;
        }
        finally {
            closeResources(conn, st);
        }
    }
    
    public void removerProduto(Produto produto) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM tb_prdt WHERE cdg_prdt = " + produto.getCodigo();
        
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
    
    public List<Produto> getProdutoByCategoria(String categoria) throws SQLException, ClassNotFoundException {
        List<Produto> produtos = new ArrayList<>();
        
        String sql = "SELECT * FROM tb_prdt WHERE ctgr_prdt = '" + categoria + "'";
        
        try{
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                Produto produto = new Produto();
                produto.receberAtributosDAO(rs);
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
                produto.receberAtributosDAO(rs);
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
    
    public Produto getProdutoByID(int id) throws SQLException, ClassNotFoundException{
        Produto produto = new Produto();
        String sql = "SELECT r.cdg_prm, r.ttl_prm, r.dscnt_prm, pr.cdg_prmprdt, p.cdg_prdt, p.ttl_prdt, p.dscr_prdt, p.mrc_prdt, p.ctgr_prdt, p.sb_ctgr_prdt, p.qtd_estq_prdt, p.prc_prdt, p.dt_cdstr_prdt" +
                     " FROM tb_prdt p" +
                     " LEFT JOIN tb_prmprdt pr ON p.cdg_prdt = pr.cdg_prdt " +
                     " LEFT JOIN tb_prm r ON r.cdg_prm = pr.cdg_prm" + 
                     " WHERE p.cdg_prdt = " + id;
        
        try{
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                produto.receberAtributosDAO(rs);
                
                String codigo = rs.getString("cdg_prm");
                String titulo = rs.getString("ttl_prm");
                String desconto = rs.getString("dscnt_prm");
                
                if(codigo != null){
                    PromocaoGenerica promocao = new PromocaoGenerica(Integer.parseInt(codigo), titulo, Integer.parseInt(desconto));
                    produto.setPromocao(promocao);
                }
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
        
        String sql = "SELECT r.cdg_prm, r.ttl_prm, r.dscnt_prm, pr.cdg_prmprdt, p.cdg_prdt, p.ttl_prdt, p.dscr_prdt, p.mrc_prdt, p.ctgr_prdt, p.sb_ctgr_prdt, p.qtd_estq_prdt, p.prc_prdt, p.dt_cdstr_prdt" +
                     " FROM tb_prdt p" +
                     " LEFT JOIN tb_prmprdt pr ON p.cdg_prdt = pr.cdg_prdt " +
                     " LEFT JOIN tb_prm r ON r.cdg_prm = pr.cdg_prm";
        
        try{
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                Produto produto = new Produto();
                produto.receberAtributosDAO(rs);
                
                try{
                    Integer codigo = Integer.parseInt(rs.getString("cdg_prm"));
                    String titulo = rs.getString("ttl_prm");
                    Integer desconto = Integer.parseInt(rs.getString("dscnt_prm"));
                    if(codigo != null){
                        PromocaoGenerica promocao = new PromocaoGenerica(codigo, titulo, desconto);
                        produto.setPromocao(promocao);
                    }
                }catch(Exception e){}
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
        
        String sql = "SELECT cdg_prdt, ttl_prdt, dscr_prdt, mrc_prdt, ctgr_prdt, sb_ctgr_prdt, qtd_estq_prdt, prc_prdt, dt_cdstr_prdt FROM tb_prdt ORDER BY dt_cdstr_prdt LIMIT 10";
        
        try{
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                Produto produto = new Produto();
                produto.receberAtributosDAO(rs);
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
            st.execute("INSERT INTO tb_intrc(cdg_usr, cdg_prdt) VALUES (" + usuario.getCodigo() + ", " + produto.getCodigo() + ")");
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
                "SELECT u.cdg_usr, p.cdg_prdt, p.ttl_prdt, p.dscr_prdt, p.mrc_prdt, p.ctgr_prdt, p.sb_ctgr_prdt, p.qtd_estq_prdt, p.prc_prdt, p.dt_cdstr_prdt " +
                "FROM tb_usr u, tb_prdt p, tb_intrc i " +
                "WHERE p.cdg_prdt = i.cdg_prdt " +
                "AND u.cdg_usr = " + usuario.getCodigo() + " " +
                "GROUP BY p.cdg_prdt"
        );
        
        while(rs.next()){
            Produto produto = new Produto();
            produto.receberAtributosDAO(rs);
            produtos.add(produto);
        }
        
        return produtos;
    }
    
    public List<Usuario> getAllInteressadosByProduto(Produto produto) throws SQLException, ClassNotFoundException{
        String sql = "SELECT u.cdg_usr, u.nm_usr, u.eml_usr, u.ndrc_usr, u.tlfn_usr " +
                     "FROM tb_usr u, tb_prdt p, tb_intrc i " +
                     "WHERE u.cdg_usr = i.cdg_usr " +
                     "AND p.cdg_prdt = i.cdg_prdt " +
                     "AND p.cdg_prdt = " + produto.getCodigo();
        try{
            List<Usuario> usuarios = new ArrayList<>();
            conn=DatabaseLocator.getInstance().getConnection();
            st= conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                Usuario usuario = new Usuario();
                usuario.receberAtributosDAO(rs);
                usuarios.add(usuario);
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