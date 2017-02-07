/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideaspymes.dddexample.application;

import com.ideaspymes.dddexample.infrastructure.model.Factura;
import javax.ejb.Stateless;

/**
 *
 * @author Elias
 */

public interface FacturaService {
    Factura create(Factura f);
}
