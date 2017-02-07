/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideaspymes.dddexample.infrastructure.repository.internal;

import com.ideaspymes.dddexample.application.shared.Audit;
import com.ideaspymes.dddexample.infrastructure.model.MovCuenta;
import com.ideaspymes.dddexample.infrastructure.repository.MovCuentaRepository;
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
public class DefaultMovCuentaRepository implements MovCuentaRepository, Serializable {

    @PersistenceContext
    private EntityManager em;

    @Override
    public MovCuenta create(MovCuenta e) {
        em.persist(e);
        em.flush();
        em.refresh(e);
        return e;
    }

    @Override
    public MovCuenta update(MovCuenta e) {
        e = em.merge(e);
        this.em.flush();
        this.em.refresh(e);
        return e;
    }

    @Override
    public MovCuenta findById(Long id) {
        return em.find(MovCuenta.class, id);
    }

    @Override
    public List<MovCuenta> findByAll() {
        return em.createQuery("SELECT e FROM MovCuenta e").getResultList();
    }

}
