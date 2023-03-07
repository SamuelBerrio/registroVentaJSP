<%@ page import="com.example.chatjsp.model.Compra" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Samuel
  Date: 5/03/2023
  Time: 9:35 a. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Compras</title>

</head>
<body>
<h1>List employees</h1>
<%
    List<Compra> employeeList = (List)request.getSession().getAttribute("compraList");
    int cont=1;
    for (Compra compra : employeeList){

%>
<p><b>Compra <%=cont%></b></p>
<p>Nombre <%=compra.getCliente().getName()%></p>
<p>Usuario <%=compra.getCliente().getUsername()%></p>
<p>Product <%=compra.getProduct()%></p>
<p>Price <%=String.valueOf(compra.getPrice())%></p>
<p>------------------------</p>
<%cont=cont+1;%>

<%}%>
</body>
</html>
