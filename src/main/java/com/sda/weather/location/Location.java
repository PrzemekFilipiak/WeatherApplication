package com.sda.weather.location;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "location")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, name = "city")
    private String city;
    @Column(nullable = false, name = "latitude")
    private String latitude;
    @Column(nullable = false, name = "longitude")
    private String longitude;
    @Column(name = "region")
    private String region;
    @Column(nullable = false, name = "country")
    private String country;
}
