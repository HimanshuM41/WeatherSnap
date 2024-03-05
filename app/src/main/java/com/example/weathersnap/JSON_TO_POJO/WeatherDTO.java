package com.example.weathersnap.JSON_TO_POJO;

import java.io.Serializable;

public class WeatherDTO implements Serializable {
	private int id;
	private String main;
	private String description;
	private String icon;

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setMain(String main){
		this.main = main;
	}

	public String getMain(){
		return main;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setIcon(String icon){
		this.icon = icon;
	}

	public String getIcon(){
		return icon;
	}

	@Override
 	public String toString(){
		return 
			"WeatherDTO{" + 
			"id = '" + id + '\'' + 
			",main = '" + main + '\'' + 
			",description = '" + description + '\'' + 
			",icon = '" + icon + '\'' + 
			"}";
		}
}