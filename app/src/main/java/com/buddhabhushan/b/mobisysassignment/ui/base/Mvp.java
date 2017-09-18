package com.buddhabhushan.b.mobisysassignment.ui.base;

/**
 * Created by Buddhabhushan on 17-Sep-17. 16-Sep-17.
 */

public interface Mvp {
    interface View{
        void showProgress();

        void hideProgress();

        void showAlert(String s, int t);

        void finishView();

        void startActivity(Class<? extends BaseActivity> c, int movie_id);

        void navigateToHome();
    }

    interface Model{

    }

    interface Presenter<V, M>{

        V getView();

        void onDestroy();

        void onNavigateToHome();

        void onShowProgress();

        void onHideProgress();
    }
}
