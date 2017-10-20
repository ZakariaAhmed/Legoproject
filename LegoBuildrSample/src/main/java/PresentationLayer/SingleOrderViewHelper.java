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
public class SingleOrderViewHelper {
    
    public static String isSent(boolean sent){
        if (sent) {
            return "Sent";
        }
        return "Not sent";
    }
    
    public static String SingleDetailedOrder(ArrayList<Order> order){
        
        StringBuilder sb = new StringBuilder();
        sb.append("  <table class=\"table\">\n" +
"    <thead>\n" +
"      <tr>\n" +
"        <th>Id</th>\n" +
"        <th>Order Sent</th>\n" +
"        <th>width</th>\n" +
"        <th>height</th>\n" +
"        <th>length</th>\n" +
"        <th>Order Made at</th>\n" +
"      </tr>\n" +
"    </thead>\n" +
"    <tbody>\n" +
"      <tr>\n" +
"        <td>"+order.get(0).getId()+"</td>\n" +
"        <td>"+isSent(order.get(0).isSent())+"</td>\n" +
"        <td>"+order.get(0).getWidth()+"</td>\n" +
"        <td>"+order.get(0).getHeight()+"</td>\n" +
"        <td>"+order.get(0).getLength()+"</td>\n" +
"        <td>"+order.get(0).getCreated()+"</td>\n" +
"      </tr>\n" +
"    </tbody>\n" +
"  </table>");
        return sb.toString();
    }
}
