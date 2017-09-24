package DAO;

import Controller.EstadoFactory;
import Model.Item;
import Model.Pedido;
import Model.Usuario;
import State.PedidoEstadoAnalise;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import State.PedidoEstado;

public class PedidoDAO {
    private static PedidoDAO instance = new PedidoDAO();
    private Connection conn = null;
    private Statement st = null;
    
    private PedidoDAO(){}
    
    public static PedidoDAO getInstance() {
        return instance;
    }
    
    public List<Pedido> getAllPedido() throws ClassNotFoundException, SQLException{
        List<Pedido> pedidos = new ArrayList<>();
        String sql = "SELECT * FROM tb_pdd";
        
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                Pedido pedido = new Pedido();
                pedido.setCodigo(Integer.parseInt(rs.getString("cdg_pdd")));
                pedido.setProduto(ProdutoDAO.getInstance().getProdutoByID(Integer.parseInt(rs.getString("cdg_prdt"))));
                pedido.setPreco(Double.parseDouble(rs.getString("prc_pdd")));
                pedido.setQuantidade(Integer.parseInt(rs.getString("qtd_prdt")));
                pedido.setDesconto(Integer.parseInt(rs.getString("dsct_pdd")));
                pedido.setDataPedido(LocalDate.parse(rs.getString("dt_pdd")));
                
                String estado = rs.getString("std_pdd");
                try{
                    PedidoEstado actionObject = null;
                    if(estado == null || estado.equals(""))
                        pedido.setEstado(null);
                    actionObject = EstadoFactory.create(estado);
                    if(actionObject != null)
                        pedido.setEstado(actionObject);
                }
                catch(Exception e){
                    pedido.setEstado(null);
                }
                
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
    
    public void salvarPedido(Usuario usuario, Item item) throws SQLException, ClassNotFoundException{
        String estado = new PedidoEstadoAnalise().estado();
        String sql = "INSERT INTO tb_pdd (cdg_usr, cdg_prdt, qtd_prdt, prc_pdd, dt_pdd, dsct_pdd, std_pdd) VALUES " +
                "(" + usuario.getCodigo() +
                ", " + item.getProduto().getCodigo() +
                ", " + item.getQuantidade() +
                ", " + item.getProduto().getPreco() * item.getQuantidade() + 
                ", '" + LocalDate.now() +
                "', " + usuario.getCarrinho().getPagamento().obterDesconto() +
                ", '" + estado +
                "')";
        
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
    
    public Pedido getPedidoByID(Integer id) throws SQLException, ClassNotFoundException{
        Pedido pedido = new Pedido();
        String sql = "SELECT * FROM tb_pdd WHERE cdg_pdd = " + id;
        
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                pedido.setCodigo(Integer.parseInt(rs.getString("cdg_pdd")));
                pedido.setProduto(ProdutoDAO.getInstance().getProdutoByID(Integer.parseInt(rs.getString("cdg_prdt"))));
                pedido.setPreco(Double.parseDouble(rs.getString("prc_pdd")));
                pedido.setQuantidade(Integer.parseInt(rs.getString("qtd_prdt")));
                pedido.setDataPedido(LocalDate.parse(rs.getString("dt_pdd")));
                
                String estado = rs.getString("std_pdd");
                try{
                    PedidoEstado actionObject = null;
                    if(estado == null || estado.equals(""))
                        pedido.setEstado(null);
                    actionObject = EstadoFactory.create(estado);
                    if(actionObject != null)
                        pedido.setEstado(actionObject);
                }
                catch(Exception e){
                    pedido.setEstado(null);
                }
            }
        }
        catch(SQLException e) {
            throw e;
        }
        finally {
            closeResources(conn, st);
        }
        
        return pedido;
    }
    
    public void updatePedido(Pedido pedido) throws SQLException, ClassNotFoundException{
        String sql = "UPDATE tb_pdd SET std_pdd = '" + pedido.getEstado().estado() + "' WHERE cdg_pdd = " + pedido.getCodigo();
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
        String sql = "SELECT p.cdg_pdd, p.cdg_prdt, p.qtd_prdt, p.prc_pdd, p.dt_pdd, p.dsct_pdd, p.std_pdd " +
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
                pedido.setDesconto(Integer.parseInt(rs.getString("dsct_pdd")));
                pedido.setDataPedido(LocalDate.parse(rs.getString("dt_pdd")));
                
                String estado = rs.getString("std_pdd");
                try{
                    PedidoEstado actionObject = null;
                    if(estado == null || estado.equals(""))
                        pedido.setEstado(null);
                    actionObject = EstadoFactory.create(estado);
                    if(actionObject != null)
                        pedido.setEstado(actionObject);
                }
                catch(Exception e){
                    pedido.setEstado(null);
                }
                
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
    
    public Usuario getAllEstadoAlterado(Pedido pedido) throws SQLException, ClassNotFoundException{
        Usuario usuario = new Usuario();
        String sql = "SELECT u.cdg_usr, u.nm_usr, u.eml_usr, u.snh_usr, u.ndrc_usr, u.tlfn_usr " +
                     "FROM tb_usr u, tb_pdd p " +
                     "WHERE p.cdg_pdd = " + pedido.getCodigo() +
                     " AND p.cdg_usr = u.cdg_usr";
        
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