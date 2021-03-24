package com.syrisa.dockerprojectforspringboot.service;

import com.syrisa.dockerprojectforspringboot.entity.impl.Customer;

public interface CustomerService extends EntityService<Customer> {
    Customer get(Long id);

    String delete(Long id);
}
