package com.example.demo.WeatherProject.Repository;


import com.example.demo.WeatherProject.Modal.WeatherData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WeatherDataRepository extends JpaRepository<WeatherData, Integer> {
    void deleteAllByLocal_Code(int id);

    List<WeatherData> findAllByLocal_Code(int id);

    @Query(value = "ALTER SEQUENCE weather_data_id_seq RESTART WITH 1", nativeQuery = true)
    void resetSEQUENCE();
}
