/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unipe.pedro.dao;

import br.com.unipe.pedro.connection.ConnectionFactory;
import br.com.unipe.pedro.model.bean.Cliente;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author pedro
 */
public class ClienteDAO {
    
    public Cliente save(Cliente cliente){
        
        EntityManager em = new ConnectionFactory().getConnection();
        
        try {
            
            em.getTransaction().begin();
            
            if(cliente.getId() == null){
                em.persist(cliente);
            } else {
                em.merge(cliente);
            }           
            em.getTransaction().commit();        
            
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            
        } finally {
            em.close();
        }
        
        return cliente;
    }
    
    public Cliente findById(Integer id) {
        
        EntityManager em = new ConnectionFactory().getConnection();
        
        Cliente cliente = null;
        
        try {
            
            em.getTransaction().begin();
            
            cliente = em.find(Cliente.class, id);
            
            em.getTransaction().commit();
            
        } catch (Exception e) {
            
            e.printStackTrace();
            
        } finally {
            em.close();
        }
        
        return cliente;
        
    }
    
    public Cliente remove(Integer id) {
        
        EntityManager em = new ConnectionFactory().getConnection();
        
        Cliente cliente = null;
        
        try {
            
            em.getTransaction().begin();
            cliente = em.find(Cliente.class, id);
            em.remove(cliente);
            em.getTransaction().commit();
            
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        
        return cliente;
        
    }
    
    public List<Cliente> findAll() {
        
        EntityManager em = new ConnectionFactory().getConnection();
        
        List<Cliente> clientes = null;
        
        try {
            
           clientes = em.createQuery("from Cliente c").getResultList();
            
        } catch (Exception e) {
            e.printStackTrace();
            
        } finally {
            em.close();
        }
        
        return clientes;
        
    }
    
}
