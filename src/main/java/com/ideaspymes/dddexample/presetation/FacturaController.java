/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideaspymes.dddexample.presetation;

import com.ideaspymes.dddexample.application.FacturaService;
import com.ideaspymes.dddexample.infrastructure.model.Factura;
import com.ideaspymes.dddexample.presetation.shared.JsfUtil;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author christian.romero
 */
@Named
@ViewScoped
public class FacturaController implements Serializable {

    @EJB
    private FacturaService service;

    private Factura actual;
    

    public Factura getActual() {
        if (actual == null) {
            actual = new Factura();
        }
        return actual;
    }

    public void setActual(Factura actual) {
        this.actual = actual;
    }

   

    public String create() {
        String R = null;
        try {
            service.create(actual);
            //R = "listado";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e.getMessage());
        }
        return R;
    }

 
}
