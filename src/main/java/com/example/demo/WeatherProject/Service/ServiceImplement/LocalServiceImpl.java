package com.example.demo.WeatherProject.Service.ServiceImplement;

import com.example.demo.WeatherProject.Modal.Local;
import com.example.demo.WeatherProject.Repository.LocalRepository;
import com.example.demo.WeatherProject.Service.LocalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocalServiceImpl implements LocalService {
    @Autowired
    public LocalRepository localRepository;

    @Override
    public void save(Local local) {
        localRepository.save(local);
    }

    @Override
    public void deleteById(int id) {
        localRepository.deleteById(id);
    }

    @Override
    public Local getLocalById(int id) {
        return localRepository.findById(id).orElse(null);
    }

    @Override
    public List<Local> getAllLocal() {
        return localRepository.findAll();
    }
}
