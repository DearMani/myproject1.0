/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermarket.layerd.dao.order.imp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import supermarket.layerd.dao.CrudUtil;
import supermarket.layerd.dao.order.OrderDao;
import supermarket.layerd.entity.OrderEntity;

/**
 *
 * @author Manidu
 */
public class OrderDaoImp implements OrderDao {

    @Override
    public boolean add(OrderEntity t) throws SQLException {
           
          return CrudUtil.executeUpdate(" INSERT INTO orders VALUES ( ? ,? ,? ) ",
                  t.getOrderId(), t.getOrderDate(), t.getCustId());
        
    }

    @Override
    public boolean update(OrderEntity t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(String id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public OrderEntity get(String id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<OrderEntity> getAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
      public String getTotalPrice( String orderId ) throws SQLException{
            ResultSet     set=CrudUtil.getResultSet("  SELECT SUM(od.OrderQTY * it.UnitPrice - od.Discount) "+
                    "    FROM orderdetail od  " +
                    "   JOIN item  it ON od.ItemCode = it.ItemCode  "+
                       "  WHERE  od. OrderID =?  "  , 
                    orderId);
            Double totalSum =0.0;
            while(set.next()){
                    totalSum =set.getDouble(1);
            
            }
            return " sum of total is "+String.valueOf(totalSum);
         
      }
    
    
    
    
    
    
}
