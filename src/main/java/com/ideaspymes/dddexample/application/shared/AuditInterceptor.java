/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideaspymes.dddexample.application.shared;

import com.ideaspymes.dddexample.infrastructure.model.BaseEntityAudit;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 *
 * @author christian.romero
 */
@Audit
@Interceptor
public class AuditInterceptor {

    @Inject
    private Credencial credencial;

    @AroundInvoke
    public Object audit(InvocationContext context) throws Exception {
        Object result = context.proceed();
        BaseEntityAudit R = null;
        if (result instanceof BaseEntityAudit) {
            R = (BaseEntityAudit) result;
            System.out.println("Method Name: " + context.getMethod().getName());
            switch (context.getMethod().getName().trim()) {
                case "create":
                    R.setCreatedBy(credencial.getUser());
                    break;
                case "update":
                    R.setUpdatedBy(credencial.getUser());
                    break;
            }
        }
        if (R == null) {
            return result;
        } else {
            return R;
        }
    }

}
