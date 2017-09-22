/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Strategy.Pagamento;

/**
 *
 * @author Automateasy
 */
public class PagamentoFactory {
    public static Pagamento create(String action) throws Exception{
        Pagamento actionObject = null;
        String nomeClasse = "Strategy.Pagamento" + action;
        Class classe = null;
        Object object = null;
        try {
            classe = Class.forName(nomeClasse);
            object = classe.newInstance();
        }
        catch(Exception ex){
            throw ex;
        }
        if(!(object instanceof Pagamento)) return null;
        actionObject = (Pagamento) object;
        return actionObject;
    }
}
