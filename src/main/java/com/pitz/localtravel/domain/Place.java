package com.pitz.localtravel.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity @Table @ToString
public class Place extends BaseEntityAudit {

    public static int NAME_MIN_LENGTH = 3;

    @Getter @Setter
    private String name;

    @Getter @Setter
    private City city;

    public Place() {}

    public Place(String name, City city) {
        this.name = name;
        this.city = city;
    }
}
