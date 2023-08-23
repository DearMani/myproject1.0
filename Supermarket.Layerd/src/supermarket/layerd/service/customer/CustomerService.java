/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package supermarket.layerd.service.customer;
import supermarket.layerd.service.SuperService;
import supermarket.layerd.dto.CustomerDto;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author Manidu
 */


public interface CustomerService  extends SuperService {
           String addCustomer(CustomerDto customerdto) throws SQLException;
           String updateCustomer(CustomerDto customerdto) throws SQLException;
           String deleteCustomer(String Id) throws SQLException;
           CustomerDto getCustomer(String id) throws SQLException;
           ArrayList<CustomerDto> getAllCustomers() throws SQLException;
       
}
