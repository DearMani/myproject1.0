/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package supermarket.layerd.service.item;

import supermarket.layerd.service.SuperService;
import supermarket.layerd.dto.ItemDto;
import java.util.ArrayList;
import java.sql.SQLException;

/**
 *
 * @author Manidu
 */
public interface ItemService extends SuperService {
           String addItem(ItemDto itemdto) throws SQLException;
           String updateItem(ItemDto itemdto) throws SQLException;
           String deleteItem(String id) throws SQLException;
           ItemDto getItem(String id) throws SQLException;
           ArrayList<ItemDto> getAllItems() throws SQLException;
}
