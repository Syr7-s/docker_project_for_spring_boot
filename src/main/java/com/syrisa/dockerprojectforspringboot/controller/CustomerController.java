package com.syrisa.dockerprojectforspringboot.controller;

import com.syrisa.dockerprojectforspringboot.entity.impl.Customer;
import com.syrisa.dockerprojectforspringboot.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Customer create(@RequestBody Customer customer) {
        try {
            return customerService.create(customer);
        } catch (Exception exception) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
        }
    }

    @GetMapping("/{id}")
    public Customer get(@PathVariable("id") Long id) {
        try {
            return customerService.get(id);
        } catch (Exception exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, exception.getMessage());
        }
    }

    @DeleteMapping("/del/{id}")
    public String delete(@PathVariable("id") Long id) {
        try {
            return customerService.delete(id);
        } catch (Exception exception) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
        }
    }
}
