package FunctionLayer;

import DBAccess.Connector;
import DBAccess.OrderMapper;
import DBAccess.UserMapper;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * The purpose of LogicFacade is to...
 * @author kasper
 */
public class LogicFacade {

    public static User login( String email, String password ) throws LoginSampleException {
        return UserMapper.login( email, password );
    } 

    public static User createUser( String email, String password ) throws LoginSampleException {
        User user = new User(email, password, "customer");
        UserMapper.createUser( user );
        return user;
    }
    
    public static Order setOrder(int userId, int height, int length, int width) throws LoginSampleException{
        
        java.util.Date orderDate = new java.util.Date();
        Date currentTime = new java.sql.Date(orderDate.getTime());
        boolean notSent = false;
        
        Order cOrder = new Order(userId, height, length, width, notSent, currentTime);
        
        OrderMapper.sendOrderToDb(cOrder);
        
        return cOrder;
        
    }
    
    public static void SetOrderToSent(int orderId) throws LoginSampleException{
        try {
            Connection con = Connector.connection();
            String SQL = "UPDATE orders SET sent=1 WHERE id = "+orderId;
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public static void SetOrderToNotSent(int orderId) throws LoginSampleException {
        try{
            Connection con = Connector.connection();
            String SQL = "UPDATE orders SET sent=0 WHERE id=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, orderId);
            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }
    
    
    public static ArrayList<Order> getAllOrdersById(int userid) throws LoginSampleException
{
    ArrayList<Order> orders = OrderMapper.getAllOrdersbyId(userid);
    return orders;
}


    public static ArrayList<Order> getAllorders() throws LoginSampleException
{
    ArrayList<Order> orders;
    orders = OrderMapper.getAllOrders();
    return orders;
}
        
    
        
}
