package com.example.chatjsp.servlet;

import com.example.chatjsp.model.Compra;
import com.example.chatjsp.service.impl.Negocio;

import java.util.ArrayList;
import java.util.Map;

public class ModelFactoryController {

    Negocio negocio;
    private static class SingletonHolder {
        private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
    }
    public static ModelFactoryController getInstance() {
        return SingletonHolder.eINSTANCE;
    }
    public ModelFactoryController() {
        System.out.println("invocación clase singleton");
        negocio = new Negocio();
    }

    //ArrayCompra

    public void addCompra(Compra compra){
        negocio.getCompraService().addCompra(compra);
    }

    public ArrayList<Compra> getCompras(){
        return negocio.getCompraService().getCompraArrayList();
    }

    public void initializeCompraList(){
        negocio.getCompraService().loadCompraArrayList();
    }

    public Map<String,String> formValidation(String name , String lastName,String username,String password,String product,Double price){
        return negocio.getFormValidation().formValidation(name,lastName,username,password,product,price);
    }
}
