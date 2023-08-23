/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package supermarket.layerd.dao;
import java.util.ArrayList;
import java.sql.SQLException;

/**
 *
 * @author Manidu
 * @param <T>
 * @param <ID>
 */

// T =Entity Type  , ID = dataType reserved
//add the parameter tag for <T> <ID>
public interface CrudDao<T,ID> extends SuperDao  {
        boolean add(T t) throws SQLException;
        boolean update(T t) throws SQLException;
        boolean delete(ID id) throws SQLException;
        T get(ID id) throws SQLException;
        ArrayList<T> getAll() throws SQLException;
                
}
