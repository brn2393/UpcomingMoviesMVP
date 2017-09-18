package com.buddhabhushan.b.mobisysassignment.ui.main;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.buddhabhushan.b.mobisysassignment.R;
import com.buddhabhushan.b.mobisysassignment.app.MoviesApp;
import com.buddhabhushan.b.mobisysassignment.data.models.APIResponse;
import com.buddhabhushan.b.mobisysassignment.data.models.ResultsItem;
import com.buddhabhushan.b.mobisysassignment.domain.AppPreferences;
import com.buddhabhushan.b.mobisysassignment.domain.Constants;
import com.buddhabhushan.b.mobisysassignment.domain.adapters.CustomRVAdapter;
import com.buddhabhushan.b.mobisysassignment.domain.adapters.MovieListAdapter;
import com.buddhabhushan.b.mobisysassignment.ui.base.BaseActivity;
import com.buddhabhushan.b.mobisysassignment.ui.details.MovieDetailsActivity;
import com.buddhabhushan.b.mobisysassignment.ui.info.InfoActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements Main.View,
        CustomRVAdapter.OnViewHolderClick {

    protected MainPresenter presenter;
    private LinearLayoutManager cLayoutManager;
    private MovieListAdapter aMovieListAdapter;

    @BindView(R.id.progressbar)
    ProgressBar progressbar;
    @BindView(R.id.tv_activity_main_no_records)
    TextView tvActivityMainNoRecords;
    @BindView(R.id.rv_activity_main)
    RecyclerView rvActivityMain;
    @BindView(R.id.rl_activity_main)
    RelativeLayout rlActivityMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        initViews();

        presenter.getMovies();
    }

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void init() {
        setToolbarTitle(R.string.title_activity_main);
        presenter = new MainPresenter();
        presenter.setView(this);

        cLayoutManager = new LinearLayoutManager(MoviesApp.getContext());
    }

    protected void initViews() {
        rvActivityMain.setLayoutManager(cLayoutManager);
        rvActivityMain.setItemAnimator(new DefaultItemAnimator());

        aMovieListAdapter = new MovieListAdapter(this, this);
        rvActivityMain.setAdapter(aMovieListAdapter);
    }

    @Override
    public void showProgress() {
        progressbar.setIndeterminate(true);
        progressbar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressbar.setIndeterminate(false);
        progressbar.setVisibility(View.GONE);
    }

    @Override
    public void showAlert(String message, int type) {
        AppPreferences.showAlert(rlActivityMain, message, type);
        progressbar.setVisibility(View.GONE);
        tvActivityMainNoRecords.setVisibility(View.VISIBLE);
    }

    @Override
    public void finishView() {
        finish();
    }

    @Override
    public void startActivity(Class<? extends BaseActivity> c, int extra_int) {
        Intent intent = new Intent(this, c);
        intent.putExtra(Constants.EXTRA_MOVIE_ID, extra_int);
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
    }

    @Override
    public void navigateToHome() {

    }

    @Override
    public void updateViews(final APIResponse resultsItems) {
        if (resultsItems != null) {
            rvActivityMain.setVisibility(View.VISIBLE);
            tvActivityMainNoRecords.setVisibility(View.GONE);

            final ArrayList<ResultsItem> arrayList = new ArrayList<>(resultsItems.getResults());
            aMovieListAdapter.setList(arrayList);
            aMovieListAdapter.notifyDataSetChanged();
        } else {
            rvActivityMain.setVisibility(View.GONE);
            tvActivityMainNoRecords.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onClick(View view, int position) {
        startActivity(MovieDetailsActivity.class, aMovieListAdapter.getItem(position).getId());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                presenter.onDestroy();
                break;
            case R.id.menu_action_info:
                startActivity(InfoActivity.class, -1);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
