/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package supermarket.layerd.service.order;

import supermarket.layerd.service.SuperService;
import supermarket.layerd.dto.OrderDto;
import java.sql.SQLException;

/**
 *
 * @author Manidu
 */
public interface OrderService  extends SuperService  {
      String placeOrder( OrderDto orderDto ) throws SQLException; 
      String getTotalPrice(String orderId) throws SQLException;
    
}
