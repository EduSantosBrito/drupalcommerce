/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.virtualshop.model;

import br.com.virtualshop.dao.PromocaoDAO;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author macanha
 */
public class PromocaoGenerica extends Promocao {
    private Integer codigo;
    private String tituloPromocao;
    private Integer descontoPromocao;

    public PromocaoGenerica() {}
    
    public PromocaoGenerica(Integer codigo, String tituloPromocao, Integer descontoPromocao) {
        this.codigo = codigo;
        this.tituloPromocao = tituloPromocao;
        this.descontoPromocao = descontoPromocao;
    }
    
    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getTituloPromocao() {
        return tituloPromocao;
    }

    public void setTituloPromocao(String tituloPromocao) {
        this.tituloPromocao = tituloPromocao;
    }

    public Integer getDescontoPromocao() {
        return descontoPromocao;
    }

    public void setDescontoPromocao(Integer descontoPromocao) {
        this.descontoPromocao = descontoPromocao;
    }
    
    public void salvarPromocao() throws SQLException, SQLException, ClassNotFoundException {
        PromocaoDAO.getInstance().salvarPromocao(this);
    }
    
    public PromocaoGenerica getPromocao(Integer codigoPromocao) throws ClassNotFoundException, ClassNotFoundException, SQLException {
        return PromocaoDAO.getInstance().getPromocaoByID(codigoPromocao);
    }
    
    public void removerPromocaoProduto(Produto produto) throws SQLException, SQLException, ClassNotFoundException {
        PromocaoDAO.getInstance().removerPromocaoProduto(produto);
    }
    
    public void salvarPromocaoProduto(Produto produto) throws SQLException, SQLException, ClassNotFoundException {
        PromocaoDAO.getInstance().salvarPromocaoProduto(this, produto);
    }
    
    public void receberAtributosDAO(ResultSet rs) throws SQLException {
        this.setCodigo(Integer.parseInt(rs.getString("cdg_prm")));
        this.setTituloPromocao(rs.getString("ttl_prm"));
        this.setDescontoPromocao(Integer.parseInt(rs.getString("dscnt_prm")));
    }
    
    @Override
    public String getTitulo() {
        return this.tituloPromocao;
    }

    @Override
    public Integer getDesconto() {
        return this.descontoPromocao;
    }
    
    
}
