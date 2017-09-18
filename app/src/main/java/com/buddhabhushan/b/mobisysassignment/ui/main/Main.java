package com.buddhabhushan.b.mobisysassignment.ui.main;

import com.buddhabhushan.b.mobisysassignment.data.models.APIResponse;
import com.buddhabhushan.b.mobisysassignment.ui.base.Mvp;

import retrofit2.Call;

/**
 * Created by Bhushan on 22-Jun-17.
 */

interface Main {

    interface View extends Mvp.View {
        void updateViews(APIResponse resultsItems);
    }

    interface Model extends Mvp.Model {
        Call<APIResponse> getUpcomingMovies();
    }

    interface Presenter extends Mvp.Presenter<Main.View, Main.Model> {
        void getMovies();
    }
}
