package com.buddhabhushan.b.mobisysassignment.data.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class MovieImagesResponse{

	@JsonProperty("backdrops")
	private List<BackdropsItem> backdrops;

	@JsonProperty("posters")
	private List<PostersItem> posters;

	@JsonProperty("id")
	private int id;

	public void setBackdrops(List<BackdropsItem> backdrops){
		this.backdrops = backdrops;
	}

	public List<BackdropsItem> getBackdrops(){
		return backdrops;
	}

	public void setPosters(List<PostersItem> posters){
		this.posters = posters;
	}

	public List<PostersItem> getPosters(){
		return posters;
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
			"MovieImagesResponse{" + 
			"backdrops = '" + backdrops + '\'' + 
			",posters = '" + posters + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}