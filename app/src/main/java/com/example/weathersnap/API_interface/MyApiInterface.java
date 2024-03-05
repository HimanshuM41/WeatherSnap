package com.example.weathersnap.API_interface;

import com.example.weathersnap.JSON_TO_POJO.ResponseDTO;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MyApiInterface {

    @GET("weather")
    Call<ResponseDTO> getWeatherData(
            @Query("q") String city,
            @Query("appId") String appid,
            @Query("units") String units
    );
}
