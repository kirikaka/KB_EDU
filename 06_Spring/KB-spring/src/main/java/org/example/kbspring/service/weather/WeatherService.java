package org.example.kbspring.service.weather;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.kbspring.dto.forecast.ForecastDto;
import org.example.kbspring.dto.weather.WeatherDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
@Slf4j
public class WeatherService {
    private RestTemplate restTemplate;

    private String uri_head="https://api.openweathermap.org/data/2.5/weather?q="; //HEAD
    private String uri_tail="&units=metric&APPID=bee42d9bb094cf243d50abe8b132f85d&lang=kr"; //tail

    public WeatherDto getWeather(String city){
        restTemplate =new RestTemplate();
        String uri_weather=uri_head+city+uri_tail;
        WeatherDto weatherDto=restTemplate.getForObject(uri_weather,WeatherDto.class);

        return weatherDto;
    }

    private String uri_head_forecast="https://api.openweathermap.org/data/2.5/forecast?q=";
    private String uri_tail_forecast="&APPID=bee42d9bb094cf243d50abe8b132f85d";

    public ForecastDto getForecast(String city){
        restTemplate =new RestTemplate();
        String uri_forecast=uri_head_forecast+city+uri_tail_forecast;

        ForecastDto forecastDto=restTemplate.getForObject(uri_forecast,ForecastDto.class);

        log.debug(forecastDto.toString());
        return forecastDto;
    }
}
