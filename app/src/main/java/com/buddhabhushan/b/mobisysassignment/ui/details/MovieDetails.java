package com.buddhabhushan.b.mobisysassignment.ui.details;

import com.buddhabhushan.b.mobisysassignment.data.models.MovieDetailsResponse;
import com.buddhabhushan.b.mobisysassignment.data.models.MovieImagesResponse;
import com.buddhabhushan.b.mobisysassignment.data.models.PostersItem;
import com.buddhabhushan.b.mobisysassignment.ui.base.Mvp;

import java.util.List;

import retrofit2.Call;

/**
 * Created by Bhushan on 22-Jun-17.
 */

interface MovieDetails {

    interface View extends Mvp.View {
        void updateViewPager(List<PostersItem> postersItem);
        void updateViews(MovieDetailsResponse movieDetails);
    }

    interface Model extends Mvp.Model {
        Call<MovieImagesResponse> getMovieImages(int movie_id);
        Call<MovieDetailsResponse> getMovieDetails(int movie_id);
    }

    interface Presenter extends Mvp.Presenter<MovieDetails.View, MovieDetails.Model> {
        void getImages(int movie_id);
        void getDetails(int movie_id);
    }
}
