package com.example.chatjsp.service.impl;

import com.example.chatjsp.model.Cliente;
import com.example.chatjsp.model.Compra;
import com.example.chatjsp.persistence.Persistence;
import com.example.chatjsp.service.CompraService;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

import static java.sql.Types.NULL;

public class CompraServiceImpl implements CompraService {
    ArrayList<Compra> compraArrayList = new ArrayList<>();

    public ArrayList<Compra> getCompraArrayList() {
        return compraArrayList;
    }

    public void addCompra(Compra compra) {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/compras_cliente";
        String user = "admin_user";
        String password = "admin";
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
            ps = connection.prepareStatement("INSERT INTO compras VALUES (?,?,?,?,?,?,?)");
            ps.setInt(1, NULL);
            ps.setString(2, compra.getCliente().getName());
            ps.setString(3, compra.getCliente().getLastname());
            ps.setString(4, compra.getCliente().getUsername());
            ps.setString(5, compra.getCliente().getPassword());
            ps.setString(6, compra.getProduct());
            ps.setString(7, String.valueOf(compra.getPrice()));
            ps.executeUpdate();
            System.out.println("Conexion realizada con exito");
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                if (connection != null){
                    connection.close();
                }
            }catch (SQLException e){
                System.out.println(e);
            }
        }
    }

        public void loadCompraArrayList(){
        this.compraArrayList = cargarDatosSQL();
    }

    public ArrayList<Compra> cargarDatosSQL(){
        ArrayList<Compra> compras = new ArrayList<>();

        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/compras_cliente";
        String user = "admin_user";
        String password = "admin";
        try {
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url,user,password);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM compras");
            while (rs.next()){
                compras.add(new Compra(rs.getString("product"),Double.parseDouble(rs.getString("price")),
                        new Cliente(rs.getString("name"),rs.getString("lastname"),rs.getString("username"),
                                rs.getString("password"))));
                System.out.println(rs.getString("name") + " añadido con exito al array");
            }
            statement.close();
            return compras;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
