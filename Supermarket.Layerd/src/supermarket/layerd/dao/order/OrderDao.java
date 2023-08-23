/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package supermarket.layerd.dao.order;

import supermarket.layerd.dao.CrudDao;
import supermarket.layerd.entity.OrderEntity;
import java.sql.SQLException;

/**
 *
 * @author Manidu
 */
public interface OrderDao extends CrudDao<OrderEntity, String>{
         String getTotalPrice(String orderId) throws SQLException;
}
