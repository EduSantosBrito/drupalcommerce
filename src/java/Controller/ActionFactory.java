/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author Automateasy
 */
public class ActionFactory {
    public static Action create(String action) throws Exception{
        Action actionObject = null;
        String nomeClasse = "Action." + action + "Action";
        Class classe = null;
        Object object = null;
        try {
            classe = Class.forName(nomeClasse);
            object = classe.newInstance();
        }
        catch(Exception ex){
            throw ex;
        }
        if(!(object instanceof Action)) return null;
        actionObject = (Action) object;
        return actionObject;
    }
}