/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideaspymes.dddexample.infrastructure.repository;

import com.ideaspymes.dddexample.infrastructure.model.MovCuenta;
import java.util.List;

/**
 *
 * @author christian.romero
 */
public interface MovCuentaRepository {
    
    MovCuenta create(MovCuenta e);
    MovCuenta update(MovCuenta e);
    MovCuenta findById(Long id);
    List<MovCuenta> findByAll();
}
