/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideaspymes.dddexample.application.shared;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author christian.romero
 */
@SessionScoped
public class Credencial implements Serializable{
    private String  user = "admin";

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
    
}
