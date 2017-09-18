package com.buddhabhushan.b.mobisysassignment.ui.main;

import com.buddhabhushan.b.mobisysassignment.data.models.APIResponse;
import com.buddhabhushan.b.mobisysassignment.domain.AppPreferences;
import com.buddhabhushan.b.mobisysassignment.domain.Constants;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Bhushan on 22-Jun-17.
 */

public class MainPresenter implements Main.Presenter {

    private Main.View view;
    protected MainModel model;

    public MainPresenter() {
        this.model = new MainModel();
    }

    public void setView(Main.View view) {
        this.view = view;
    }

    @Override
    public Main.View getView() {
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
    public void getMovies() {
        if (AppPreferences.isNetworkAvailable()) {
            onShowProgress();
            Call<APIResponse> c = model.getUpcomingMovies();
            c.enqueue(new Callback<APIResponse>() {
                @Override
                public void onResponse(Call<APIResponse> call, Response<APIResponse> response) {
                    onHideProgress();
                    getView().updateViews(response.body());
                }

                @Override
                public void onFailure(Call<APIResponse> call, Throwable t) {
                    onHideProgress();
                    getView().showAlert(t.getLocalizedMessage(), Constants.ALERT_TYPE_SNACK);
                }
            });
        } else {
            getView().showAlert(Constants.PROMPT_NO_INTERNET, Constants.ALERT_TYPE_TOAST);
        }
    }
}
