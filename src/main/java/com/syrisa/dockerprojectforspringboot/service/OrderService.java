package com.syrisa.dockerprojectforspringboot.service;

import com.syrisa.dockerprojectforspringboot.entity.impl.Order;

import java.util.List;

public interface OrderService extends EntityService<Order> {
    List<Order> getByCustomerID(Long id);

    List<Order> getAll();

    String delete(Long id);
}
