package com.example.chatjsp.model;

public class Compra {
    private String product;

    private double price;

    private Cliente cliente;

    public Compra(String product, double price, Cliente cliente) {
        this.product = product;
        this.price = price;
        this.cliente = cliente;
    }

    public Compra() {

    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
