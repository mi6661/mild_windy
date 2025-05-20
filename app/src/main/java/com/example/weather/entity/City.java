package com.example.weather.entity;

import com.example.weather.api.Weather;

public class City {
    public String name;
    public String location;
    public int temperature;
    public int humidity;
    public City(String name,String location,int temperature,int humidity){
        this.name = name;
        this.location = location;
        this.humidity = humidity;
        this.temperature = temperature;
    }

    public static City getCityByName(String name){
        Weather weather = new Weather(name);
        StringBuffer sb = new StringBuffer();
        //android不允许在主线程中使用http请求，所以开一个线程来请求数据

        new Thread(){
            @Override
            public void run(){
                weather.init();
                if(weather.connect()){
                    String data = weather.getData();
                    sb.append(data);
                }
            }
        }.start();

        return null;
    }


    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public int getTemperature() {
        return temperature;
    }

    public int getHumidity() {
        return humidity;
    }
}
