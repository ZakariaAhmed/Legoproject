<%-- 
    Document   : orderdetailsview
    Created on : Oct 20, 2017, 3:47:29 PM
    Author     : Zack
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="PresentationLayer.SingleOrderViewHelper"%>
<%@page import="java.util.ArrayList"%>
<%@page import="FunctionLayer.Order"%>
<% ArrayList<Order> orders = (ArrayList<Order>) request.getSession().getAttribute("orders"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Detail Order Page</title>
    </head>
    <body>
          <%= SingleOrderViewHelper.SingleDetailedOrder(orders) %>
    </body>
</html>
