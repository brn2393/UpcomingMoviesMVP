package com.buddhabhushan.b.mobisysassignment.data.api;

import com.buddhabhushan.b.mobisysassignment.data.models.APIResponse;
import com.buddhabhushan.b.mobisysassignment.data.models.MovieDetailsResponse;
import com.buddhabhushan.b.mobisysassignment.data.models.MovieImagesResponse;
import com.buddhabhushan.b.mobisysassignment.domain.Constants;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Buddhabhushan on 17-Sep-17.
 */
public interface APIInterface {

    //    https://api.themoviedb.org/3/movie/upcoming
    @GET("upcoming?api_key=" + Constants.API_KEY)
    Call<APIResponse> getResponse();

    //    https://api.themoviedb.org/3/movie/<movie-id>
    @GET("{movie-id}?api_key=" + Constants.API_KEY)
    Call<MovieDetailsResponse> getMovieDetails(@Path("movie-id") int movieId);

    //    https://api.themoviedb.org/3/movie/<movie-id>/images
    @GET("{movie-id}/images?api_key=" + Constants.API_KEY)
    Call<MovieImagesResponse> getMovieImages(@Path("movie-id") int movieId);
}