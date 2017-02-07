/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideaspymes.dddexample.domain;

import com.ideaspymes.dddexample.infrastructure.model.Factura;

/**
 *
 * @author Elias
 */
public interface FacturaDomainService {

    Factura creaFactura(Factura f);
}
