package org.example.kbspring.controller.weather;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.kbspring.dto.forecast.ForecastDto;
import org.example.kbspring.dto.weather.WeatherDto;
import org.example.kbspring.service.weather.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "http://localhost:5173")
@PropertySource("classpath:/application.properties")
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/{city}")
    public ResponseEntity<WeatherDto> weather(@PathVariable("city") String city){
        return ResponseEntity.ok(weatherService.getWeather(city));
    }

    @GetMapping("/forecast/{city}")
    public ResponseEntity<ForecastDto> forecast(@PathVariable("city") String city){
        return ResponseEntity.ok(weatherService.getForecast(city));
    }
}
