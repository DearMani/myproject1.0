/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermarket.layerd.dao.item.imp;
import java.sql.SQLException;
import java.util.ArrayList;
import supermarket.layerd.dao.item.ItemDao;


import supermarket.layerd.entity.ItemEntity;
import supermarket.layerd.dao.CrudUtil;
import java.sql.ResultSet;

/**
 *
 * @author Manidu
 */
public class ItemDaoImp implements ItemDao{

    @Override
    public boolean add(ItemEntity t) throws SQLException {
          return CrudUtil.executeUpdate("  INSERT INTO item VALUES ( ? ,? ,? ,? ,?)     ", 
                  t.getItemCode(), t.getDescription(), t.getPackSize(), t.getUnitPrice(),t.getQtyOnHand() );
    }

    @Override
    public boolean update(ItemEntity t) throws SQLException {
             return CrudUtil.executeUpdate("  UPDATE  item SET  Description=? ,  PackSize =?,   UnitPrice=?,  QtyOnHand=? WHERE ItemCode=?  ", 
                   t.getDescription(), t.getPackSize(), t.getUnitPrice(),t.getQtyOnHand(),t.getItemCode() );
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return CrudUtil.executeUpdate("  DELETE FROM item WHERE ItemCode =?  ",  id);
    }

    @Override
    public ItemEntity get(String id) throws SQLException {
           ResultSet set =CrudUtil.getResultSet(" SELECT * FROM item WHERE ItemCode =?  ",  id);
           while(set.next()){
                  ItemEntity ent =new ItemEntity(
                          set.getString(1), 
                          set.getString(2), 
                          set.getString(3),
                          set.getDouble(4),
                          set.getInt(5)       );
                  return ent;
           }
           return null;
             
    }

    @Override
    public ArrayList<ItemEntity> getAll() throws SQLException {
       
        ResultSet set =CrudUtil.getResultSet("  SELECT * FROM item ", (Object[]) null);
        ArrayList<ItemEntity> entList =new ArrayList<>();
        while(set.next()){
                  ItemEntity ent =new ItemEntity(
                          set.getString(1), 
                          set.getString(2), 
                          set.getString(3),
                          set.getDouble(4),
                          set.getInt(5)       );
            
            entList.add(ent);
        }
         return entList;
    }
    
}