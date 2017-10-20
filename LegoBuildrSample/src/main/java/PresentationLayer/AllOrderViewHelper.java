/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.Order;
import java.util.ArrayList;

/**
 *
 * @author Zack
 */
public class AllOrderViewHelper {
    
    
    
    public static String AllOrdersView(ArrayList<Order> orders){
        StringBuilder sb = new StringBuilder();
        if (orders.isEmpty()) {
            sb.append("<h2> You have no orders </h2>");
            return sb.toString();
        }
        sb.append("<h2>Your Total Orders</h2>");
        sb.append("<table class=\"table table-striped user-table\">");
        sb.append("<thead>");
        sb.append("<tr>"
                    + "<th>ID</th>"
                    + "<th>Sent</th>"
                    + "<th>Ordered</th>"
                + "<th>width</th>"
                + "<th>length</th>"
                + "<th>height</th>"
                + "<th></th>"
                + "</tr>"
            + "</thead>"         
        ); 
            
        sb.append("<tbody>"); 
        int counter= 0;
        for(Order order : orders) {
            sb.append("<tr>"
                    + "<th scope=\"row\">").append(order.getId()).append("</th><td>");       
                    if(order.isSent()){
                        sb.append("Yes");
                    }else{
                        sb.append("No");
                    }
                    sb.append("</td>"
                            + "<td>").append(order.getCreated()).append("</td>");
            sb.append("<td>").append(order.getWidth()).append("</td>");

            sb.append("<td>").append(order.getLength()).append("</td>");
            sb.append("<td>").append(order.getHeight()).append("</td>");
            sb.append("<td><a href='?command=orderdetails&orderId="+order.getId()+"'>See details</a></td>");
                sb.append("</tr>"
            );
            counter++;
        }   
        sb.append("</tbody>"
            + "</table>"
        );          
        sb.append("<br>");
        sb.append("<h3>Total Orders: ").append(counter).append("</h3>");
        return sb.toString();
    }
    
    
    public static String AllOrdersWithCheck(ArrayList<Order> orders){
        StringBuilder sb = new StringBuilder();
        if (orders.isEmpty()) {
            sb.append("<h2> There is no orders </h2>");
            
            return sb.toString();
        }
        sb.append("<h2>Here is your list</h2>");
        sb.append("<table class=\"table table-striped user-table\">");
        sb.append("<thead>");
        sb.append("<tr>"
                    + "<th>ID</th>"
                    + "<th>Sent</th>"
                    + "<th>Ordered</th>"
                + "<th>width</th>"
                + "<th>length</th>"
                + "<th>height</th>"
                + "<th></th>"
                + "</tr>"
            + "</thead>"         
        ); 
            
        sb.append("<tbody>"); 
        int counter= 0;
        for(Order order : orders) {
            sb.append("<tr>"
                    + "<th scope=\"row\">").append(order.getId()).append("</th><td>");       
                    if(order.isSent()){
                        sb.append("Yes");
                        sb.append("<form name=\"login\" action=\"FrontController\" method=\"POST\">" +
                                "<input type=\"hidden\" name=\"command\" value=\"setsend\" />" +
                                "<button type='submit' name='markUnsend' value='" + order.getId() + "'>Mark as unsent</button>" +
                                "</form>");
                    }else{
                        sb.append("No");
                        sb.append("<form name=\"login\" action=\"FrontController\" method=\"POST\">" +
                                "<input type=\"hidden\" name=\"command\" value=\"setsend\" />" +
                                "<button type='submit' name='markSend' value='" + order.getId() + "'>Mark as sent</button>" +
                                "</form>");
                    }
                    sb.append("</td>"
                            + "<td>").append(order.getCreated()).append("</td>");

            sb.append("<td>").append(order.getWidth()).append("</td>");

            sb.append("<td>").append(order.getLength()).append("</td>");
            sb.append("<td>").append(order.getHeight()).append("</td>");
            sb.append("<td><a href='?command=orderdetail>See details</a></td>'");
                sb.append("</tr>"
            );
            counter++;
        }
        sb.append("</tbody>"
            + "</table>"
        );          
        sb.append("<br>");
        sb.append("<h3>Total Orders: ").append(counter).append("</h3>");
        return sb.toString();
    }
    
    
}
