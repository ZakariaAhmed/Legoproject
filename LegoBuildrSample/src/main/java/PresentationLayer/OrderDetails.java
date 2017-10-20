/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import DBAccess.OrderMapper;
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import FunctionLayer.User;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Zack
 */
public class OrderDetails extends Command{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        int orderId = Integer.parseInt(request.getParameter("orderId"));
        ArrayList<Order> detailedOrder = OrderMapper.getOrderByOrderId(orderId);
        session.setAttribute("orders", detailedOrder);
        
        session.setAttribute("orderId", "test");
        return "orderdetailsview";
    }
    
}
