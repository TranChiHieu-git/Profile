package com.example.demo.WeatherProject.Controller;

import com.example.demo.WeatherProject.Modal.Local;
import com.example.demo.WeatherProject.Modal.WeatherData;
import com.example.demo.WeatherProject.Service.ServiceImplement.LocalServiceImpl;
import com.example.demo.WeatherProject.Service.ServiceImplement.WeatherDataServiceImpl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;

import javax.transaction.Transactional;
import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;

@JsonComponent
public class GetValueWeather {
    @Autowired
    private LocalServiceImpl localServiceImpl;
    @Autowired
    WeatherDataServiceImpl weatherDataServiceImpl;

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        try (InputStream is = new URL(url).openStream()) {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
            String jsonText = readAll(rd);
            return new JSONObject(jsonText);
        }
    }

    @Async
    @Scheduled(fixedDelay = 10800000)
    @Transactional
    public void test() throws IOException {
        List<Local> listLocal = localServiceImpl.getAllLocal();
        for (Local local : listLocal) {
            weatherDataServiceImpl.deleteAllValueOfLocal(local.getCode());
            setDataWeatherToDB(local);
        }
    }

    public void setDataWeatherToDB(Local local) throws IOException {
        JSONObject weather = readJsonFromUrl("http://api.openweathermap.org/data/2.5/forecast?id=" + local.getCode() + "&appid=21f64a715eae4e2931cc32d254f65bbc&lang=vi&units=metric");
        JSONArray array = weather.getJSONArray("list");
        for (int i = 0; i < array.length(); i++) {
            weatherDataServiceImpl.save(new WeatherData(
                    array.getJSONObject(i).getString("dt_txt"),
                    array.getJSONObject(i).getJSONObject("main").getFloat("temp"),
                    array.getJSONObject(i).getJSONObject("main").getFloat("temp_min"),
                    array.getJSONObject(i).getJSONObject("main").getFloat("temp_max"),
                    array.getJSONObject(i).getJSONObject("main").getFloat("humidity"),
                    array.getJSONObject(i).getJSONArray("weather").getJSONObject(0).getString("main"),
                    array.getJSONObject(i).getJSONArray("weather").getJSONObject(0).getString("description"),
                    array.getJSONObject(i).getJSONObject("clouds").getFloat("all"),
                    array.getJSONObject(i).getJSONObject("wind").getFloat("speed"),
                    array.getJSONObject(i).getJSONObject("wind").getFloat("deg"),
                    array.getJSONObject(i).getFloat("visibility"),
                    array.getJSONObject(i).getJSONObject("sys").getString("pod"),
                    local
            ));
        }
    }
}
