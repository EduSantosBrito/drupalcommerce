<<<<<<< HEAD
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Usuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Automateasy
 */
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
        
        return usuarioAutenticado;
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
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Usuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Automateasy
 */
public class UsuarioDAO {
    private static UsuarioDAO instance = new UsuarioDAO();
    private Connection conn = null;
    private Statement st = null;
    
    public static UsuarioDAO getInstance(){
        return instance;
    }
    
    public Usuario salvar(Usuario usuario) throws SQLException, ClassNotFoundException{
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
        }
        catch(SQLException e) {
            throw e;
        }
        finally {
            closeResources(conn, st);
        }
        
        return usuario;
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
        
        return usuarioAutenticado;
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
>>>>>>> c9c8b6bf5d3fb2e451aa96ef91c0a61196a02b4a
