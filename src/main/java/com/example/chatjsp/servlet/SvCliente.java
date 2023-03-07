package com.example.chatjsp.servlet;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.example.chatjsp.model.Cliente;
import com.example.chatjsp.model.Compra;
import com.example.chatjsp.persistence.Persistence;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "SvCliente", urlPatterns = "/register-clientes")
public class SvCliente extends HttpServlet {
    private String message;
    private List<Compra> compraList = new ArrayList<>();

    public List<Compra> getCompraList() {
        return compraList;
    }

    public void init() {
        initializeUsersList();
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        session.setAttribute("compraList",this.compraList);
        response.sendRedirect("listCompras.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Double price = 0.0;
        if (!req.getParameter("firstName").isBlank() || !req.getParameter("lastName").isBlank() ||
        !req.getParameter("username").isBlank() || !req.getParameter("password").isBlank() ||
        !req.getParameter("product").isBlank() || !req.getParameter("price").isBlank()){
            String name = req.getParameter("firstName");
            String lastName = req.getParameter("lastName");
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            String product = req.getParameter("product");
            price = Double.parseDouble(req.getParameter("price"));

            Compra compra = new Compra(product,price,
                    new Cliente(name,lastName,username,password));

            System.out.println("name: " + name);
            System.out.println("lastname: " + lastName);
            System.out.println("username: " + username);
            System.out.printf("password " + password);
            System.out.printf("product " + product);
            System.out.printf("price " + price);

            HttpSession session = req.getSession();
            session.setAttribute("compraList",this.compraList);
            resp.sendRedirect("index.jsp");

        }else {
            System.out.println("Llenar Todos los Campos");
            resp.sendRedirect("index.jsp");
        }

    }

    public void initializeUsersList(){
        try{
            this.compraList = Persistence.loadCompras();
        }catch (IOException err){
            System.out.println(err.getMessage());
        }
    }

    public void saveCompra(Compra compra){

        this.compraList.add(compra);

        try{
            Persistence.saveCompras((ArrayList<Compra>) compraList);
            System.out.println("Compra de el usuario " + compra.getCliente().getUsername()+ " guardado con exito");
        }catch (IOException err){
            System.out.println(err.getMessage());
        }
    }
}
