/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.virtualshop.model;

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
