package com.sda.weather.location;

import lombok.Data;

@Data
public class LocationDTO {

    private Long id;
    private String city;
    private String country;
    private String region;
    private Float longitude;
    private Float latitude;

}
