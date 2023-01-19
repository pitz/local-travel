package com.pitz.localtravel.domain;

import jakarta.persistence.*;

@Entity
@Table
public class Place extends BaseEntityAudit {

    private String name;

    private City city;

    public Place() {}

    public Place(String name, City city) {
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return this.name;
    }

    public City getCity() {
        return this.city;
    }

    @Override
    public String toString() {
        return "Place{" +
                "id=" + this.getId() +
                ", name='" + this.name + '\'' +
                ", city='" + this.city + '\'' +
                '}';
    }
}
