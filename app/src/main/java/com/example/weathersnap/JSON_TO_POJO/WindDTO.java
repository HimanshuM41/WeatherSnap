package com.example.weathersnap.JSON_TO_POJO;

import java.io.Serializable;

public class WindDTO implements Serializable {
	private Object speed;
	private int deg;

	public void setSpeed(Object speed){
		this.speed = speed;
	}

	public Object getSpeed(){
		return speed;
	}

	public void setDeg(int deg){
		this.deg = deg;
	}

	public int getDeg(){
		return deg;
	}

	@Override
 	public String toString(){
		return 
			"WindDTO{" + 
			"speed = '" + speed + '\'' + 
			",deg = '" + deg + '\'' + 
			"}";
		}
}