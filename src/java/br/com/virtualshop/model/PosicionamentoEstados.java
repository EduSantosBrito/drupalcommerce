/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.virtualshop.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author macanha
 */
public class PosicionamentoEstados {
    private int ponteiro = 0;
    private List<PedidoMemento> lista = new ArrayList<PedidoMemento>();

    public int getPonteiro() {
        return ponteiro;
    }

    public void setPonteiro(int ponteiro) {
        this.ponteiro = ponteiro;
    }

    public List<PedidoMemento> getLista() {
        return lista;
    }

    public void setLista(List<PedidoMemento> lista) {
        this.lista = lista;
    }

}
