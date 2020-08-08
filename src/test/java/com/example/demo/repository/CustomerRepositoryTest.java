package com.example.demo.repository;

import com.example.demo.entity.Address;
import com.example.demo.entity.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJdbcTest
class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    void testToShowNoLazyLoadingAndCaching() {
        Customer customer = new Customer("Foo", 23);

        Customer savedCustomer = this.customerRepository.save(customer);

        assertThat(savedCustomer).isNotNull();

        //Clone an entity by setting it's id attribute to null
        savedCustomer.setId(null);
        this.customerRepository.save(savedCustomer);

        assertThat(this.customerRepository.count()).isEqualTo(2);

        // Everytime ask Repository to find the element, it executes the query and return new object
        Optional<Customer> customer1 = this.customerRepository.findById(savedCustomer.getId());
        Optional<Customer> customer2 = this.customerRepository.findById(savedCustomer.getId());

        assertThat(customer1.get()).isNotSameAs(customer2.get());
    }

    @Test
    void aggregationTest() {
        Customer customer = new Customer("Bar", 23);

        Address currentAddress = new Address("Bangalore");
        customer.getAddress().put("currentAddress", currentAddress);

        Customer savedCustomer = this.customerRepository.save(customer);
        assertThat(savedCustomer).isNotNull();
        System.out.println(savedCustomer);

    }
}