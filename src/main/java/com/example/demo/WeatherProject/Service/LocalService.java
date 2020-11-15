package com.example.demo.WeatherProject.Service;

import com.example.demo.WeatherProject.Modal.Local;

import java.util.List;

public interface LocalService {
    void save(Local local);

    void deleteById(int id);

    Local getLocalById(int id);

    List<Local> getAllLocal();
}
