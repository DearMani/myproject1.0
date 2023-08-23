/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermarket.layerd.dto;
import java.util.List;
import java.util.ArrayList;


/**
 *
 * @author Manidu
 */
public class OrderDto {
        private String  orderId;
        private String custId;
        private List <OrderDetailDto> orderDetailDto;

    public OrderDto() {
    }

    public OrderDto(String orderId, String custId, List<OrderDetailDto> orderDetailDto) {
        this.orderId = orderId;
        this.custId = custId;
        this.orderDetailDto = orderDetailDto;
    }

    /**
     * @return the orderId
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * @param orderId the orderId to set
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /**
     * @return the custId
     */
    public String getCustId() {
        return custId;
    }

    /**
     * @param custId the custId to set
     */
    public void setCustId(String custId) {
        this.custId = custId;
    }

    /**
     * @return the orderDetailDto
     */
    public List <OrderDetailDto> getOrderDetailDto() {
        return orderDetailDto;
    }

    /**
     * @param orderDetailDto the orderDetailDto to set
     */
    public void setOrderDetailDto(List <OrderDetailDto> orderDetailDto) {
        this.orderDetailDto = orderDetailDto;
    }
    
    
        
   
        
        
        
    
    
    
}
