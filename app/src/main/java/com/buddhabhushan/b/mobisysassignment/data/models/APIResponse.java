package com.buddhabhushan.b.mobisysassignment.data.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class APIResponse extends BaseModel implements Parcelable {

	@JsonProperty("dates")
	private Dates dates;

	@JsonProperty("page")
	private int page;

	@JsonProperty("total_pages")
	private int totalPages;

	@JsonProperty("results")
	private List<ResultsItem> results;

	@JsonProperty("total_results")
	private int totalResults;

	public void setDates(Dates dates){
		this.dates = dates;
	}

	public Dates getDates(){
		return dates;
	}

	public void setPage(int page){
		this.page = page;
	}

	public int getPage(){
		return page;
	}

	public void setTotalPages(int totalPages){
		this.totalPages = totalPages;
	}

	public int getTotalPages(){
		return totalPages;
	}

	public void setResults(List<ResultsItem> results){
		this.results = results;
	}

	public List<ResultsItem> getResults(){
		return results;
	}

	public void setTotalResults(int totalResults){
		this.totalResults = totalResults;
	}

	public int getTotalResults(){
		return totalResults;
	}

	@Override
 	public String toString(){
		return 
			"APIResponse{" +
			"dates = '" + dates + '\'' + 
			",page = '" + page + '\'' + 
			",total_pages = '" + totalPages + '\'' + 
			",results = '" + results + '\'' + 
			",total_results = '" + totalResults + '\'' + 
			"}";
		}


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.dates, flags);
        dest.writeInt(this.page);
        dest.writeInt(this.totalPages);
        dest.writeList(this.results);
        dest.writeInt(this.totalResults);
        dest.writeInt(this._ID);
    }

    public APIResponse() {
    }

    protected APIResponse(Parcel in) {
        this.dates = in.readParcelable(Dates.class.getClassLoader());
        this.page = in.readInt();
        this.totalPages = in.readInt();
        this.results = new ArrayList<ResultsItem>();
        in.readList(this.results, ResultsItem.class.getClassLoader());
        this.totalResults = in.readInt();
        this._ID = in.readInt();
    }

    public static final Parcelable.Creator<APIResponse> CREATOR = new Parcelable.Creator<APIResponse>() {
        @Override
        public APIResponse createFromParcel(Parcel source) {
            return new APIResponse(source);
        }

        @Override
        public APIResponse[] newArray(int size) {
            return new APIResponse[size];
        }
    };
}