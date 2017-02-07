/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideaspymes.dddexample.infrastructure.repository;

import com.ideaspymes.dddexample.infrastructure.model.Factura;
import java.util.List;

/**
 *
 * @author christian.romero
 */
public interface FacturaRepository {
    
    Factura create(Factura e);
    Factura update(Factura e);
    Factura findById(Long id);
    List<Factura> findByAll();
}
