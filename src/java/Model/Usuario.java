/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sandr
 */
public class Usuario {
    
    private Integer codigo;
    private String nome;
    private String email;
    private String senha;
    private String endereco;
    private Integer telefone;
    private final Carrinho carrinho;
    private List<Pedido> pedidos = new ArrayList<>();
    
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

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(Pedido pedido) {
        this.pedidos.add(pedido);
    }
    
    public Item comprarProduto(Produto produto, Integer quantidade){
        Item item = new Item();
        item.setProduto(produto);
        item.setQuantidade(quantidade);
        
        return item;
    }
}
