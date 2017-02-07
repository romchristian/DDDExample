/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideaspymes.dddexample.infrastructure.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;

/**
 *
 * @author christian.romero
 */
@Entity
public class Empresa extends BaseEntityAudit{
    private String nombre;
    
    @Embedded
    private Direccion direccion;

   
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Direccion getDireccion() {
        if (direccion == null) {
            direccion = new Direccion();
        }
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

}
