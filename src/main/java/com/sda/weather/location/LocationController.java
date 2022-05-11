package com.sda.weather.location;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class LocationController {
    private final LocationService locationService;
    private final ObjectMapper objectMapper;

    // POST: /entry (endpoint API)
    public String createLocation(String data) {
        try {
            LocationDTO requestBody = objectMapper.readValue(data, LocationDTO.class);
            Location savedLocation = locationService.createLocation(
                    requestBody.getCity(),
                    requestBody.getLatitude(),
                    requestBody.getLongitude(),
                    requestBody.getRegion(),
                    requestBody.getCountry());
            LocationDTO responseBody = mapToLocationDTO(savedLocation);
            return objectMapper.writeValueAsString(responseBody);
        } catch (Exception e) {
            return String.format("{\"message\":\"%s\"}", e.getMessage());
        }
    }

    // mapper
    private LocationDTO mapToLocationDTO(Location savedLocation) {
        LocationDTO responseBody = new LocationDTO();
        responseBody.setId(savedLocation.getId());
        responseBody.setCity(savedLocation.getCity());
        responseBody.setLatitude(savedLocation.getLatitude());
        responseBody.setLongitude(savedLocation.getLongitude());
        responseBody.setRegion(savedLocation.getRegion());
        responseBody.setCountry(savedLocation.getCountry());
        return responseBody;
    }
}
