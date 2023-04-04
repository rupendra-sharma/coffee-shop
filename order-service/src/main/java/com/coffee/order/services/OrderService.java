/**
 * @FileName: OrderService.java
 * @Author: Rupendra
 * @Package: com.coffee.order.services
 * @CreatedOn: 03-Apr-2023
 */
package com.coffee.order.services;

import com.coffee.order.exceptions.OrderNotFoundException;
import com.coffee.order.models.Order;
import com.coffee.order.repositories.OrderRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * @author Rupendra
 *
 */
@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private KafkaTemplate<String, Order> kafkaTemplate;

    private static final String INCOMING_ORDER_TOPIC = "incoming_order";
    private static final String ORDER_COMPLETE_TOPIC = "order_complete";

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
    
    public Order createOrder(Order order) {
        Order savedOrder = orderRepository.save(order);
        //TODO: fix the Kafka issue
        //kafkaTemplate.send(INCOMING_ORDER_TOPIC, savedOrder);
        return savedOrder;
    }

    public Order updateOrder(String id, Order order) {
        Optional<Order> optionalOrder = orderRepository.findById(id);
        if (optionalOrder.isPresent()) {
            order.setId(id);
            Order updatedOrder = orderRepository.save(order);
            //TODO: fix the Kafka issue
            //kafkaTemplate.send(ORDER_COMPLETE_TOPIC, updatedOrder);
            return updatedOrder;
        } else {
            throw new OrderNotFoundException("Order not found with id: " + id);
        }
    }

    public void deleteOrder(String id) {
        orderRepository.deleteById(id);
    }

    public Order getOrderById(String id) {
        return orderRepository.findById(id).orElse(null);
    }

}

