/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unipe.pedro.connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author pedro
 */
public class ConnectionFactory {
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("meuPU");
    
    public EntityManager getConnection() {
        
        return emf.createEntityManager();
        
    }
    
}
