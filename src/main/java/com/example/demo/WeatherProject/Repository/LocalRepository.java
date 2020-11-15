package com.example.demo.WeatherProject.Repository;

import com.example.demo.WeatherProject.Modal.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalRepository extends JpaRepository<Local, Integer> {
}
