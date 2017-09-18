package com.buddhabhushan.b.mobisysassignment.ui.details;

import com.buddhabhushan.b.mobisysassignment.data.models.MovieDetailsResponse;
import com.buddhabhushan.b.mobisysassignment.data.models.MovieImagesResponse;
import com.buddhabhushan.b.mobisysassignment.domain.AppPreferences;
import com.buddhabhushan.b.mobisysassignment.domain.Constants;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Buddhabhushan on 17-Sep-17. 16-Sep-17.
 */

public class MovieDetailsPresenter implements MovieDetails.Presenter {

    private MovieDetails.View view;
    protected MovieDetailsModel model;

    public MovieDetailsPresenter() {
        this.model = new MovieDetailsModel();
    }

    public void setView(MovieDetails.View view) {
        this.view = view;
    }

    @Override
    public MovieDetails.View getView() {
        return view;
    }

    @Override
    public void onDestroy() {
        view.finishView();
    }

    @Override
    public void onNavigateToHome() {
        getView().navigateToHome();
    }

    @Override
    public void onShowProgress() {
        getView().showProgress();
    }

    @Override
    public void onHideProgress() {
        getView().hideProgress();
    }

    @Override
    public void getImages(int movie_id) {
        if (AppPreferences.isNetworkAvailable()) {
            onShowProgress();
            Call<MovieImagesResponse> c = model.getMovieImages(movie_id);
            try {
                c.enqueue(new Callback<MovieImagesResponse>() {
                    @Override
                    public void onResponse(Call<MovieImagesResponse> call, Response<MovieImagesResponse> response) {
                        onHideProgress();
                        getView().updateViewPager(response.body().getPosters());
                    }

                    @Override
                    public void onFailure(Call<MovieImagesResponse> call, Throwable t) {
                        onHideProgress();
                        getView().showAlert(t.getLocalizedMessage(), Constants.ALERT_TYPE_DIALOG);
                    }
                });
            } catch (Exception e) {
                getView().showAlert(e.getLocalizedMessage(), Constants.ALERT_TYPE_DIALOG);
            }
        } else {
            getView().showAlert(Constants.PROMPT_NO_INTERNET, Constants.ALERT_TYPE_TOAST);
        }
    }

    @Override
    public void getDetails(int movie_id) {
        if (AppPreferences.isNetworkAvailable()) {
            onShowProgress();
            Call<MovieDetailsResponse> call = model.getMovieDetails(movie_id);
            try {
                call.enqueue(new Callback<MovieDetailsResponse>() {
                    @Override
                    public void onResponse(Call<MovieDetailsResponse> call, Response<MovieDetailsResponse> response) {
                        onHideProgress();
                        getView().updateViews(response.body());
                    }

                    @Override
                    public void onFailure(Call<MovieDetailsResponse> call, Throwable t) {
                        onHideProgress();
                        getView().showAlert(t.getLocalizedMessage(), Constants.ALERT_TYPE_DIALOG);
                    }
                });
            } catch (Exception e) {
                getView().showAlert(e.getLocalizedMessage(), Constants.ALERT_TYPE_DIALOG);
            }
        } else {
            getView().showAlert(Constants.PROMPT_NO_INTERNET, Constants.ALERT_TYPE_TOAST);
        }
    }
}
