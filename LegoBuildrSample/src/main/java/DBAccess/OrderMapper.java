/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Zack
 */
public class OrderMapper {
    
    public static void sendOrderToDb(Order nOrder) throws LoginSampleException{
        try {
            Connection conn = Connector.connection();
            String SQL = "INSERT INTO orders (userid, sent, width, length, height) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, nOrder.getUserId());
            ps.setBoolean(2, nOrder.isSent());
            ps.setInt(3, nOrder.getWidth());
            ps.setInt(4, nOrder.getLength());
            ps.setInt(5, nOrder.getHeight());
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt(1);
            nOrder.setId(id);
            
        } catch (Exception e) {
            throw new LoginSampleException(e.getMessage());
        }
        
    }
    
    
    public static ArrayList<Order> getAllOrders() throws LoginSampleException{
        ArrayList<Order> orderArr = new ArrayList<Order>();
        
        try {
            Connection conn = Connector.connection();
            String SQL = "SELECT * FROM orders ORDER BY created";
            PreparedStatement ps = conn.prepareStatement(SQL);
            ResultSet resultSet = ps.executeQuery();
            
            while (resultSet.next()) {
                int orderId = resultSet.getInt("id");
                int userId = resultSet.getInt("userid");
                boolean sent = resultSet.getBoolean("sent");
                Date created = resultSet.getDate("created");
                int height = resultSet.getInt("height");
                int length = resultSet.getInt("length");
                int width = resultSet.getInt("width");
                
                Order newOrder = new Order(userId, height, length, width,sent, created);
                newOrder.setId(orderId);
                
                orderArr.add(newOrder);
                
            }
            
            
        } catch (Exception e) {
            throw new LoginSampleException(e.getLocalizedMessage());
        }
        return orderArr;
    }
    
    
    public static ArrayList<Order> getAllOrdersbyId(int userId) throws LoginSampleException{
         ArrayList<Order> orderArr = new ArrayList<Order>();
        
        try {
            Connection conn = Connector.connection();
            String SQL = "SELECT * FROM orders WHERE userid=?";
            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setInt(1, userId);
            ResultSet resultSet = ps.executeQuery();
            
            while (resultSet.next()) {
                int orderId = resultSet.getInt("id");
                boolean sent = resultSet.getBoolean("sent");
                Date created = resultSet.getDate("created");
                int height = resultSet.getInt("height");
                int length = resultSet.getInt("length");
                int width = resultSet.getInt("width");
                Order newOrder = new Order(userId, height, length, width,sent, created);
                newOrder.setId(orderId);
                
                orderArr.add(newOrder);
                
            }
            
            
        } catch (Exception e) {
            throw new LoginSampleException(e.getLocalizedMessage());
        }
        return orderArr;
    }


    public static ArrayList<Order> getOrderByOrderId(int orderId) throws LoginSampleException {
        ArrayList<Order> OrderList = new ArrayList<Order>();
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM orders WHERE id=?";

            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, orderId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int userId = rs.getInt("userId");
                boolean sent = rs.getBoolean("sent");
                Date created = rs.getDate("created");
                int width = rs.getInt("width");
                int height = rs.getInt("height");
                int length = rs.getInt("length");

                Order nOrder = new Order(userId, height, length, width, sent, created);
                nOrder.setId(orderId);

                OrderList.add(nOrder);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
        return OrderList;
    }


    
    
    
     public static void SetOrderAsSend(int orderId) throws LoginSampleException {
        try{
            Connection con = Connector.connection();
            String SQL = "UPDATE orders SET sent=1 WHERE id=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, orderId);
            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }


    public static void SetOrderAsUnSend(int orderId) throws LoginSampleException {
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
    
}
