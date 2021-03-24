package com.syrisa.dockerprojectforspringboot.service.impl;

import com.syrisa.dockerprojectforspringboot.entity.impl.Order;
import com.syrisa.dockerprojectforspringboot.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;


@Service
public class OrderServiceImpl implements OrderService {
    private static final List<Order> orders = new ArrayList<>();


    @Override
    public Order create(Order order) {
        try {
            order.setId(UUID.randomUUID());
            orders.add(order);
            return order;
        } catch (Exception exception) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Order was created.");
        }
    }

    @Override
    public List<Order> getByCustomerID(Long id) {
        List<Order> returnOrders = new ArrayList<>();
        for (Order order : orders) {
            if (order.getUserId() == id) {
                returnOrders.add(order);
            }
        }
        return returnOrders;
    }

    @Override
    public List<Order> getAll() {
        return orders;
    }

    @Override
    public String delete(Long id) {
        if (!orders.isEmpty()) {
            orders.removeIf(order -> order.getUserId() == id);
            return id + " orders were deleted";
        } else {
            return id + " orders were not deleted";
        }
    }
}
