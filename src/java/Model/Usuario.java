package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Usuario implements Observer{
    
    private Integer codigo;
    private String nome;
    private String email;
    private String senha;
    private String endereco;
    private Integer telefone;
    private final Carrinho carrinho;
    private List<Observable> pedidos = new ArrayList<>();
    public List<Observable> produtos = new ArrayList<>();
    
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
    
    @Override
    public void update(Observable produtoObserver, Object o1) {
        if(produtoObserver instanceof Produto){
            System.out.println("ALTERAÇÃO REALIZADA NO PRODUTO");
        }
        if(produtoObserver instanceof Pedido){
            System.out.println("ALTERAÇÃO REALIZADA NO PEDIDO DO USUARIO: " + this.nome + " UM EMAIL DE ALERTA FOI ENVIADO");
        }
    }
}