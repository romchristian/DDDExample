/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideaspymes.dddexample.application.internal;

import com.ideaspymes.dddexample.application.EmpresaService;
import com.ideaspymes.dddexample.application.shared.Audit;
import com.ideaspymes.dddexample.infrastructure.model.Empresa;
import com.ideaspymes.dddexample.infrastructure.repository.EmpresaRepository;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author christian.romero
 */
@Audit
@Stateless
public class DefaultEmpresaService implements EmpresaService {

    @Inject
    private EmpresaRepository empresaRepository;

    @Override
    public Empresa create(Empresa e) {
        return empresaRepository.create(e);
    }

    @Override
    public Empresa update(Empresa e) {
        return empresaRepository.update(e);
    }

    @Override
    public Empresa findById(Long id) {
        return empresaRepository.findById(id);
    }

    @Override
    public List<Empresa> findByAll() {
        return empresaRepository.findByAll();
    }

}
