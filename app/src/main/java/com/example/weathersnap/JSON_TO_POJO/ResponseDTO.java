package com.example.weathersnap.JSON_TO_POJO;

import java.util.List;
import java.io.Serializable;

public class ResponseDTO implements Serializable {
	private CoordDTO coord;
	private List<WeatherDTO> weather;
	private String base;
	private MainDTO main;
	private int visibility;
	private WindDTO wind;
	private CloudsDTO clouds;
	private int dt;
	private SysDTO sys;
	private int timezone;
	private int id;
	private String name;
	private int cod;

	public void setCoord(CoordDTO coord){
		this.coord = coord;
	}

	public CoordDTO getCoord(){
		return coord;
	}

	public void setWeather(List<WeatherDTO> weather){
		this.weather = weather;
	}

	public List<WeatherDTO> getWeather(){
		return weather;
	}

	public void setBase(String base){
		this.base = base;
	}

	public String getBase(){
		return base;
	}

	public void setMain(MainDTO main){
		this.main = main;
	}

	public MainDTO getMain(){
		return main;
	}

	public void setVisibility(int visibility){
		this.visibility = visibility;
	}

	public int getVisibility(){
		return visibility;
	}

	public void setWind(WindDTO wind){
		this.wind = wind;
	}

	public WindDTO getWind(){
		return wind;
	}

	public void setClouds(CloudsDTO clouds){
		this.clouds = clouds;
	}

	public CloudsDTO getClouds(){
		return clouds;
	}

	public void setDt(int dt){
		this.dt = dt;
	}

	public int getDt(){
		return dt;
	}

	public void setSys(SysDTO sys){
		this.sys = sys;
	}

	public SysDTO getSys(){
		return sys;
	}

	public void setTimezone(int timezone){
		this.timezone = timezone;
	}

	public int getTimezone(){
		return timezone;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setCod(int cod){
		this.cod = cod;
	}

	public int getCod(){
		return cod;
	}

	@Override
 	public String toString(){
		return 
			"ResponseDTO{" + 
			"coord = '" + coord + '\'' + 
			",weather = '" + weather + '\'' + 
			",base = '" + base + '\'' + 
			",main = '" + main + '\'' + 
			",visibility = '" + visibility + '\'' + 
			",wind = '" + wind + '\'' + 
			",clouds = '" + clouds + '\'' + 
			",dt = '" + dt + '\'' + 
			",sys = '" + sys + '\'' + 
			",timezone = '" + timezone + '\'' + 
			",id = '" + id + '\'' + 
			",name = '" + name + '\'' + 
			",cod = '" + cod + '\'' + 
			"}";
		}
}