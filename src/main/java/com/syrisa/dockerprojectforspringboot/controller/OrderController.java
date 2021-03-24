package com.syrisa.dockerprojectforspringboot.controller;

import com.syrisa.dockerprojectforspringboot.entity.impl.Order;
import com.syrisa.dockerprojectforspringboot.service.CustomerService;
import com.syrisa.dockerprojectforspringboot.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {
    private final OrderService orderService;
    private final CustomerService customerService;

    public OrderController(OrderService orderService, CustomerService customerService) {
        this.orderService = orderService;
        this.customerService = customerService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Order create(@RequestBody Order order) {
        try {
            if (customerService.get(order.getUserId()) != null) {
                return orderService.create(order);
            } else {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer could not found");
            }
        } catch (Exception exception) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
        }
    }

    @GetMapping("/orders/{id}")
    public List<Order> getOrders(@PathVariable("id") Long id) {
        return new ArrayList<>(orderService.getByCustomerID(id));
    }

    @GetMapping("/orders")
    public List<Order> getAllOrders() {
        return new ArrayList<>(orderService.getAll());
    }

    @DeleteMapping("/del/{id}")
    public String delete(@PathVariable("id") Long id) {
        try {
            return orderService.delete(id);
        } catch (Exception exception) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
        }
    }
}
