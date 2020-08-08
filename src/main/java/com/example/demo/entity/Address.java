package com.example.demo.entity;

import org.springframework.data.annotation.Id;

import java.util.Objects;

public class Address {
    @Id
    private  Long id;
    private  String city;

    public Address() {
    }

    public Address(Long id, String city) {
        this.id = id;
        this.city = city;
    }

    public Address withId(Long id) {
        return new Address(id, this.city);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(id, address.id) &&
                Objects.equals(city, address.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, city);
    }

    public Long getId() {
        return id;
    }

    public String getCity() {
        return city;
    }
}
