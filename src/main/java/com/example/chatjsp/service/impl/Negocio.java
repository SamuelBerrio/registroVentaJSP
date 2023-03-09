package com.example.chatjsp.service.impl;

import com.example.chatjsp.service.CompraService;
import com.example.chatjsp.service.FormValidation;

public class Negocio {
    private final CompraService compraService;

    private final FormValidation formValidation;

    public Negocio(){
        compraService = new CompraServiceImpl();
        formValidation = new FormValidationImpl();
    }

    public CompraService getCompraService() {
        return compraService;
    }

    public FormValidation getFormValidation() {
        return formValidation;
    }
}
