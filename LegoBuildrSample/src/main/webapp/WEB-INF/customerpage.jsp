<%-- 
    Document   : customerpage
    Created on : Aug 22, 2017, 2:33:37 PM
    Author     : kasper
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer home page</title>
    </head>
    <body>
        <h1>Hello <%=request.getParameter( "email" )%> </h1>
        <div>
        <form name="login" action="FrontController" method="POST">
           <button type="submit" name="command" value="redirectToOrder">Create new order</button>
           <button type="submit" name="command" value="allOrders">See all your orders</button>
       </form>
        </div>
    </body>
</html>
