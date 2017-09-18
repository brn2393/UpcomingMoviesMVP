package com.buddhabhushan.b.mobisysassignment.ui.main;

import com.buddhabhushan.b.mobisysassignment.app.MoviesApp;
import com.buddhabhushan.b.mobisysassignment.data.api.APIInterface;
import com.buddhabhushan.b.mobisysassignment.data.models.APIResponse;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by Bhushan on 22-Jun-17.
 */

public class MainModel implements Main.Model {

    protected APIInterface apiInterface;

    public MainModel() {
        super();
        apiInterface = MoviesApp.getInstance().getApiInterface();
    }

    @Override
    public Call<APIResponse> getUpcomingMovies() {
        return apiInterface.getResponse();
    }
}
