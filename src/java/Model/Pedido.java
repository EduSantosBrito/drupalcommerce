package Model;

import Action.AletarAlteracaoEstadoAction;
import State.PedidoEstadoAnalise;
import State.PedidoState;
import java.time.LocalDate;
import java.util.List;
import java.util.Observable;

public class Pedido extends Observable{
    
    private final Usuario usuario;
    private Integer codigo;
    private Produto produto;
    private Integer quantidade;
    private Double preco;
    private LocalDate dataPedido;
    private PedidoState estado;
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

    public PedidoState getEstado() {
        return estado;
    }

    public void setEstado(PedidoState estado) {
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
    
    public void setEstadoUpdate(PedidoState estado) throws ClassNotFoundException {
        if(this.estado != estado){
            List<Usuario> clientes = AletarAlteracaoEstadoAction.getInstance().alertarClientes(this);
            setChanged();
            notifyObservers();
        }
        this.estado = estado;
    }
}