package br.com.virtualshop.model;

import br.com.virtualshop.dao.UsuarioDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Usuario implements Observer{
    
    private Integer codigo;
    private String nome;
    private String email;
    private String senha;
    private String endereco;
    private Integer telefone;
    private final Carrinho carrinho;
    private List<Observable> pedidos = new ArrayList<>();
    private List<Observable> produtos = new ArrayList<>();
    private List<String> alertas = new ArrayList<>();
    
    public Usuario(String email, String nome, String senha, String endereco, Integer telefone){
        this.email = email;
        this.nome = nome;
        this.senha = senha;
        this.endereco = endereco;
        this.telefone = telefone;
        this.carrinho = new Carrinho(this);
    }
    
    public Usuario() {
        this.carrinho = new Carrinho(this);
    }
    
    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Integer getTelefone() {
        return telefone;
    }

    public void setTelefone(Integer telefone) {
        this.telefone = telefone;
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public List<Observable> getPedidos() {
        return pedidos;
    }

    public void setPedidos(Pedido pedido) {
        this.pedidos.add(pedido);
    }
    
    public void alertaEstadoPedido(Observable pedido){
        this.pedidos.add(pedido);
        pedido.addObserver(this);
    }
    
    public void comprarProduto(Produto produto, Integer quantidade){
        Item item = new Item();
        item.setProduto(produto);
        item.setQuantidade(quantidade);
        this.carrinho.adiciona(item);
    }
  
    public void gostarProduto(Observable produto){
        this.produtos.add(produto);
        produto.addObserver(this);
    }

    public List<Observable> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Observable> produtos) {
        this.produtos = produtos;
    }

    public List<String> getAlertas() {
        return alertas;
    }

    public void setAlertas(String alerta) {
        this.alertas.add(alerta);
    }
    
    public void receberAtributosDAO(ResultSet rs) throws SQLException {
        this.setCodigo(Integer.parseInt(rs.getString("cdg_usr")));
        this.setEmail(rs.getString("eml_usr"));
        this.setNome(rs.getString("nm_usr"));
        this.setEndereco(rs.getString("ndrc_usr"));
        this.setSenha(rs.getString("snh_usr"));
    }
    
    @Override
    public void update(Observable produtoObserver, Object o1) {
        if(produtoObserver instanceof Produto){
            try{
                UsuarioDAO.getInstance().salvarAlerta(this, "Alteração no estoque do produto " + ((Produto) produtoObserver).getTitulo());
            }
            catch(Exception e){
                try {
                    throw e;
                } catch (Exception ex) {
                    Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        if(produtoObserver instanceof Pedido){
            try{
                UsuarioDAO.getInstance().salvarAlerta(this, "Estado do pedido Pedido " + ((Pedido) produtoObserver).getCodigo() + " foi alterado para " + ((Pedido) produtoObserver).getEstado().estado() );
            }
            catch(Exception e){
                try {
                    throw e;
                } catch (Exception ex) {
                    Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}