package com.pitz.localtravel.domain;

import jakarta.persistence.*;

@Entity
@Table
public class City extends BaseEntityAudit {

    private String name;

    private String uf;

    // I'm ignoring the fact that should be another domain //
    private String country;

    public City() {}

    public City(String name, String uf, String country) {
        this.name = name;
        this.uf = uf;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "City{" +
                "id='" + this.getId() + '\'' +
                "name='" + name + '\'' +
                ", uf='" + uf + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
