package com.example.coap_client.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class LedStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean redLed;
    private boolean yellowLed;
    private boolean greenLed;
    private LocalDateTime timestamp;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isRedLed() {
        return redLed;
    }

    public void setRedLed(boolean redLed) {
        this.redLed = redLed;
    }

    public boolean isYellowLed() {
        return yellowLed;
    }

    public void setYellowLed(boolean yellowLed) {
        this.yellowLed = yellowLed;
    }

    public boolean isGreenLed() {
        return greenLed;
    }

    public void setGreenLed(boolean greenLed) {
        this.greenLed = greenLed;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "LedStatus{" +
                "id=" + id +
                ", redLed=" + redLed +
                ", yellowLed=" + yellowLed +
                ", greenLed=" + greenLed +
                ", timestamp=" + timestamp +
                '}';
    }
}