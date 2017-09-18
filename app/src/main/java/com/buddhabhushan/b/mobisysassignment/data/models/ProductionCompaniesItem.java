package com.buddhabhushan.b.mobisysassignment.data.models;

import com.fasterxml.jackson.annotation.JsonProperty;


public class ProductionCompaniesItem{

	@JsonProperty("name")
	private String name;

	@JsonProperty("id")
	private int id;

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	@Override
 	public String toString(){
		return 
			"ProductionCompaniesItem{" + 
			"name = '" + name + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}