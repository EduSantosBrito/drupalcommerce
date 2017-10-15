package br.com.virtualshop.model;

import br.com.virtualshop.action.AletarAlteracaoEstadoAction;
import br.com.virtualshop.state.PedidoEstadoAnalise;
import java.time.LocalDate;
import java.util.Observable;
import br.com.virtualshop.state.PedidoEstado;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Pedido extends Observable{
    
    private final Usuario usuario;
    private Integer codigo;
    private Produto produto;
    private Integer quantidade;
    private Double preco;
    private LocalDate dataPedido;
    private PedidoEstado estado;
    private Integer desconto; 
    private List<PedidoMemento> listaEstados = new ArrayList<>();
    
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

    public List<PedidoMemento> getListaEstados() {
        return listaEstados;
    }

    public void setListaEstados(PedidoMemento listaEstados) {
        this.listaEstados.add(listaEstados);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.usuario);
        hash = 31 * hash + Objects.hashCode(this.codigo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pedido other = (Pedido) obj;
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }
    
}