/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideaspymes.dddexample.application.internal;

import com.ideaspymes.dddexample.application.FacturaService;
import com.ideaspymes.dddexample.application.shared.Audit;
import com.ideaspymes.dddexample.domain.FacturaDomainService;
import com.ideaspymes.dddexample.infrastructure.model.Factura;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Elias
 */

@Stateless
public class DefaultFacturaService implements FacturaService {

    @Inject
    private FacturaDomainService facturaDomainService;

    @Override
    public Factura create(Factura f) {
        return facturaDomainService.creaFactura(f);
    }

}
