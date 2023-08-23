/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermarket.layerd.dao;
import java.sql.PreparedStatement;
import supermarket.layerd.dbconnection.DBConnection;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 *
 * @author Manidu
 */
public class CrudUtil {
    public static Connection connection =DBConnection.getInstance().getConnection();
    
    public static PreparedStatement getPreparedStatement(String sql , Object...args) throws SQLException{
         
      
        PreparedStatement preparedStatement =connection.prepareStatement(sql);
      if( args !=null){
              for(int i =0; i<args.length; i++ ){
              preparedStatement.setObject(i+1, args[i]);
                              
          }             
      }
       return preparedStatement;   
    
    
    }
    public static boolean executeUpdate(String sql , Object...args)  throws SQLException {
               return (getPreparedStatement(sql, args).executeUpdate() >0);
    }
    
    public static ResultSet getResultSet(String sql , Object...args) throws SQLException{
              ResultSet resultSet = getPreparedStatement(sql, args).executeQuery();
              return resultSet;
    }
    
 
}
