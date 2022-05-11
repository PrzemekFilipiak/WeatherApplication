package com.sda.weather.location;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sda.weather.exeption.BadRequestException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class LocationService extends RuntimeException{

    private final LocationRepository locationRepository;

    // POST: /entry (endpoint API)
    public Location createLocation(String city, Float latitude, Float longitude, String region, String country) {
        if (city == null || city.isBlank()) {
            throw new BadRequestException("City value cannot be null");
        }
        if (country == null || country.isBlank()) {
            throw new BadRequestException("Country value cannot be null");
        }
        if (longitude == null) {
            throw new BadRequestException("Longitude value cannot be null");
        }
        if (latitude == null) {
            throw new BadRequestException("Latitude value cannot be null");
        }
        if (longitude > 90 || longitude < -90) {
            throw new BadRequestException("Szerokość geograficzna musi mieścić się w przedziale <-90; 90>");
        }
        if (latitude > 180 || latitude < -180) {
            throw new BadRequestException("Szerokość geograficzna musi mieścić się w przedziale <-180; 180>");
        }
        if (region != null && region.isBlank()) {
            region = null;
        }

        Location location = new Location(city,latitude, longitude, region, country);
        return locationRepository.save(location);
    }
}
