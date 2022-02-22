package com.ss.eictapp.util;

import com.ss.eictapp.model.WeatherResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherService {
    @GET("/data/2.5/weather?")
    Call<WeatherResponse> getWeatherData(@Query("zip") String zip, @Query("appid") String appid);
    @GET("/data/2.5/weather?")
    Call<WeatherResponse> getWeatherByCity(@Query("q") String city, @Query("appid") String appid);
}
