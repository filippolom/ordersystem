package com.example.ordersystem.service;

import com.example.ordersystem.entity.Order;
import com.example.ordersystem.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Integer id) {
        return orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
    }

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order updateOrder(Integer id, Order order) {
        Order existingOrder = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
        existingOrder.setAmount(order.getAmount());
        return orderRepository.save(existingOrder);
    }

    public void deleteOrder(Integer id) {
        orderRepository.deleteById(id);
    }
}