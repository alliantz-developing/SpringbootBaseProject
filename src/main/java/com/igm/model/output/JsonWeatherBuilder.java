package com.igm.model.output;

import com.google.gson.JsonObject;
import com.igm.model.input.InputWeather;

public class JsonWeatherBuilder {

    private InputWeather inputWeather;
    public JsonWeatherBuilder(InputWeather iw){
        this.inputWeather = iw;
    }

    public JsonObject build() {
        JsonObject obj = new JsonObject();
        obj.addProperty("title", "Weather");
        obj.addProperty("type", "object");
        JsonObject properties = new JsonObject();

        JsonObject condition = new JsonObject();
        condition.addProperty("type", "string");
        condition.addProperty("description", this.inputWeather.getWeather()[0].getDescription());
        properties.add("condition", condition);

        JsonObject temperature = new JsonObject();
        temperature.addProperty("type", "number");
        temperature.addProperty("description", this.inputWeather.getMain().getTemp());
        properties.add("description", temperature);

        JsonObject windSpeed = new JsonObject();
        windSpeed.addProperty("type", "number");
        windSpeed.addProperty("description", this.inputWeather.getWind().getSpeed());
        windSpeed.addProperty("minimum", 0);
        properties.add("wind_speed", windSpeed);

        obj.add("properties", properties);

        return obj;
    }
}
