/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideaspymes.dddexample.infrastructure.repository.internal;

import com.ideaspymes.dddexample.application.shared.Audit;
import com.ideaspymes.dddexample.infrastructure.model.Factura;
import com.ideaspymes.dddexample.infrastructure.repository.FacturaRepository;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author christian.romero
 */
@Audit
@ApplicationScoped
public class DefaultFacturaRepository implements FacturaRepository, Serializable {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Factura create(Factura e) {
        em.persist(e);
        em.flush();
        em.refresh(e);
        return e;
    }

    @Override
    public Factura update(Factura e) {
        e = em.merge(e);
        this.em.flush();
        this.em.refresh(e);
        return e;
    }

    @Override
    public Factura findById(Long id) {
        return em.find(Factura.class, id);
    }

    @Override
    public List<Factura> findByAll() {
        return em.createQuery("SELECT e FROM Factura e").getResultList();
    }

}
