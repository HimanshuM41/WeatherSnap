package com.example.weathersnap.JSON_TO_POJO;

import java.io.Serializable;

public class CoordDTO implements Serializable {
	private Object lon;
	private Object lat;

	public void setLon(Object lon){
		this.lon = lon;
	}

	public Object getLon(){
		return lon;
	}

	public void setLat(Object lat){
		this.lat = lat;
	}

	public Object getLat(){
		return lat;
	}

	@Override
 	public String toString(){
		return 
			"CoordDTO{" + 
			"lon = '" + lon + '\'' + 
			",lat = '" + lat + '\'' + 
			"}";
		}
}