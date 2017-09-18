package com.buddhabhushan.b.mobisysassignment.ui.main;

import com.buddhabhushan.b.mobisysassignment.data.models.APIResponse;
import com.buddhabhushan.b.mobisysassignment.ui.base.Mvp;

import retrofit2.Call;

/**
 * Created by Buddhabhushan on 17-Sep-17. 16-Sep-17.
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
