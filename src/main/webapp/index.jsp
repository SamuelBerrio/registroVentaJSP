<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<h1 style="marker-mid: none"><%= "Registro de Usuario" %>
</h1>
<form action="/register-clientes" method="post">
    <table style="with: 80% ; padding-left: 200px">
        <tr>
            <td>First Name</td>
            <td><input type="text" name="firstName" /></td>
        </tr>
        <tr>
            <td>Last Name</td>
            <td><input type="text" name="lastName" /></td>
        </tr>
        <tr>
            <td>UserName</td>
            <td><input type="text" name="username" /></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="password" name="password" /></td>
        </tr>
        <tr>
            <td>Product</td>
            <td><input type="text" name="product" /></td>
        </tr>
        <tr>
            <td>Price</td>
            <td><input type="text" name="price" /></td>
        </tr>
    </table>
    <input type="submit" value="Register" />
</form>

<h1>Cliente list</h1>
<p> list users</p>
<form action="/register-clientes" method="get">
    <input type="submit" value="list" />
</form>
<br/>
<a href="hello-servlet">Hello Servlet</a>
</body>
</html>