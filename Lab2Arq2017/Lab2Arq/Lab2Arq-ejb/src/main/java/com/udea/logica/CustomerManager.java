/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.logica;

import com.udea.CustomerManagerLocal;
import com.udea.modelo.Customer;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author daniel.uribeg
 */
@Stateless
public class CustomerManager implements CustomerManagerLocal {

    @PersistenceContext(unitName ="com.udea_Lab2Arq-ejb_ejb_1.0")
    private EntityManager em;
    
    
    @Override
    public List<Customer> getAllCustomers() {
        Query query=em.createNamedQuery("Customer.findAll");
        return query.getResultList();
    }

    

   

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public Customer update(Customer customer) {
        return em.merge(customer);
    }
}
