/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideaspymes.dddexample.infrastructure.repository.internal;

import com.ideaspymes.dddexample.infrastructure.model.Empresa;
import com.ideaspymes.dddexample.infrastructure.repository.EmpresaRepository;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author christian.romero
 */
@ApplicationScoped
public class DefaultEmpresaRepository implements EmpresaRepository, Serializable {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Empresa create(Empresa e) {
        em.persist(e);
        em.flush();
        em.refresh(e);
        return e;
    }

    @Override
    public Empresa update(Empresa e) {
        e = em.merge(e);
        this.em.flush();
        this.em.refresh(e);
        return e;
    }

    @Override
    public Empresa findById(Long id) {
        return em.find(Empresa.class, id);
    }

    @Override
    public List<Empresa> findByAll() {
        return em.createQuery("SELECT e FROM Empresa e").getResultList();
    }

}
