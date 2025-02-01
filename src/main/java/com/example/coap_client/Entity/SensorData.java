package com.example.coap_client.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class SensorData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String timestamp;
    private double temperature;
    private int lightLevel;
    private double binLevel;
    private double humidity;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public int getLightLevel() {
        return lightLevel;
    }

    public void setLightLevel(int lightLevel) {
        this.lightLevel = lightLevel;
    }

    public double getBinLevel() {
        return binLevel;
    }

    public void setBinLevel(double binLevel) {
        this.binLevel = binLevel;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    @Override
    public String toString() {
        return "SensorData{" +
                "id=" + id +
                ", timestamp='" + timestamp + '\'' +
                ", temperature=" + temperature +
                ", lightLevel=" + lightLevel +
                ", binLevel=" + binLevel +
                ", humidity=" + humidity +
                '}';
    }
}