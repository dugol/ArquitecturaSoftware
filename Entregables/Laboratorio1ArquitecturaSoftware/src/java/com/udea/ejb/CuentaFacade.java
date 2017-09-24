/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.ejb;

import com.udea.entity.Cuenta;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Daniel
 */
@Stateless
public class CuentaFacade extends AbstractFacade<Cuenta> implements CuentaFacadeLocal {

    @PersistenceContext(unitName = "Laboratorio1ArquitecturaSoftwarePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CuentaFacade() {
        super(Cuenta.class);
    }

    @Override
    public boolean checkLogin(String username, String password) {
        Query q=em.createQuery("select c from Cuenta c where c.username=:user and c.password=:password");
        q.setParameter("user",username);
        q.setParameter("password", password);
        return q.getResultList().size()>0;
    }
    
}
