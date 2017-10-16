package br.com.virtualshop.model;

import java.util.ArrayList;
import java.util.List;

public class PosicionamentoEstados {
    
    private int posicao = 0;
    private List<PedidoMemento> listaMemento = new ArrayList<>();

    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    public List<PedidoMemento> getListaMemento() {
        return listaMemento;
    }

    public void setListaMemento(PedidoMemento lista) {
        this.listaMemento.add(lista);
    }

}
