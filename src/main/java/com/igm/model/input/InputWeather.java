package com.igm.model.input;

public class InputWeather {


    private Weather weather[];
    private Main main;
    private Wind wind;


    public Weather[] getWeather() {
        return weather;
    }

    public void setWeather(Weather[] weather) {
        this.weather = weather;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }


    public static class Weather {
        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        private String description;


    }

    public static class Main {
        public float getTemp() {
            return temp;
        }

        public void setTemp(float temp) {
            this.temp = temp;
        }

        private float temp;
    }

    public static class Wind {
        public float getSpeed() {
            return speed;
        }

        public void setSpeed(float speed) {
            this.speed = speed;
        }

        private float speed;
    }
}
