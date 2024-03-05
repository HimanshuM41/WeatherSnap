package com.example.weathersnap.JSON_TO_POJO;

import java.io.Serializable;

public class CloudsDTO implements Serializable {
	private int all;

	public void setAll(int all){
		this.all = all;
	}

	public int getAll(){
		return all;
	}

	@Override
 	public String toString(){
		return 
			"CloudsDTO{" + 
			"all = '" + all + '\'' + 
			"}";
		}
}