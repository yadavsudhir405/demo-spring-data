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
        Address homeAddress = new Address("Bangalore");
        Address homeAddress2 = new Address("Bangalore1");
        Address officeAddress = new Address("New Delhi");
        customer.getAddress().put("home", homeAddress);
        customer.getAddress().put("home", homeAddress2);
        customer.getAddress().put("office", officeAddress);
        return this.customerRepository.save(customer);
    }

    public Iterable<Customer> getAll(){
        return this.customerRepository.findAll();
    }
}
