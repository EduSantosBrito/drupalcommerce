package br.com.virtualshop.dao;

import br.com.virtualshop.model.Produto;
import br.com.virtualshop.model.PromocaoGenerica;
import br.com.virtualshop.model.Usuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class ProdutoDAO {
    private static ProdutoDAO instance = new ProdutoDAO();
    private Connection conn = null;
    private Statement st = null;
    
    private ProdutoDAO(){}
    
    public static ProdutoDAO getInstance(){
        return instance;
    }
    
    public void salvarProduto(Produto produto) throws SQLException, ClassNotFoundException{
        
        String sql = "INSERT INTO tb_prdt(ttl_prdt, dscr_prdt, mrc_prdt, dt_cdstr_prdt, ctgr_prdt, sb_ctgr_prdt, qtd_estq_prdt, prc_prdt) " +
                     "VALUES ('" + produto.getTitulo() +
                     "', '" + produto.getDescricao() + 
                     "', '" + produto.getMarca() + 
                     "', '" + LocalDate.now() + 
                     "', '" + produto.getCategoria() + 
                     "', '" + produto.getSubCategoria() + 
                     "', " + produto.getQuantidade() + 
                     ", " + produto.getPreco() + 
                     ")";
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
    
    public void alterarProduto(Produto produto) throws SQLException, ClassNotFoundException{
        String sql = "UPDATE tb_prdt SET " +
                     "ttl_prdt = '" + produto.getTitulo() + "', " +
                     "dscr_prdt = '" + produto.getDescricao() + "', " +
                     "mrc_prdt =  '" + produto.getMarca() + "', " +
                     "ctgr_prdt =  '" + produto.getCategoria() + "', " +
                     "sb_ctgr_prdt = '" + produto.getSubCategoria() + "', " +
                     "qtd_estq_prdt = " + produto.getQuantidade() + ", " + 
                     "prc_prdt = " + produto.getPreco() + " " +
                     "WHERE cdg_prdt = " + produto.getCodigo();
        
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
                produto.setCodigo(Integer.parseInt(rs.getString("cdg_prdt")));
                produto.setDescricao(rs.getString("dscr_prdt"));
                produto.setMarca(rs.getString("mrc_prdt"));
                produto.setPreco(Double.parseDouble(rs.getString("prc_prdt")));
                produto.setQuantidade(Integer.parseInt(rs.getString("qtd_estq_prdt")));
                produto.setTitulo(rs.getString("ttl_prdt"));
                produto.setCategoria(rs.getString("ctgr_prdt"));
                produto.setSubCategoria(rs.getString("sb_ctgr_prdt"));
                produto.setDataCadastro(LocalDate.parse(rs.getString("dt_cdstr_prdt")));
                
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
                produto.setDataCadastro(LocalDate.parse(rs.getString("dt_cdstr_prdt")));
                
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
        PromocaoGenerica promocao = new PromocaoGenerica();
        
        String sql = "SELECT p.cdg_prdt, p.ttl_prdt, p.dscr_prdt, p.mrc_prdt, p.dt_cdstr_prdt, p.ctgr_prdt, p.sb_ctgr_prdt, p.qtd_estq_prdt, p.prc_prdt, r.cdg_prm, r.ttl_prm, r.dscnt_prm" +
                     " FROM tb_prdt p, tb_prmprdt pr. tb_prm r" +
                     " WHERE p.cdg_prdt = " + codigo + 
                     " AND pr.cdg_prdt = p.cdg_prdt" + 
                     " AND pr.cdg_prm = r.cdg_prm";
        
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
                produto.setDataCadastro(LocalDate.parse(rs.getString("dt_cdstr_prdt")));
                
                promocao.setCodigo(Integer.parseInt(rs.getString("r.cdg_prm")));
                promocao.setTituloPromocao(rs.getString("r.ttl_prm"));
                promocao.setDescontoPromocao(Integer.parseInt(rs.getString("r.dscnt_prm")));
                
                produto.setPromocao(promocao);
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
        
        String sql = "SELECT p.cdg_prdt, p.ttl_prdt, p.dscr_prdt, p.mrc_prdt, p.dt_cdstr_prdt, p.ctgr_prdt, p.sb_ctgr_prdt, p.qtd_estq_prdt, p.prc_prdt, r.cdg_prm, r.ttl_prm, r.dscnt_prm" + 
                     " FROM tb_prdt p, tb_prmprdt pr. tb_prm r" + 
                     " AND pr.cdg_prdt = p.cdg_prdt" + 
                     " AND pr.cdg_prm = r.cdg_prm";
        
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
                produto.setDataCadastro(LocalDate.parse(rs.getString("dt_cdstr_prdt")));
                                
                PromocaoGenerica promocao = new PromocaoGenerica();
                promocao.setCodigo(Integer.parseInt(rs.getString("r.cdg_prm")));
                promocao.setTituloPromocao(rs.getString("r.ttl_prm"));
                promocao.setDescontoPromocao(Integer.parseInt(rs.getString("r.dscnt_prm")));
                
                produto.setPromocao(promocao);
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
                produto.setCodigo(Integer.parseInt(rs.getString("cdg_prdt")));
                produto.setDescricao(rs.getString("dscr_prdt"));
                produto.setMarca(rs.getString("mrc_prdt"));
                produto.setPreco(Double.parseDouble(rs.getString("prc_prdt")));
                produto.setQuantidade(Integer.parseInt(rs.getString("qtd_estq_prdt")));
                produto.setTitulo(rs.getString("ttl_prdt"));
                produto.setCategoria(rs.getString("ctgr_prdt"));
                produto.setSubCategoria(rs.getString("sb_ctgr_prdt"));
                produto.setDataCadastro(LocalDate.parse(rs.getString("dt_cdstr_prdt")));
                
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
            produto.setCodigo(Integer.parseInt(rs.getString("cdg_prdt")));
            produto.setTitulo(rs.getString("ttl_prdt"));
            produto.setDescricao(rs.getString("dscr_prdt"));
            produto.setMarca(rs.getString("mrc_prdt"));
            produto.setPreco(Double.parseDouble(rs.getString("prc_prdt")));
            produto.setCategoria(rs.getString("ctgr_prdt"));
            produto.setSubCategoria(rs.getString("sb_ctgr_prdt"));
            produto.setQuantidade(Integer.parseInt(rs.getString("qtd_estq_prdt")));
            produto.setDataCadastro(LocalDate.parse(rs.getString("dt_cdstr_prdt")));
            
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