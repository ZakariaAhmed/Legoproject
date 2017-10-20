<%-- 
    Document   : ordersentview
    Created on : Oct 20, 2017, 9:16:34 AM
    Author     : Zack
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Thank you for ordering from us!</h1>
        <h2>Your Lego is on its way !!</h2>
        <form name="login" action="FrontController" method="POST">
           <button type="submit" name="command" value="allOrders">Click here to see all your orders</button>
       </form>
    </body>
</html>
