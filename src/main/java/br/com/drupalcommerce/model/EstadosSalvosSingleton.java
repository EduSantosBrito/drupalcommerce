package br.com.drupalcommerce.model;

import java.util.HashMap;
import java.util.Map;

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
        PosicionamentoEstados estados = null;
        try{
            estados = mapaEstados.get(pedido);
            if(estados != null){
                int p = estados.getPosicao() - 1;
                if(p < 0)
                    return null;
                estados.setPosicao(p);
                PedidoMemento m = estados.getListaMemento().get(p - 1);
                return m;
            }
        }
        catch(Exception e){ throw e;}
        return null;
    }
    
    public PedidoMemento avancarEstado(Pedido pedido){
        PosicionamentoEstados estados = null;
        try{
            estados = mapaEstados.get(pedido);
            if(estados != null){
                int p = estados.getPosicao();
                estados.setPosicao(p + 1);
                if(p == estados.getListaMemento().size())
                    return null;
                PedidoMemento m = estados.getListaMemento().get(p);
                return m;
            }
        }
        catch(Exception e){ throw e;}
        return null;
    }
    
    public void setMapaEstados(Pedido pedido, PedidoMemento estado) {
        PosicionamentoEstados estados = null;
        try{
            estados = mapaEstados.get(pedido);
            if(estados != null){
                if(estados.getListaMemento().size() > 2){
                    int p = estados.getPosicao() - 1;
                    estados.getListaMemento().subList(p, estados.getListaMemento().size() - 1).clear();
                }
                estados.setListaMemento(estado);
                estados.setPosicao(estados.getPosicao() + 1);
                mapaEstados.put(pedido, estados);
            } else {
                estados = new PosicionamentoEstados();
                estados.setListaMemento(estado);
                estados.setPosicao(estados.getPosicao() + 1);
                mapaEstados.put(pedido, estados);
            }
        }
        catch(Exception e){ throw e;}
    }
    
}
