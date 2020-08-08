package com.example.demo.entity;

import org.springframework.data.annotation.Id;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Customer {
    @Id
    private Long id;
    private String name;
    private int age;

    private Map<String, Address> address = new HashMap();

    public Customer() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Map<String, Address> getAddress() {
        return address;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return age == customer.age &&
                Objects.equals(id, customer.id) &&
                Objects.equals(name, customer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age);
    }


}
