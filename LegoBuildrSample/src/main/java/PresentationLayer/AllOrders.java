/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

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
// RETURNS ALL ORDERS VIEW PAGE FOR CUSTOMER
public class AllOrders extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        ArrayList<Order> allCustomerOrders = LogicFacade.getAllOrdersById(user.getId());
        session.setAttribute("orders", allCustomerOrders);
        return "customerordersview";
    }
    
}
