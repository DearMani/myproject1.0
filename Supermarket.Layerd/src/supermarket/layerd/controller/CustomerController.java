/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermarket.layerd.controller;
import java.sql.SQLException;
import java.util.ArrayList;

import supermarket.layerd.dto.CustomerDto;
import supermarket.layerd.service.customer.CustomerService;
import supermarket.layerd.service.ServiceFactory;







/**
 *
 * @author Manidu
 */
//Convert request in to java objects
public class CustomerController {
    
    CustomerService customerService =(CustomerService)ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.CUSTOMER);
    public String addCustomer(CustomerDto customerdto) throws SQLException {
           
            return  (customerService.addCustomer(customerdto));
                   
     }
    
    public String updateCustomer(CustomerDto customerdto) throws  SQLException{
           return customerService.updateCustomer(customerdto);
    }
    
    public String deleteCustomer(String custId) throws SQLException{
         return customerService.deleteCustomer(custId);
    }
    
    public ArrayList<CustomerDto> getAllCustomers() throws SQLException{
                 return customerService.getAllCustomers();
    }
    
    public CustomerDto getCustomer(String custId) throws SQLException{
          return customerService.getCustomer(custId);
    }
    
    
    
    
    
}
