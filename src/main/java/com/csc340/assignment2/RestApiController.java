package com.csc340.assignment2;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class RestApiController {

    /**
     * Get info about the weather from weatherStack.
     *
     * @param cityName
     * @return a weather object.
     */
    @GetMapping("/current")
    public Object getWeather(@RequestParam(value = "query", defaultValue = "New Delhi") String cityName) {
        try {
            String apiKey = "93bf36fa27b9a8e68884a7fc9b79429a";
            String url = "https://api.weatherstack.com/current?access_key=93bf36fa27b9a8e68884a7fc9b79429a&query=" + cityName;
            RestTemplate restTemplate = new RestTemplate();
            ObjectMapper mapper = new ObjectMapper();

            String jsonListResponse = restTemplate.getForObject(url, String.class);
            JsonNode root = mapper.readTree(jsonListResponse);

            //Extract relevant info from the response and use it for what you want, in this case build a Fruit object
            JsonNode locationNode = root.get("location");
            String name = locationNode.get("name").asText();
            String country = locationNode.get("country").asText();
            String lat = locationNode.get("lat").asText();
            String lon = locationNode.get("lon").asText();

            Weather weather = new Weather(name, country, lat, lon);

            return weather;
        } catch (JsonProcessingException ex) {
            Logger.getLogger(RestApiController.class.getName()).log(Level.SEVERE,
                    null, ex);
            return "error in /weather";
        }
    }
}
