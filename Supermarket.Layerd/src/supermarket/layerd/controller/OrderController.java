/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermarket.layerd.controller;

import java.sql.SQLException;
import supermarket.layerd.service.order.OrderService;
import supermarket.layerd.service.ServiceFactory;
import supermarket.layerd.dto.OrderDto;


/**
 *
 * @author Manidu
 */
public class OrderController {
    private OrderService orderService =(OrderService)ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.ORDER);
    
    public String placeOrder(OrderDto orderDto) throws SQLException{
             return  orderService.placeOrder(orderDto);
    }
    
    public String getTotalPrice(String orderId) throws SQLException{
        return orderService.getTotalPrice(orderId);
    }
        
    
    
    
}
