package com.example.demo.WeatherProject.Modal;

import javax.persistence.*;

@Entity
@Table(name = "weather_data")
public class WeatherData {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "time_weather")
    private String timeWeather;
    @Column(name = "temp")
    private float temp;
    @Column(name = "min_temp")
    private float minTemp;
    @Column(name = "max_temp")
    private float maxTemp;
    @Column(name = "humidity")
    private float humidity;
    @Column(name = "weather")
    private String weather;
    @Column(name = "weather_description")
    private String weatherDescription;
    @Column(name = "cloud")
    private float cloud;
    @Column(name = "wind_speed")
    private float windSpeed;
    @Column(name = "wind_deg")
    private float windDeg;
    @Column(name = "visibility")
    private float visibility;
    @Column(name = "pod")
    private String pod;
    @ManyToOne
    @JoinColumn(name = "weather_id")
    private Local local;

    public WeatherData() {
    }

    public WeatherData(
            String timeWeather, float temp, float minTemp, float maxTemp, float humidity,
            String weather, String weatherDescription, float cloud,
            float windSpeed, float windDeg,
            float visibility, String pod,
            Local local
    ) {
        this.timeWeather = timeWeather;
        this.temp = temp;
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
        this.humidity = humidity;
        this.weather = weather;
        this.weatherDescription = weatherDescription;
        this.cloud = cloud;
        this.windSpeed = windSpeed;
        this.windDeg = windDeg;
        this.visibility = visibility;
        this.pod = pod;
        this.local = local;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTimeWeather() {
        return timeWeather;
    }

    public void setTimeWeather(String timeWeather) {
        this.timeWeather = timeWeather;
    }

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public float getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(float minTemp) {
        this.minTemp = minTemp;
    }

    public float getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(float maxTemp) {
        this.maxTemp = maxTemp;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getWeatherDescription() {
        return weatherDescription;
    }

    public void setWeatherDescription(String weatherDescription) {
        this.weatherDescription = weatherDescription;
    }

    public float getCloud() {
        return cloud;
    }

    public void setCloud(int cloud) {
        this.cloud = cloud;
    }

    public float getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(float windSpeed) {
        this.windSpeed = windSpeed;
    }

    public float getWindDeg() {
        return windDeg;
    }

    public void setWindDeg(float windDeg) {
        this.windDeg = windDeg;
    }

    public float getVisibility() {
        return visibility;
    }

    public void setVisibility(float visibility) {
        this.visibility = visibility;
    }

    public String getPod() {
        return pod;
    }

    public void setPod(String pod) {
        this.pod = pod;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }
}
