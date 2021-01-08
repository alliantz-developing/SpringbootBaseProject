package com.igm.controller;

import com.google.gson.JsonObject;
import com.igm.model.input.InputWeather;
import com.igm.model.output.JsonWeatherBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;


@RestController
public class WeatherController {
    // Default logger
    private final Logger logger = LoggerFactory.getLogger(WeatherController.class);

    @Value("${api.key}")
    private String apiKey;

    @Value("${api.url}")
    private String apiUrl;

    @Cacheable("weather")
    @GetMapping("/weather/{city}")
    public String getAJson(@PathVariable String city) {
        logger.debug("Entering /weather");

        WebClient webClient = WebClient.builder().baseUrl(apiUrl + "?q=" + city + "&appid=" + apiKey).build();
//        String responseSpec = webClient.post().exchange().block().bodyToMono(String.class).block();

        InputWeather iw = webClient.post().exchange().block().bodyToMono(InputWeather.class).block();

        return new JsonWeatherBuilder(iw).build().toString();
    }
}
