package com.example.demo.WeatherProject.Modal;

import javax.persistence.*;

@Entity
@Table(name = "local")
public class Local {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "code")
    private int code;
    @Column(name = "coordLat")
    private float coordLat;
    @Column(name = "coordLon")
    private float coordLon;

    public Local() {
    }

    public Local(String name, int code, float coordLat, float coordLon) {
        this.name = name;
        this.code = code;
        this.coordLat = coordLat;
        this.coordLon = coordLon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public float getCoordLat() {
        return coordLat;
    }

    public void setCoordLat(float coordLat) {
        this.coordLat = coordLat;
    }

    public float getCoordLon() {
        return coordLon;
    }

    public void setCoordLon(float coordLon) {
        this.coordLon = coordLon;
    }
}
