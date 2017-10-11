package br.com.virtualshop.model;

import br.com.virtualshop.action.AletarAlteracaoEstadoAction;
import br.com.virtualshop.state.PedidoEstadoAnalise;
import java.time.LocalDate;
import java.util.Observable;
import br.com.virtualshop.state.PedidoEstado;
import java.sql.SQLException;

public class Pedido extends Observable{
    
    private final Usuario usuario;
    private Integer codigo;
    private Produto produto;
    private Integer quantidade;
    private Double preco;
    private LocalDate dataPedido;
    private PedidoEstado estado;
    private Integer desconto; 
    
    public Pedido(Usuario usuario){
        this.usuario = usuario;
        this.estado = new PedidoEstadoAnalise();
    }
    
    public Pedido(){
        this.usuario = null;
    }
    
    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
    
    public LocalDate getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDate dataPedido) {
        this.dataPedido = dataPedido;
    }

    public PedidoEstado getEstado() {
        return estado;
    }

    public void setEstado(PedidoEstado estado) {
        this.estado = estado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Integer getDesconto() {
        return desconto;
    }

    public void setDesconto(Integer desconto) {
        this.desconto = desconto;
    }
    
    public void setEstadoUpdate(PedidoEstado estado) throws ClassNotFoundException, SQLException {
        if(this.estado != estado){
            AletarAlteracaoEstadoAction.getInstance().alertarClientes(this);
            setChanged();
            notifyObservers();
        }
        this.estado = estado;
    }
    
    public String setAnaliseEstado() throws ClassNotFoundException, SQLException{
        return this.estado.analise(this);
    }
    
    public String setAtrasoEstado(){
        return this.estado.atraso(this);
    }
    
    public String setCanceladoEstado(){
        return this.estado.cancelado(this);
    }
    
    public String setEnviadoEstado(){
        return this.estado.enviado(this);
    }
    
    public String setSeparacaoEstado(){
        return this.estado.separacao(this);
    }
    
    public PedidoMemento saveToMemento(){
        return new PedidoMemento(estado);
    }
    
    public void restoreFromMemento(PedidoMemento memento){
        estado = memento.getEstadoSalvo();
    }
}