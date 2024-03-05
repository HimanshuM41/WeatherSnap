package com.example.weathersnap.JSON_TO_POJO;

import java.io.Serializable;

public class MainDTO implements Serializable {
	private Object temp;
	private Object feelsLike;
	private Object tempMin;
	private Object tempMax;
	private int pressure;
	private int humidity;

	public void setTemp(Object temp){
		this.temp = temp;
	}

	public Object getTemp(){
		return temp;
	}

	public void setFeelsLike(Object feelsLike){
		this.feelsLike = feelsLike;
	}

	public Object getFeelsLike(){
		return feelsLike;
	}

	public void setTempMin(Object tempMin){
		this.tempMin = tempMin;
	}

	public Object getTempMin(){
		return tempMin;
	}

	public void setTempMax(Object tempMax){
		this.tempMax = tempMax;
	}

	public Object getTempMax(){
		return tempMax;
	}

	public void setPressure(int pressure){
		this.pressure = pressure;
	}

	public int getPressure(){
		return pressure;
	}

	public void setHumidity(int humidity){
		this.humidity = humidity;
	}

	public int getHumidity(){
		return humidity;
	}

	@Override
 	public String toString(){
		return 
			"MainDTO{" + 
			"temp = '" + temp + '\'' + 
			",feels_like = '" + feelsLike + '\'' + 
			",temp_min = '" + tempMin + '\'' + 
			",temp_max = '" + tempMax + '\'' + 
			",pressure = '" + pressure + '\'' + 
			",humidity = '" + humidity + '\'' + 
			"}";
		}
}