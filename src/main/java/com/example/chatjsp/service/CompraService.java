package com.example.chatjsp.service;

import com.example.chatjsp.model.Compra;

import java.util.ArrayList;

public interface CompraService {
    ArrayList<Compra> getCompraArrayList();
    void addCompra(Compra compra);
    void loadCompraArrayList();
}
