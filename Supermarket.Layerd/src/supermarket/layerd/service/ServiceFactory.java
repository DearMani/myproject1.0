/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermarket.layerd.service;

import supermarket.layerd.service.customer.imp.CustomerServiceImp;
import supermarket.layerd.service.item.imp.itemServiceImp;
import supermarket.layerd.service.order.imp.OrderServiceImp;


/**
 *
 * @author Manidu
 */
public class ServiceFactory {
   
    private static ServiceFactory factory ;
    
    private ServiceFactory(){
          
    }
    
    public static ServiceFactory getInstance(){
           if(factory ==null){
                factory =new ServiceFactory();
           }
           return factory;
    }
    
   public  SuperService getService(ServiceType type){
             switch (type) {
           case CUSTOMER : return new CustomerServiceImp();
           case ITEM : return new itemServiceImp();
           case ORDER : return new OrderServiceImp();
               
           default:
              return  null;
       }
   }
   
    
    public enum ServiceType{
         CUSTOMER, ITEM,ORDER
    
    
    }
    
    
    
    
    
    
    
    
    
}
