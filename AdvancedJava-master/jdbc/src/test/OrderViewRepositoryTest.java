package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
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

public class OrderViewRepositoryTest {

    @Test
    public void shouldSelectOrder() {

        SalesOrder salesOrder = new SalesOrder();
        salesOrder.setId(UUID.randomUUID().toString());
        OrderStatus orderStatus = new OrderStatus();
        orderStatus.setCode("CRE");
        orderStatus.setDescription("Created");
        salesOrder.setOrderStatus(orderStatus);

        SalesChannel salesChannel = new SalesChannel();
        salesChannel.setCode("STO");
        salesChannel.setDescription("Store");
        salesOrder.setSalesChannel(salesChannel);
        salesOrder.setCreationDate(new Date());

        OrderRepository orderRepository = new OrderRepository();
        orderRepository.createOrder(salesOrder);

        OrderViewRepository orderViewRepository = new OrderViewRepository();

        SalesOrder stored =
            orderViewRepository.selectOrderByID(salesOrder.getId());

        assertNotNull(stored);
        assertEquals(stored, salesOrder);

    }

    @Test
    public void shouldSelectOrdersByChannel() {

        OrderRepository orderRepository = new OrderRepository();

        for (int i = 0; i < 5; i++) {

            SalesOrder salesOrder1 = new SalesOrder();
            salesOrder1.setId(UUID.randomUUID().toString());
            OrderStatus orderStatus1 = new OrderStatus();
            orderStatus1.setCode("CRE");
            orderStatus1.setDescription("Created");
            salesOrder1.setOrderStatus(orderStatus1);

            SalesChannel salesChannel1 = new SalesChannel();
            salesChannel1.setCode("STO");
            salesChannel1.setDescription("Store");
            salesOrder1.setSalesChannel(salesChannel1);
            salesOrder1.setCreationDate(new Date());

            orderRepository.createOrder(salesOrder1);
        }

        OrderViewRepository orderViewRepository = new OrderViewRepository();
        List<SalesOrder> sales =
            orderViewRepository.selectOrdersByChannel("STO");

        assertNotNull(sales);
        assertTrue(sales.size() > 0);

    }

    @Test
    public void shouldSelectOrdersByStatus() {

        OrderRepository orderRepository = new OrderRepository();

        for (int i = 0; i < 5; i++) {

            SalesOrder salesOrder1 = new SalesOrder();
            salesOrder1.setId(UUID.randomUUID().toString());
            OrderStatus orderStatus1 = new OrderStatus();
            orderStatus1.setCode("APP");
            orderStatus1.setDescription("Approved");
            salesOrder1.setOrderStatus(orderStatus1);

            SalesChannel salesChannel1 = new SalesChannel();
            salesChannel1.setCode("STO");
            salesChannel1.setDescription("Store");
            salesOrder1.setSalesChannel(salesChannel1);
            salesOrder1.setCreationDate(new Date());

            orderRepository.createOrder(salesOrder1);
        }

        OrderViewRepository orderViewRepository = new OrderViewRepository();
        List<SalesOrder> sales =
            orderViewRepository.selectOrdersByStatus("APP");

        assertNotNull(sales);
        assertTrue(sales.size() > 0);

    }

}
