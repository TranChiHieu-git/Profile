package com.example.demo.WeatherProject.Service;

import com.example.demo.WeatherProject.Modal.Local;
import com.example.demo.WeatherProject.Modal.WeatherData;

import java.util.List;

public interface WeatherDataService {
    void save(WeatherData weatherData);

    void deleteById(int id);

    void deleteAll();

    void deleteAllValueOfLocal(int id);

    WeatherData getWeatherDataById(int id);

    List<WeatherData> getWeatherDataByCityCode(int id);

    List<WeatherData> getAllWeatherData();

    void resetSEQUENCE();
}
