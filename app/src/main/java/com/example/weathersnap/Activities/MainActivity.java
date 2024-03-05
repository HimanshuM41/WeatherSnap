package com.example.weathersnap.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.SearchView;

import com.example.weathersnap.JSON_TO_POJO.ResponseDTO;
import com.example.weathersnap.JSON_TO_POJO.WeatherDTO;
import com.example.weathersnap.API_interface.MyApiInterface;
import com.example.weathersnap.R;
import com.example.weathersnap.databinding.ActivityMainBinding;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private static final String BASE_URL = "https://api.openweathermap.org/data/2.5/";
    private static final String API_KEY = "38edf4fb4d4c54f606e9aba78d089432";
    private static final String CITY_NAME = "Lucknow";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        fetchWeatherData("Lucknow");
        searchCity();
    }

    private void fetchWeatherData(String CITY_NAME) {
        //Initialize Retrofit
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        //create WeatherApi instance
        MyApiInterface weatherApi = retrofit.create(MyApiInterface.class);
        // Make API request
        Call<ResponseDTO> call = weatherApi.getWeatherData(CITY_NAME,API_KEY,"metrics");

        call.enqueue(new Callback<ResponseDTO>() {
            @Override
            public void onResponse(Call<ResponseDTO> call, Response<ResponseDTO> response) {
                ResponseDTO responseBody = response.body();
                if(response.isSuccessful() && responseBody!=null){
                    String temp = responseBody.getMain().getTemp().toString();
                    String temperature = convertTemperature(temp);


                    int humidity = responseBody.getMain().getHumidity();
                    String windSpeed = responseBody.getWind().getSpeed().toString();

                    long sunrise = responseBody.getSys().getSunrise();
                    long sunset = responseBody.getSys().getSunset();

                    if (responseBody != null && responseBody.getMain() != null) {
                        String MaxTemp = (String) responseBody.getMain().getTempMax();
                        if (MaxTemp != null) {
                            String celTempMax = convertTemperature(MaxTemp);
                            binding.maxTemp.setText("Max Temp: " + celTempMax + " °C");
                        }
                        else{
                            binding.maxTemp.setText("Max Temp: " + temperature + " °C");
                        }

                        String MinTemp = (String) responseBody.getMain().getTempMin();
                        if (MinTemp != null) {
                            String celTempMin = convertTemperature(MinTemp);
                            binding.minTemp.setText("Min Temp: " + celTempMin + " °C");
                        }
                        else{
                            binding.minTemp.setText("Min Temp: " + temperature + " °C");
                        }
                    }

                    String seaLevel = String.valueOf(responseBody.getMain().getPressure());

                    String condition = "Unknown";
                    List<WeatherDTO> weatherList =  responseBody.getWeather();
                    if(weatherList!=null && !weatherList.isEmpty()){
                        WeatherDTO firstWeather = weatherList.get(0);
                        if(firstWeather!=null){
                            String main = firstWeather.getMain();
                            if(main!=null){
                                condition = main;
                            }
                        }
                    }
                    binding.temp.setText(temperature + " °C");
                    binding.weather.setText(condition);
                    binding.humidity.setText(humidity + " %");
                    binding.windSpeed.setText(windSpeed + " m/s");
                    binding.condition.setText(condition);
                    binding.seaLevel.setText(seaLevel);
                    binding.day.setText(dayName(System.currentTimeMillis()));
                    binding.date.setText(currDate());
                    binding.cityName.setText(CITY_NAME);
                    binding.sunrise.setText(convertTime(sunrise));
                    binding.sunset.setText(convertTime(sunset));
                    changeImageAccordingToWeatherCondition(condition);
                }
            }
            @Override
            public void onFailure(Call<ResponseDTO> call, Throwable t) {
                Log.e("TAG", "onFailure: ");
            }
        });
    }

    private void changeImageAccordingToWeatherCondition(String condition) {

        switch (condition.toLowerCase()){
            case "fog": {
                binding.getRoot().setBackgroundResource(R.drawable.fog);
                binding.lottieAnimationView.setAnimation(R.raw.foglotti);
                break;
            }
            case "haze": {
                binding.getRoot().setBackgroundResource(R.drawable.fog);
                binding.lottieAnimationView.setAnimation(R.raw.foglotti);
                break;
            }
            case "mist": {
                binding.getRoot().setBackgroundResource(R.drawable.fog);
                binding.lottieAnimationView.setAnimation(R.raw.foglotti);
                break;
            }
            case "clouds":{
                binding.getRoot().setBackgroundResource(R.drawable.colud_background);
                binding.lottieAnimationView.setAnimation(R.raw.cloudlotti);
                break;
            }
            case "smoke":{
                binding.getRoot().setBackgroundResource(R.drawable.colud_background);
                binding.lottieAnimationView.setAnimation(R.raw.cloudlotti);
                break;
            }
            case "partly clouds":{
                binding.getRoot().setBackgroundResource(R.drawable.colud_background);
                binding.lottieAnimationView.setAnimation(R.raw.cloudlotti);
                break;
            }
            case "overcast":{
                binding.getRoot().setBackgroundResource(R.drawable.colud_background);
                binding.lottieAnimationView.setAnimation(R.raw.cloudlotti);
                break;
            }

            case "clear sky":{
                binding.getRoot().setBackgroundResource(R.drawable.sunny);
                binding.lottieAnimationView.setAnimation(R.raw.sunny2);
                break;
            }
            case "sunny":{
                binding.getRoot().setBackgroundResource(R.drawable.sunny);
                binding.lottieAnimationView.setAnimation(R.raw.sunny2);
                break;
            }
            case "clear":{
                binding.getRoot().setBackgroundResource(R.drawable.sunny);
                binding.lottieAnimationView.setAnimation(R.raw.sunny2);
                break;
            }
            case "light rain":{
                binding.getRoot().setBackgroundResource(R.drawable.rain_background);
                binding.lottieAnimationView.setAnimation(R.raw.rain);
                break;
            }
            case "drizzle":{
                binding.getRoot().setBackgroundResource(R.drawable.rain_background);
                binding.lottieAnimationView.setAnimation(R.raw.rain);
                break;
            }
            case "moderate rain":{
                binding.getRoot().setBackgroundResource(R.drawable.rain_background);
                binding.lottieAnimationView.setAnimation(R.raw.rain);
                break;
            }
            case "showers":{
                binding.getRoot().setBackgroundResource(R.drawable.rain_background);
                binding.lottieAnimationView.setAnimation(R.raw.rain);
                break;
            }
            case "heavy rain":{
                binding.getRoot().setBackgroundResource(R.drawable.rain_background);
                binding.lottieAnimationView.setAnimation(R.raw.rain);
                break;
            }

            case "light snow":{
                binding.getRoot().setBackgroundResource(R.drawable.snow_background);
                binding.lottieAnimationView.setAnimation(R.raw.snow);
                break;
            }
            case "moderate snow":{
                binding.getRoot().setBackgroundResource(R.drawable.snow_background);
                binding.lottieAnimationView.setAnimation(R.raw.snow);
                break;
            }
            case "heavy snow":{
                binding.getRoot().setBackgroundResource(R.drawable.snow_background);
                binding.lottieAnimationView.setAnimation(R.raw.snow);
                break;
            }
            case "blizzard":{
                binding.getRoot().setBackgroundResource(R.drawable.snow_background);
                binding.lottieAnimationView.setAnimation(R.raw.snow);
                break;
            }
            default:{
                binding.getRoot().setBackgroundResource(R.drawable.sunny);
                binding.lottieAnimationView.setAnimation(R.raw.sunny2);
            }
        }
        binding.lottieAnimationView.playAnimation();
    }

    public static String dayName(long timestamp){
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE", Locale.getDefault());
        return sdf.format(new Date(timestamp));
    }

    public static String currDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy",Locale.getDefault());
        return sdf.format(new Date());
    }

    public static String convertTime(long timestamp){
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm",Locale.getDefault());
        return sdf.format(new Date(timestamp*1000));
    }
    private void searchCity() {
        SearchView searchView = binding.searchView;

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (query!=null)
                    fetchWeatherData(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return true;
            }
        });

    }

    public static String convertTemperature(String temp) {
        if (temp != null && !temp.isEmpty()) {
            double kelvinTemp = Double.parseDouble(temp);
            return String.format("%.2f", kelvinTemp - 273.15);
        } else {
            return "N/A";
        }
    }
}