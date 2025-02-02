package com.example.coap_client.DTO;

public class LedStatusDTO {
    private boolean redLed;
    private boolean yellowLed;
    private boolean greenLed;

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
}