/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermarket.layerd.dao.customer.imp;

import java.util.ArrayList;
import supermarket.layerd.entity.CustomerEntity;
import supermarket.layerd.dao.CrudUtil;
import java.sql.SQLException;
import java.sql.ResultSet;
import supermarket.layerd.dao.customer.CustomerDao;

/**
 *
 * @author Manidu
 */
public class CustomerDaoImp  implements CustomerDao{

    @Override
    public boolean add(CustomerEntity t) throws SQLException {
         return CrudUtil.executeUpdate("INSERT INTO customer VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                    t.getCustId(), t.getCustTitle(), t.getCustName(), t.getDob(), t.getSalary(), t.getCustAddress(), t.getCity(),
                           t.getProvince(), t.getZip()  );
    }

    @Override
    public boolean update(CustomerEntity t)  throws SQLException{
         return CrudUtil.executeUpdate("UPDATE customer  SET CustTitle = ? , CustName = ? , DOB = ? ,  salary = ? , CustAddress = ?, City = ?, Province = ? , PostalCode = ?   WHERE   CustID = ? ",
                  t.getCustTitle(), t.getCustName(), t.getDob(), t.getSalary(), t.getCustAddress(), t.getCity(),
                           t.getProvince(), t.getZip() ,t.getCustId()  );
                 
    }

    @Override
    public boolean delete(String id)  throws SQLException{
     return CrudUtil.executeUpdate( " DELETE FROM customer WHERE CustID =?",
             id);
    }

    @Override
    public CustomerEntity get(String id) throws SQLException {
           ResultSet  set = CrudUtil.getResultSet( "SELECT * FROM customer WHERE CustID = ? ",
                                                     id);
           
           while(set.next()){
                     return new CustomerEntity(set.getString(1),
                          set.getString(2),
                          set.getString(3),
                          set.getString(4),
                          set.getDouble(5),
                          set.getString(6),
                          set.getString(7),
                          set.getString(8),
                          set.getString(9)  );
           }
            return null;
       
    }

    @Override
    public ArrayList<CustomerEntity> getAll()  throws SQLException {
         ResultSet set =CrudUtil.getResultSet("SELECT * FROM customer", (Object[]) null);
         
         ArrayList<CustomerEntity> entityList =new ArrayList<>();
         
         while(set.next()){
                CustomerEntity entity     =new CustomerEntity(set.getString(1),
                          set.getString(2),
                          set.getString(3),
                          set.getString(4),
                          set.getDouble(5),
                          set.getString(6),
                          set.getString(7),
                          set.getString(8),
                          set.getString(9)  );
                
                entityList.add(entity);
             
         }
         
          return entityList;     
    }
    
    
    
    
}
