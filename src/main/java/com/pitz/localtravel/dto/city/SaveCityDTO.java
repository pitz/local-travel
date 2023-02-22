package com.pitz.localtravel.dto.city;

import lombok.Getter;
import lombok.Setter;

public class SaveCityDTO {

    @Getter @Setter
    private String name;

    @Getter @Setter
    private String uf;

    @Getter @Setter
    private String country;

}
