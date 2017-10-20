/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Zack
 */
public class MakeOrder extends Command{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        // We get the user session, that have been passed on from the front controller via. the request
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        
        // We also get the formdata that was forwarded to MakeOrder from the FrontController servlet
        int height = Integer.parseInt(request.getParameter("height"));
        int width = Integer.parseInt(request.getParameter("width"));
        int length = Integer.parseInt(request.getParameter("length"));
        
        if (user != null) {
            LogicFacade.setOrder(user.getId(), height, width, length);
            
            return "ordersentview";
        }else {
            throw new LoginSampleException( "Error: Order could not be completed" );
        }
        
        
    }
    
}
