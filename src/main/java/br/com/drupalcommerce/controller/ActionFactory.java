/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.drupalcommerce.controller;

/**
 *
 * @author Eduardo
 */
public class ActionFactory extends Factory {
	public static Action createAction(String action) throws Exception{
        String nomeClasse = "br.com.drupalcommerce.action." + action + "Action";
        return (Action) create(nomeClasse);
    }
}	
