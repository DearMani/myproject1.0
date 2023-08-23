/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermarket.layerd.service.item.imp;

import java.sql.SQLException;
import java.util.ArrayList;
import supermarket.layerd.dao.DaoFactory;
import supermarket.layerd.dao.item.ItemDao;
import supermarket.layerd.dto.ItemDto;
import supermarket.layerd.entity.ItemEntity;
import supermarket.layerd.service.item.ItemService;


/**
 *
 * @author Manidu
 */
public class itemServiceImp implements ItemService {
     ItemDao itemdao  =(ItemDao)DaoFactory.getInstance().getDao(DaoFactory.DaoType.ITEM);

  
    @Override
    public String addItem(ItemDto itemdto) throws SQLException {
         ItemEntity itemEntity =new ItemEntity(
                    itemdto.getItemCode(),
                    itemdto.getDescription(),
                    itemdto.getPackSize(),
                    itemdto.getUnitPrice(),
                    itemdto.getQtyOnHand() );
           
                    return  (itemdao.add(itemEntity))? "Successfull Added" : "Fail";
                         
        
    }

    @Override
    public String updateItem(ItemDto itemdto) throws SQLException {
         ItemEntity itemEntity =new ItemEntity(
                    itemdto.getItemCode(),
                    itemdto.getDescription(),
                    itemdto.getPackSize(),
                    itemdto.getUnitPrice(),
                    itemdto.getQtyOnHand() );
         
         return  (itemdao. update(itemEntity))? "Successfull Update" : "Fail";
        
       
    }

    @Override
    public ItemDto getItem(String id) throws SQLException {
             ItemEntity ent =itemdao.get(id);
             ItemDto dto =new ItemDto(
                     ent.getItemCode(),
                     ent.getDescription(),
                     ent.getPackSize(),
                     ent.getUnitPrice(),
                     ent.getQtyOnHand());
             return dto;
              
    }

    @Override
    public ArrayList<ItemDto> getAllItems() throws SQLException {
        ArrayList<ItemEntity> entList =itemdao.getAll();
        ArrayList<ItemDto> dtoList =new ArrayList<>();
        for(ItemEntity ent : entList){
            ItemDto dto =new ItemDto(
                    ent.getItemCode(),
                    ent.getDescription(),
                    ent.getPackSize(),
                    ent.getUnitPrice(),
                    ent.getQtyOnHand() );
            dtoList.add(dto);
            
        }
        return dtoList;
        
        
    }

    @Override
    public String deleteItem(String id) throws SQLException {
           return  (itemdao.delete(id)) ? "Delete Success" : "Fail";
    }
    
}
