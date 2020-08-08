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
        Customer customer = new Customer(null,"Foo", 23,null);

        Customer savedCustomer = this.customerRepository.save(customer);

        assertThat(savedCustomer).isNotNull();
        assertThat(savedCustomer).isNotSameAs(customer);
        assertThat(savedCustomer.getAddress()).isNull();

        // Everytime ask Repository to find the element, it executes the query and return new object
        Optional<Customer> customer1 = this.customerRepository.findById(savedCustomer.getId());
        Optional<Customer> customer2 = this.customerRepository.findById(savedCustomer.getId());

        assertThat(customer1.get()).isNotSameAs(customer2.get());
    }

    @Test
    void aggregationTest() {
        Address address = new Address(null, "Bangalore");
        Customer customer = new Customer(null,"Bar", 23, address);

        Customer savedCustomer = this.customerRepository.save(customer);

        assertThat(savedCustomer.getId()).isNotNull();
        assertThat(savedCustomer.getAddress().getId()).isNotNull();
    }
}