package br.com.virtualshop.dao;

import br.com.virtualshop.model.Usuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UsuarioDAO {
    private static UsuarioDAO instance = new UsuarioDAO();
    private Connection conn = null;
    private Statement st = null;
    
    public static UsuarioDAO getInstance(){
        return instance;
    }
    
    public Usuario salvar(Usuario usuario) throws SQLException, ClassNotFoundException{
        Usuario user = new Usuario();
        String sql =    "INSERT INTO tb_usr (nm_usr, eml_usr, snh_usr, ndrc_usr, tlfn_usr) VALUES" +
                        "(" +
                            "'" + usuario.getNome() + 
                            "','" + usuario.getEmail() + 
                            "','" + usuario.getSenha() + 
                            "','" + usuario.getEndereco() + 
                            "'," + usuario.getTelefone() +
                        ");";
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute(sql);
            ResultSet rs = st.executeQuery("SELECT * FROM tb_usr WHERE eml_usr = '" + usuario.getEmail() + "'");
            while(rs.next()){
                user.setCodigo(Integer.parseInt(rs.getString("cdg_usr")));
                user.setEmail(rs.getString("eml_usr"));
                user.setNome(rs.getString("nm_usr"));
                user.setEndereco(rs.getString("ndrc_usr"));
                user.setSenha(rs.getString("snh_usr"));
            }
        }
        catch(SQLException e) {
            throw e;
        }
        finally {
            closeResources(conn, st);
        }
        
        return user;
    }
    
    public Usuario autentica(Usuario usuario) throws SQLException, ClassNotFoundException{
        String sql = "SELECT * FROM tb_usr WHERE eml_usr = '" + usuario.getEmail() + "' AND snh_usr = '" + usuario.getSenha() + "';";
        Usuario usuarioAutenticado = new Usuario();
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute(sql);
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                usuarioAutenticado.setCodigo(Integer.parseInt(rs.getString("cdg_usr")));
                usuarioAutenticado.setEmail(rs.getString("eml_usr"));
                usuarioAutenticado.setNome(rs.getString("nm_usr"));
                usuarioAutenticado.setEndereco(rs.getString("ndrc_usr"));
                usuarioAutenticado.setSenha(rs.getString("snh_usr"));
            }
        }
        catch(SQLException e) {
            throw e;
        }
        finally {
            closeResources(conn, st);
        }
        
        usuarioAutenticado = getAlertas(usuarioAutenticado);
        
        return usuarioAutenticado;
    }
    
    public Usuario getUsuarioByEmail(String email) throws SQLException, ClassNotFoundException{
        String sql = "SELECT * FROM tb_usr WHERE eml_usr = '" + email + "'";
        Usuario usuario = new Usuario();
        
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute(sql);
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                usuario.setCodigo(Integer.parseInt(rs.getString("cdg_usr")));
                usuario.setEmail(rs.getString("eml_usr"));
                usuario.setNome(rs.getString("nm_usr"));
                usuario.setEndereco(rs.getString("ndrc_usr"));
                usuario.setSenha(rs.getString("snh_usr"));
            }
        }
        catch(SQLException e) {
            throw e;
        }
        finally {
            closeResources(conn, st);
        }
        
        return usuario;
    }
    
    public void salvarAlerta(Usuario usuario, String alerta) throws SQLException, ClassNotFoundException{
        String sql = "INSERT INTO tb_lrtusr (ttl_lrt, cdg_usr) VALUES ('" + alerta + "', " + usuario.getCodigo() +")";
        
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
    
    public Usuario getAlertas(Usuario usuario) throws SQLException, ClassNotFoundException {
        String sql = "SELECT ttl_lrt FROM tb_lrtusr WHERE cdg_usr = " + usuario.getCodigo();
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                String alerta = rs.getString("ttl_lrt");
                usuario.setAlertas(alerta);
            }
        }
        catch(SQLException e) {
            throw e;
        }
        finally {
            closeResources(conn, st);
        }
        
        return usuario;
    }
    
    public void removeAlerta(Integer id) throws SQLException, ClassNotFoundException{
        String sql = "DELETE FROM tb_lrtusr WHERE cdg_usr = " + id; 
        
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