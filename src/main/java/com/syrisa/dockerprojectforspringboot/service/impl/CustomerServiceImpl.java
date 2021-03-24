package com.syrisa.dockerprojectforspringboot.service.impl;

import com.syrisa.dockerprojectforspringboot.entity.impl.Customer;
import com.syrisa.dockerprojectforspringboot.service.CustomerService;
import com.syrisa.dockerprojectforspringboot.utility.generate.TC;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Service
public class CustomerServiceImpl implements CustomerService {
    Map<Long, Customer> customers = new HashMap<>();

    @Override
    public Customer create(Customer customer) {
        try {
            customer.setId(TC.generateTC.get());
            customers.put(customer.getId(), customer);
            return customer;
        } catch (Exception exception) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Custom could not created");
        }
    }

    @Override
    public Customer get(Long id) {
        if (customers.get(id) != null) {
            return customers.get(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer could not found");
        }
    }
    @Override
    public String delete(Long id) {
        if (customers.get(id) != null) {
            customers.remove(id);
            return id + " customer deleted.";
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer could not registered.");
        }
    }
}
