package com.example.artyom.simplestmvp.data.network;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by artyom on 10/03/2018.
 */

public interface WeatherNetworkService {

    @GET("/url_to_some_weather")
    Call<String> getWeatherData();

}
