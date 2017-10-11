/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.virtualshop.model;

import br.com.virtualshop.state.PedidoEstado;
import java.util.ArrayList;

/**
 *
 * @author macanha
 */
public class EstadosSalvosSingleton {
    
    private ArrayList<PedidoMemento> listaEstados = new ArrayList<>();
    private static EstadosSalvosSingleton instance = new EstadosSalvosSingleton();
    
    private EstadosSalvosSingleton() {}
    
    public static EstadosSalvosSingleton getInstance(){
        return instance;
    }

    public ArrayList<PedidoMemento> getListaEstados() {
        return listaEstados;
    }

    public void setListaEstados(PedidoMemento listaEstados) {
        this.listaEstados.add(listaEstados);
    }
    
}
