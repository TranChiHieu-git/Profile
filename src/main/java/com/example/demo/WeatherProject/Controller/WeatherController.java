package com.example.demo.WeatherProject.Controller;

import com.example.demo.WeatherProject.Modal.Local;
import com.example.demo.WeatherProject.Modal.WeatherData;
import com.example.demo.WeatherProject.Service.ServiceImplement.LocalServiceImpl;
import com.example.demo.WeatherProject.Service.ServiceImplement.WeatherDataServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 120000)
@Api(tags = "Users Rest Controller")
public class WeatherController {
    @Autowired
    WeatherDataServiceImpl weatherDataServiceImpl;
    @Autowired
    LocalServiceImpl localServiceImpl;

    @GetMapping("/laydanhsachthanhpho")
    @ApiOperation(value = "Update User")
    public ResponseEntity<List<Local>> LocalData() {
        List<Local> listLocal = localServiceImpl.getAllLocal();
        return listLocal.isEmpty() ?
                new ResponseEntity<>(HttpStatus.OK) :
                new ResponseEntity<>(listLocal, HttpStatus.OK);
    }

    @GetMapping("/laydulieuthoitiettheothanhpho")
    @ApiOperation(value = "Update User")
    public ResponseEntity<List<WeatherData>> weatherData(@RequestParam("citycode") int code) {
        List<WeatherData> listDataWeather = weatherDataServiceImpl.getWeatherDataByCityCode(code);
        return listDataWeather.isEmpty() ?
                new ResponseEntity<>(HttpStatus.NO_CONTENT) :
                new ResponseEntity<>(listDataWeather, HttpStatus.OK);
    }
}
