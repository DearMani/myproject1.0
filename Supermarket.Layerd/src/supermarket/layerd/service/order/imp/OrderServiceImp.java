/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermarket.layerd.service.order.imp;

import java.sql.Connection;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import supermarket.layerd.dao.CrudUtil;
import supermarket.layerd.dao.DaoFactory;
import supermarket.layerd.dao.item.ItemDao;
import supermarket.layerd.dao.order.OrderDao;
import supermarket.layerd.dao.orderdetail.OrderDetailDao;
import supermarket.layerd.dto.OrderDetailDto;
import supermarket.layerd.dto.OrderDto;
import supermarket.layerd.entity.OrderDetailEntity;
import supermarket.layerd.entity.OrderEntity;
import supermarket.layerd.service.order.OrderService;
import supermarket.layerd.entity.ItemEntity;


/**
 *
 * @author Manidu
 */
public class OrderServiceImp   implements OrderService   {
     OrderDao orderDao =(OrderDao) DaoFactory.getInstance().getDao(DaoFactory.DaoType.ORDER);
     OrderDetailDao orderDetailDao =(OrderDetailDao) DaoFactory.getInstance().getDao(DaoFactory.DaoType.ORDERDETAIL);
     ItemDao itemDao =(ItemDao)DaoFactory.getInstance().getDao(DaoFactory.DaoType.ITEM);
     Connection connection;
    
    @Override
    public String placeOrder(OrderDto orderDto) throws SQLException{
        
         try {
             connection =CrudUtil.connection;
           connection.setAutoCommit(false);
           SimpleDateFormat sdf   =new SimpleDateFormat("yyyy-MM-dd");
           boolean stateForSaveOrder =orderDao.add(   new OrderEntity( orderDto.getOrderId(),
                  sdf.format(new Date()) ,
                   orderDto.getCustId() ) );
           
           if(stateForSaveOrder){
                 boolean isOrderDetailSave =true;
                 for( OrderDetailDto orderDetailDto :  orderDto.getOrderDetailDto()){
                      
//                     Object[] entityData ={  orderDto.getOrderId() , orderDetailDto.getItemCode(), orderDetailDto.getOrderQTY(), orderDetailDto.getDiscount()};
                     
                     boolean stateForSaveOrderDetail = orderDetailDao.add(new OrderDetailEntity(orderDto.getOrderId(),
                             orderDetailDto.getItemCode(), orderDetailDto.getOrderQTY(), orderDetailDto.getDiscount() )   );
                     if(!stateForSaveOrderDetail){
                         isOrderDetailSave =false;
                         break;
                     }
                     
                 }
                 
                 if(isOrderDetailSave){
                       
                     boolean isItemUpdate =true;
                     for( OrderDetailDto orderDetailDto :  orderDto.getOrderDetailDto()){
                          ItemEntity itemEntity =itemDao.get(orderDetailDto.getItemCode());
                          if(itemEntity !=null){
                           itemEntity.setQtyOnHand(itemEntity.getQtyOnHand() - orderDetailDto.getOrderQTY());
                          boolean stateForItemUpdate =itemDao.update(itemEntity);
                          
                         if(!stateForItemUpdate){
                             isItemUpdate =false;
                             break;
                         }
                              
                          }
                          else{
                              break;
                          }
                      
                         
                         
                     }
                     if( isItemUpdate ){
                          connection.commit();
                         return " Order Place SuccessFuly";
                         
                     }  else{
                         connection.rollback();
                         return " Error in Item Update";
                         
                     }
                     
                        
                 } else{
                      connection.rollback();
                      return " Error In OrderDetail Save ";
                 }
                          

           }   else{
                connection.rollback();
                return " Error in Save AN Order ";
           }
                  
            
        } catch (Exception e) {
             connection.rollback();
             e.getStackTrace();
             return e.getMessage();
            
            
        } finally {
             connection.setAutoCommit(true);
        }
           
         
    }
    
 
    @Override
    public String getTotalPrice(String orderId) throws SQLException {
                return  orderDao.getTotalPrice(orderId);
    }
    
    
    
       
    
    
    
}
