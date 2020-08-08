package com.example.demo.service;

import com.example.demo.entity.Address;
import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer save(Customer customer){
        return this.customerRepository.save(customer);
    }

    public Iterable<Customer> getAll(){
        return this.customerRepository.findAll();
    }
}
