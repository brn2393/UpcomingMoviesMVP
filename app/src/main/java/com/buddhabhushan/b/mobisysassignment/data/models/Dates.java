package com.buddhabhushan.b.mobisysassignment.data.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Dates extends BaseModel implements Parcelable {

	@JsonProperty("maximum")
	private String maximum;

	@JsonProperty("minimum")
	private String minimum;

	public void setMaximum(String maximum){
		this.maximum = maximum;
	}

	public String getMaximum(){
		return maximum;
	}

	public void setMinimum(String minimum){
		this.minimum = minimum;
	}

	public String getMinimum(){
		return minimum;
	}

	@Override
 	public String toString(){
		return 
			"Dates{" + 
			"maximum = '" + maximum + '\'' + 
			",minimum = '" + minimum + '\'' + 
			"}";
		}


	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.maximum);
		dest.writeString(this.minimum);
		dest.writeInt(this._ID);
	}

	public Dates() {
	}

	protected Dates(Parcel in) {
		this.maximum = in.readString();
		this.minimum = in.readString();
		this._ID = in.readInt();
	}

	public static final Parcelable.Creator<Dates> CREATOR = new Parcelable.Creator<Dates>() {
		@Override
		public Dates createFromParcel(Parcel source) {
			return new Dates(source);
		}

		@Override
		public Dates[] newArray(int size) {
			return new Dates[size];
		}
	};
}