<%-- 
    
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="PresentationLayer.AllOrderViewHelper"%>
<%@page import="java.util.ArrayList"%>
<%@page import="FunctionLayer.Order"%>
<% ArrayList<Order> orders = (ArrayList<Order>) request.getSession().getAttribute("orders"); %>
<!DOCTYPE html>
<html>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
         <%= AllOrderViewHelper.AllOrdersView(orders) %>
         
    </body>
</html>
