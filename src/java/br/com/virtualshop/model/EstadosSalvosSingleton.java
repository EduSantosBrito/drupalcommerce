/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.virtualshop.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author macanha
 */
public class EstadosSalvosSingleton {
    
    private Map<Pedido, PosicionamentoEstados> mapaEstados = new HashMap<>();

    private static EstadosSalvosSingleton instance = new EstadosSalvosSingleton();
    
    private EstadosSalvosSingleton() {}
    
    public static EstadosSalvosSingleton getInstance(){
        return instance;
    }
 
    public Map<Pedido, PosicionamentoEstados> getMapaEstados() {
        return mapaEstados;
    }
    
    public PedidoMemento retornarEstado(Pedido pedido){
        PosicionamentoEstados mapa = mapaEstados.get(pedido);
        List<PedidoMemento> estados = mapa.getLista();
        PedidoMemento estado = estados.get(mapa.getPonteiro());
        mapa.setPonteiro(mapa.getPonteiro() + 1 );
        return estado;
    }
    
    public PedidoMemento avancarEstado(Pedido pedido){
        PosicionamentoEstados mapa = mapaEstados.get(pedido);
        List<PedidoMemento> estados = mapa.getLista();
        PedidoMemento estado = estados.get(mapa.getPonteiro());
        mapa.setPonteiro(mapa.getPonteiro() - 1 );
        return estado;
    }
    
    public void setMapaEstados(Pedido pedido, PedidoMemento estado) {
        PosicionamentoEstados estados = new PosicionamentoEstados();
        List<PedidoMemento> recuar = new ArrayList<>();
        recuar.add(estado);
        estados.setLista(recuar);
        this.mapaEstados.put(pedido, estados);
    }
    
}
