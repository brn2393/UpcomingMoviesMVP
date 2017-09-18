package com.buddhabhushan.b.mobisysassignment.ui.details;

import com.buddhabhushan.b.mobisysassignment.app.MoviesApp;
import com.buddhabhushan.b.mobisysassignment.data.api.APIInterface;
import com.buddhabhushan.b.mobisysassignment.data.models.MovieDetailsResponse;
import com.buddhabhushan.b.mobisysassignment.data.models.MovieImagesResponse;

import retrofit2.Call;

/**
 * Created by Buddhabhushan on 17-Sep-17. 16-Sep-17.
 */

public class MovieDetailsModel implements MovieDetails.Model {

    protected APIInterface apiInterface;

    public MovieDetailsModel() {
        super();
        apiInterface = MoviesApp.getInstance().getApiInterface();
    }

    @Override
    public Call<MovieImagesResponse> getMovieImages(int movie_id) {
        return apiInterface.getMovieImages(movie_id);
    }

    @Override
    public Call<MovieDetailsResponse> getMovieDetails(int movie_id) {
        return apiInterface.getMovieDetails(movie_id);
    }
}
