/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideaspymes.dddexample.presetation;

import com.ideaspymes.dddexample.application.EmpresaService;
import com.ideaspymes.dddexample.infrastructure.model.Empresa;
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
public class EmpresaController implements Serializable {

    @EJB
    private EmpresaService empresaService;

    private Empresa actual;
    private long id;
    private List<Empresa> lista;

    public List<Empresa> getLista() {
        if (lista == null) {
            lista = empresaService.findByAll();
        }
        return lista;
    }

    public void setLista(List<Empresa> lista) {
        this.lista = lista;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Empresa getActual() {
        if (actual == null) {
            actual = new Empresa();
        }
        return actual;
    }

    public void setActual(Empresa actual) {
        this.actual = actual;
    }

    public void initView() {
        if (id > 0) {
            actual = empresaService.findById(id);
        }
    }

    public String create() {
        String R = null;
        try {
            empresaService.create(actual);
            R = "listado";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e.getMessage());
        }
        return R;
    }

    public String update() {
        String R = null;
        try {
            empresaService.update(actual);
            R = "listado";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e.getMessage());
        }
        return R;
    }
}
