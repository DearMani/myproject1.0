/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermarket.layerd.controller;

import java.sql.SQLException;
import supermarket.layerd.service.item.ItemService;
import supermarket.layerd.service.ServiceFactory;
import supermarket.layerd.dto.ItemDto;
import java.util.ArrayList;


/**
 *
 * @author Manidu
 */
public class ItemController {
         ItemService itemService =(ItemService)ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.ITEM);
         
         public String addItem(ItemDto itemdto) throws SQLException{
        
              return itemService.addItem(itemdto);
         }
         
         public String updateItem(ItemDto itemdto) throws SQLException{
               return itemService.updateItem(itemdto);
         }
         
         public String deleteItem(String itemId) throws SQLException{
                return itemService.deleteItem(itemId);
         }
         
         public ItemDto getItem(String itemId) throws SQLException{
             return itemService.getItem(itemId);
         }
         
         public ArrayList<ItemDto> getAllItems() throws SQLException{
              return itemService.getAllItems();
         }
         
         
         
         
}
