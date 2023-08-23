/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermarket.layerd.dao.orderdetail.imp;

import java.sql.SQLException;
import java.util.ArrayList;
import supermarket.layerd.dao.orderdetail.OrderDetailDao;
import supermarket.layerd.entity.OrderDetailEntity;
import supermarket.layerd.dao.CrudUtil;

/**
 *
 * @author Manidu
 */
public class OrderDetailDaoImp   implements OrderDetailDao  {

    @Override
    public boolean add(OrderDetailEntity t) throws SQLException {
            
        return CrudUtil.executeUpdate(" INSERT INTO orderdetail VALUES ( ? ,? ,? ,?) ",
                t.getOrderId(), t.getItemCode() , t.getOrderQTY() , t.getDiscount());
        
    }

    @Override
    public boolean update(OrderDetailEntity t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(String id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public OrderDetailEntity get(String id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<OrderDetailEntity> getAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
