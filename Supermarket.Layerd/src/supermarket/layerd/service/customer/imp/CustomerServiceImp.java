/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermarket.layerd.service.customer.imp;

import java.util.ArrayList;
import    supermarket.layerd.service.customer.CustomerService;
import    supermarket.layerd.dto.CustomerDto;
import    supermarket.layerd.entity.CustomerEntity;
import supermarket.layerd.dao.customer.CustomerDao;
import supermarket.layerd.dao.DaoFactory;
import java.sql.SQLException;


/**
 *
 * @author Manidu
 */
public class CustomerServiceImp  implements CustomerService {
      CustomerDao dao =(CustomerDao)DaoFactory.getInstance().getDao(DaoFactory.DaoType.CUSTOMER);

    @Override
    public String addCustomer(CustomerDto customerdto) throws SQLException {
                     
        
                CustomerEntity customerEntity =new CustomerEntity(customerdto.getCustId(),
                        customerdto.getCustTitle(),
                        customerdto.getCustName(), 
                        customerdto.getDob(),
                        customerdto.getSalary(),
                        customerdto.getCustAddress(),
                        customerdto.getCity(),
                        customerdto.getProvince(),
                        customerdto.getZip()  );
                     return (dao.add(customerEntity)) ? "Success Added " : "Fail" ;
    }

    @Override
    public String updateCustomer(CustomerDto customerdto) throws SQLException {
                 CustomerEntity customerEntity =new CustomerEntity(customerdto.getCustId(),
                        customerdto.getCustTitle(),
                        customerdto.getCustName(), 
                        customerdto.getDob(),
                        customerdto.getSalary(),
                        customerdto.getCustAddress(),
                        customerdto.getCity(),
                        customerdto.getProvince(),
                        customerdto.getZip()  );
                     return (dao.update(customerEntity)) ? "Success  Updated" : "Fail" ;
    }

    @Override
    public String deleteCustomer(String Id) throws SQLException {
              return (dao.delete(Id)) ? "Success delete" : "fail" ;
    }

    @Override
    public CustomerDto getCustomer(String id) throws SQLException {
              
        CustomerEntity ent =dao.get(id);
           return new CustomerDto(ent.getCustId(),
                   ent.getCustTitle(),
                   ent.getCustName(),
                   ent.getDob(),
                   ent.getSalary(),
                   ent.getCustAddress(),
                   ent.getCity(),
                   ent.getProvince(),
                   ent.getZip()  );
        
                  
    }

    @Override
    public ArrayList<CustomerDto> getAllCustomers() throws SQLException {
             ArrayList<CustomerEntity> entityList = dao.getAll();
             ArrayList<CustomerDto> dtoList =new ArrayList<>();
             for(CustomerEntity ent : entityList){
                     CustomerDto dto =new CustomerDto(ent.getCustId(),
                        ent.getCustTitle(),
                        ent.getCustName(), 
                        ent.getDob(),
                        ent.getSalary(),
                        ent.getCustAddress(),
                        ent.getCity(),
                        ent.getProvince(),
                        ent.getZip()  );
                 dtoList.add(dto);
                     
             }
             return dtoList;
             
             
             
    }
    
    
}

