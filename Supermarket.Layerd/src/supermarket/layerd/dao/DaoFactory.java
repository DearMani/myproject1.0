/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermarket.layerd.dao;
import supermarket.layerd.dao.customer.imp.CustomerDaoImp;
import supermarket.layerd.dao.item.imp.ItemDaoImp;
import supermarket.layerd.dao.order.imp.OrderDaoImp;
import supermarket.layerd.dao.orderdetail.imp.OrderDetailDaoImp;



/**
 *
 * @author Manidu
 */
public class DaoFactory {
    
    private static DaoFactory daoFactory;

    private DaoFactory() {
    }
    
    public static DaoFactory getInstance(){
           if(daoFactory ==null){
                  daoFactory =new DaoFactory();
           }
           return daoFactory;
    }
    
    public  SuperDao  getDao(DaoType type){
        switch(type){
            
        case CUSTOMER :    return new CustomerDaoImp();
        case ITEM : return new ItemDaoImp();
        case ORDER : return new OrderDaoImp();
        case ORDERDETAIL : return new OrderDetailDaoImp();
        
        
        default : return null;
                                    
     }
        
   }
    
    public enum DaoType{
          CUSTOMER,ITEM,ORDER,ORDERDETAIL
    }
    
    
    
    
    
    
    
    
    
}
