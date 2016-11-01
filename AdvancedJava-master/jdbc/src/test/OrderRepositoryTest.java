package test;

import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.junit.Test;

import com.softtek.java.academy.jdbc.OrderRepository;
import com.softtek.java.academy.jdbc.OrderViewRepository;
import com.softtek.java.academy.jdbc.entity.OrderStatus;
import com.softtek.java.academy.jdbc.entity.SalesChannel;
import com.softtek.java.academy.jdbc.entity.SalesOrder;

public class OrderRepositoryTest {

    @Test
    public void shouldCreateOrder() {
        
        SalesOrder salesOrder = new SalesOrder();
        salesOrder.setId(UUID.randomUUID().toString());
        OrderStatus orderStatus = new OrderStatus();
        orderStatus.setCode("CRE");
        salesOrder.setOrderStatus(orderStatus);
        
        SalesChannel salesChannel = new SalesChannel();
        salesChannel.setCode("STO");
        salesOrder.setSalesChannel(salesChannel);
        salesOrder.setCreationDate(new Date());

        OrderRepository orderRepository = new OrderRepository();
        orderRepository.createOrder(salesOrder);
    }
    
    @Test
    public void shouldCancelOrder() {
        
        SalesOrder salesOrder = new SalesOrder();
        salesOrder.setId(UUID.randomUUID().toString());
        OrderStatus orderStatus = new OrderStatus();
        orderStatus.setCode("CRE");
        salesOrder.setOrderStatus(orderStatus);
        
        SalesChannel salesChannel = new SalesChannel();
        salesChannel.setCode("STO");
        salesOrder.setSalesChannel(salesChannel);
        salesOrder.setCreationDate(new Date());
        
        OrderRepository orderRepository = new OrderRepository();
        orderRepository.createOrder(salesOrder);
        
        orderStatus.setCode("CAN");
        salesOrder.setOrderStatus(orderStatus);
        int i = orderRepository.updateOrder(salesOrder);
        assertTrue(i > 0);
    }
    
    @Test
    public void shouldDeleteOrders() {
        OrderRepository orderRepository = new OrderRepository();
        for (int i = 0; i < 5; i++) {

            SalesOrder salesOrder1 = new SalesOrder();
            salesOrder1.setId(UUID.randomUUID().toString());
            OrderStatus orderStatus1 = new OrderStatus();
            orderStatus1.setCode("FUL");
            orderStatus1.setDescription("Created");
            salesOrder1.setOrderStatus(orderStatus1);

            SalesChannel salesChannel1 = new SalesChannel();
            salesChannel1.setCode("STO");
            salesChannel1.setDescription("Store");
            salesOrder1.setSalesChannel(salesChannel1);
            salesOrder1.setCreationDate(new Date());

            orderRepository.createOrder(salesOrder1);
        }
        
        orderRepository.deleteOrdersByStatus("FUL");
        
        OrderViewRepository orderViewRepository = new OrderViewRepository();
        List<SalesOrder> orders = orderViewRepository.selectOrdersByStatus("FUL");
        assertTrue(orders.size() == 0);

    }
}
