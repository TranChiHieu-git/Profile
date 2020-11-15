package com.example.demo.WeatherProject.Service.ServiceImplement;

import com.example.demo.WeatherProject.Modal.WeatherData;
import com.example.demo.WeatherProject.Repository.WeatherDataRepository;
import com.example.demo.WeatherProject.Service.WeatherDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeatherDataServiceImpl implements WeatherDataService {
    @Autowired
    WeatherDataRepository weatherDataRepository;

    @Override
    public void save(WeatherData weatherData) {
        weatherDataRepository.save(weatherData);
    }

    @Override
    public void deleteById(int id) {
        weatherDataRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        weatherDataRepository.deleteAll();
    }

    @Override
    public void deleteAllValueOfLocal(int id) {
        weatherDataRepository.deleteAllByLocal_Code(id);
    }

    @Override
    public WeatherData getWeatherDataById(int id) {
        return weatherDataRepository.findById(id).orElse(null);
    }

    @Override
    public List<WeatherData> getWeatherDataByCityCode(int id) {
        return weatherDataRepository.findAllByLocal_Code(id);
    }

    @Override
    public List<WeatherData> getAllWeatherData() {
        return weatherDataRepository.findAll();
    }
}
