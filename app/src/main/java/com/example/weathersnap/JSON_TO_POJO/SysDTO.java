package com.example.weathersnap.JSON_TO_POJO;

import java.io.Serializable;

public class SysDTO implements Serializable {
	private int type;
	private int id;
	private String country;
	private int sunrise;
	private int sunset;

	public void setType(int type){
		this.type = type;
	}

	public int getType(){
		return type;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setCountry(String country){
		this.country = country;
	}

	public String getCountry(){
		return country;
	}

	public void setSunrise(int sunrise){
		this.sunrise = sunrise;
	}

	public int getSunrise(){
		return sunrise;
	}

	public void setSunset(int sunset){
		this.sunset = sunset;
	}

	public int getSunset(){
		return sunset;
	}

	@Override
 	public String toString(){
		return 
			"SysDTO{" + 
			"type = '" + type + '\'' + 
			",id = '" + id + '\'' + 
			",country = '" + country + '\'' + 
			",sunrise = '" + sunrise + '\'' + 
			",sunset = '" + sunset + '\'' + 
			"}";
		}
}