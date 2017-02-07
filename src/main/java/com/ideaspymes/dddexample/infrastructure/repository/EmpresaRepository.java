/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideaspymes.dddexample.infrastructure.repository;

import com.ideaspymes.dddexample.infrastructure.model.Empresa;
import java.util.List;

/**
 *
 * @author christian.romero
 */
public interface EmpresaRepository {
    
    Empresa create(Empresa e);
    Empresa update(Empresa e);
    Empresa findById(Long id);
    List<Empresa> findByAll();
}
