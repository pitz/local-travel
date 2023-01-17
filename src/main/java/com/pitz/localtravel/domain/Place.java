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

    @Override
    public String toString() {
        return "Student{" +
                "id=" + this.getId() +
                ", name='" + this.name + '\'' +
                ", city='" + this.city + '\'' +
                '}';
    }
}
