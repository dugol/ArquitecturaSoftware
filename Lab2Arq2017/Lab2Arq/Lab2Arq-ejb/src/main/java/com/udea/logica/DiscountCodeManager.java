/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.logica;

import com.udea.modelo.DiscountCode;
import com.udea.modelo.DiscountCodeManagerLocal;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author daniel.uribeg
 */
@Stateless
public class DiscountCodeManager implements DiscountCodeManagerLocal {

    @PersistenceContext(unitName ="com.udea_Lab2Arq-ejb_ejb_1.0")
    private EntityManager em;
    @Override
    public List<DiscountCode> getDiscountCodes() {
        Query query=em.createNamedQuery("DiscountCode.findAll");
        return query.getResultList();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
