package br.com.virtualshop.model;

import br.com.virtualshop.action.AletarInteressadosAction;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Observable;

public class Produto extends Observable{
    
    private Integer codigo;
    private String titulo;
    private String descricao;
    private String marca;
    private String categoria;
    private String subCategoria;
    private Integer quantidade;
    private Double preco;
    private LocalDate dataCadastro;
    private PromocaoGenerica promocao;
    
    public Produto() {}

    public Produto(String titulo, String descricao, String marca, String categoria, String subCategoria, Integer quantidade, Double preco) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.marca = marca;
        this.categoria = categoria;
        this.subCategoria = subCategoria;
        this.quantidade = quantidade;
        this.preco = preco;
    }
    
    public Produto(String titulo, String descricao, String marca, String categoria, String subCategoria, Double preco) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.marca = marca;
        this.categoria = categoria;
        this.subCategoria = subCategoria;
        this.preco = preco;
    }
    
    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getSubCategoria() {
        return subCategoria;
    }

    public void setSubCategoria(String subCategoria) {
        this.subCategoria = subCategoria;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
    
    public void setQuantidadeUpdate(int quantidade) throws ClassNotFoundException, SQLException {
        if(this.quantidade == 0){
            AletarInteressadosAction.getInstance().alertarClientes(this);
            setChanged();
            notifyObservers();
        }
        this.quantidade = quantidade;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public PromocaoGenerica getPromocao() {
        return promocao;
    }

    public void setPromocao(PromocaoGenerica promocao) {
        this.promocao = promocao;
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        else if (obj == null) {
            return false;
        }
        else if (getClass() != obj.getClass()) {
            return false;
        }
        
        final Produto other = (Produto) obj;
        if (!Objects.equals(this.titulo, other.titulo)) {
            return false;
        }
        else if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }
}