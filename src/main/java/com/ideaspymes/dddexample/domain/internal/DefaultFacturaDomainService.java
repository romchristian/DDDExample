/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideaspymes.dddexample.domain.internal;

import com.ideaspymes.dddexample.domain.FacturaDomainService;
import com.ideaspymes.dddexample.infrastructure.model.Factura;
import com.ideaspymes.dddexample.infrastructure.model.MovCuenta;
import com.ideaspymes.dddexample.infrastructure.repository.FacturaRepository;
import com.ideaspymes.dddexample.infrastructure.repository.MovCuentaRepository;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 *
 * @author Elias
 */
@ApplicationScoped
public class DefaultFacturaDomainService implements FacturaDomainService{

    @Inject
    private FacturaRepository facturaRepository;
    @Inject
    private MovCuentaRepository movCuentaRepository;
    
    @Override
    public Factura creaFactura(Factura f) {
        Factura R = facturaRepository.create(f);
        MovCuenta m = new MovCuenta();
        m.setCliente(f.getCliente());
        m.setMonto(f.getMonto());
        movCuentaRepository.create(m);
        return R;
    }
    
}
