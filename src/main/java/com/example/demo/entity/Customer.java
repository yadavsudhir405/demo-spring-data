package com.example.demo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Customer {
    @Id
    @Column("customer_id")
    private  Long id;
    private  String name;
    private  int age;

    @MappedCollection(idColumn = "customer_id")
    private Set<Address> addresses = new HashSet<>();

    public Customer() {
    }

    public Customer(Long id, String name, int age, Set<Address> addresses) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.addresses = addresses;
    }

    public Customer withId(Long id){
        return new Customer(id, this.name, this.age, this.addresses);
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public Set<Address> getAddress() {
        return this.addresses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return age == customer.age &&
                Objects.equals(id, customer.id) &&
                Objects.equals(name, customer.name) &&
                Objects.equals(addresses, customer.addresses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, addresses);
    }
}
