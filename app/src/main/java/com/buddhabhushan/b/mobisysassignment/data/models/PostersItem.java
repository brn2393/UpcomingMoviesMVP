package com.buddhabhushan.b.mobisysassignment.data.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PostersItem{

	@JsonProperty("aspect_ratio")
	private double aspectRatio;

	@JsonProperty("file_path")
	private String filePath;

	@JsonProperty("vote_average")
	private double voteAverage;

	@JsonProperty("width")
	private int width;

	@JsonProperty("iso_639_1")
	private String iso6391;

	@JsonProperty("vote_count")
	private int voteCount;

	@JsonProperty("height")
	private int height;

	public void setAspectRatio(double aspectRatio){
		this.aspectRatio = aspectRatio;
	}

	public double getAspectRatio(){
		return aspectRatio;
	}

	public void setFilePath(String filePath){
		this.filePath = filePath;
	}

	public String getFilePath(){
		return filePath;
	}

	public void setVoteAverage(double voteAverage){
		this.voteAverage = voteAverage;
	}

	public double getVoteAverage(){
		return voteAverage;
	}

	public void setWidth(int width){
		this.width = width;
	}

	public int getWidth(){
		return width;
	}

	public void setIso6391(String iso6391){
		this.iso6391 = iso6391;
	}

	public String getIso6391(){
		return iso6391;
	}

	public void setVoteCount(int voteCount){
		this.voteCount = voteCount;
	}

	public int getVoteCount(){
		return voteCount;
	}

	public void setHeight(int height){
		this.height = height;
	}

	public int getHeight(){
		return height;
	}

	@Override
 	public String toString(){
		return 
			"PostersItem{" + 
			"aspect_ratio = '" + aspectRatio + '\'' + 
			",file_path = '" + filePath + '\'' + 
			",vote_average = '" + voteAverage + '\'' + 
			",width = '" + width + '\'' + 
			",iso_639_1 = '" + iso6391 + '\'' + 
			",vote_count = '" + voteCount + '\'' + 
			",height = '" + height + '\'' + 
			"}";
		}
}