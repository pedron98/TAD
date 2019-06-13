/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unipe.pedro.test;

import br.com.unipe.pedro.dao.ClienteDAO;
import br.com.unipe.pedro.model.bean.Cliente;
import br.com.unipe.pedro.model.bean.enums.Sexo;

/**
 *
 * @author pedro
 */
public class ClienteTest {
    
    public static void main(String[] args) {
        
        ClienteDAO dao = new ClienteDAO();
        
        //Registra um cliente
        Cliente cliente = new Cliente();
        cliente.setNome("Rodrigo da Cruz Fujioka");
        cliente.setIdade(28);
        cliente.setSexo(Sexo.M);
        cliente.setRua("Rua dos Alfeneiros");
        cliente.setBairro("condado de Surrey");
        cliente.setNumero(4);
         
        //Retorna todos os clientes
        for(Cliente c : dao.findAll()){
            System.out.println("Nome: " + c.getNome());
        }      
        
    }
    
}
