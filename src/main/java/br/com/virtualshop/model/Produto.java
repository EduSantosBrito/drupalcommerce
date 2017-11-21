package br.com.virtualshop.model;

import br.com.virtualshop.action.AletarInteressadosAction;
import br.com.virtualshop.dao.ProdutoDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Observable;
import javax.servlet.http.HttpServletRequest;

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
    
    public Produto getProduto(Integer codigoProduto) throws SQLException, SQLException, ClassNotFoundException {
        return ProdutoDAO.getInstance().getProdutoByID(codigoProduto);
    }
    
    public void salvarProduto() throws SQLException, ClassNotFoundException {
        ProdutoDAO.getInstance().salvarProduto(this);
    }
    
    public void alterarProduto() throws SQLException, SQLException, ClassNotFoundException {
        ProdutoDAO.getInstance().alterarProduto(this);
    }
    
    public List<Observable> getInteressadoByUsuario(Usuario usuario) throws SQLException, SQLException, ClassNotFoundException {
        return ProdutoDAO.getInstance().getInteressadoByUsuario(usuario);
    }
    
    public void removerProduto() throws SQLException, ClassNotFoundException {
        ProdutoDAO.getInstance().removerProduto(this);
    }
    
    public void capturarAtributos(HttpServletRequest request) {
        Integer codigo = Integer.parseInt(request.getParameter("codigo-produto") == null ? request.getParameter("codigo-produto") : "0" );
        String titulo = request.getParameter("titulo");
        Integer qtd = Integer.parseInt(request.getParameter("qtd"));
        String descricao = request.getParameter("descricao");
        String marca = request.getParameter("marca");
        Double preco = Double.parseDouble(request.getParameter("preco"));
        String categoria = request.getParameter("produto-categoria");
        String subCategoria = request.getParameter("produto-sub-categoria");
        
        salvarDados(codigo, titulo, descricao, marca, categoria, subCategoria, qtd, preco, LocalDate.now());
    }
    
    public void receberAtributosDAO(ResultSet rs) throws SQLException {
        Integer codigo = Integer.parseInt(rs.getString("cdg_prdt"));
        String descricao = rs.getString("dscr_prdt");
        String marca = rs.getString("mrc_prdt");
        Double preco = Double.parseDouble(rs.getString("prc_prdt"));
        Integer qtd = Integer.parseInt(rs.getString("qtd_estq_prdt"));
        String titulo = rs.getString("ttl_prdt");
        String categoria = rs.getString("ctgr_prdt");
        String subCategoria = rs.getString("sb_ctgr_prdt");
        LocalDate data = LocalDate.parse(rs.getString("dt_cdstr_prdt"));
        
        salvarDados(codigo, titulo, descricao, marca, categoria, subCategoria, qtd, preco, data);
    }
    
    public void salvarDados(Integer codigo, String titulo, String descricao, String marca, String categoria, String subCategoria, Integer quantidade, Double preco, LocalDate dataCadastro) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.descricao = descricao;
        this.marca = marca;
        this.categoria = categoria;
        this.subCategoria = subCategoria;
        this.quantidade = quantidade;
        this.preco = preco;
        this.dataCadastro = dataCadastro;
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