package com.buddhabhushan.b.mobisysassignment.ui.details;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.AppCompatRatingBar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.buddhabhushan.b.mobisysassignment.R;
import com.buddhabhushan.b.mobisysassignment.data.models.MovieDetailsResponse;
import com.buddhabhushan.b.mobisysassignment.data.models.PostersItem;
import com.buddhabhushan.b.mobisysassignment.domain.Constants;
import com.buddhabhushan.b.mobisysassignment.domain.adapters.CustomPagerAdapter;
import com.buddhabhushan.b.mobisysassignment.ui.base.BaseActivity;
import com.buddhabhushan.b.mobisysassignment.ui.info.InfoActivity;
import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by B on 17-09-2017.
 */

public class MovieDetailsActivity extends BaseActivity implements MovieDetails.View {

    private MovieDetailsPresenter presenter;
    private CustomPagerAdapter customPagerAdapter;

    @BindView(R.id.progressbar)
    ProgressBar progressbar;
    @BindView(R.id.cl_activity_details)
    ConstraintLayout clActivityDetails;
    @BindView(R.id.tv_activity_details_title)
    TextView tvActivityDetailsTitle;
    @BindView(R.id.tv_activity_details_overview)
    TextView tvActivityDetailsOverview;
    @BindView(R.id.rb_activity_details_rating)
    AppCompatRatingBar rbActivityDetailsRating;
    @BindView(R.id.indicator)
    CirclePageIndicator ciActivityDetails;
    @BindView(R.id.vp_activity_details)
    ViewPager vpActivityDetails;

    private int id;
    private double popularity;

    @Override
    protected int getLayout() {
        return R.layout.activity_movie_details;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViews();

        presenter.getImages(id);
        presenter.getDetails(id);
    }

    @Override
    protected void init() {
        presenter = new MovieDetailsPresenter();
        presenter.setView(this);
        id = getIntent().getIntExtra(Constants.EXTRA_MOVIE_ID, -1);
    }

    protected void initViews() {
        setToolbarTitle(null);
    }

    @Override
    public void showProgress() {
        progressbar.setIndeterminate(true);
        progressbar.setVisibility(View.VISIBLE);
        clActivityDetails.setVisibility(View.GONE);
    }

    @Override
    public void hideProgress() {
        progressbar.setIndeterminate(false);
        progressbar.setVisibility(View.GONE);
        clActivityDetails.setVisibility(View.VISIBLE);
    }

    @Override
    public void showAlert(String s, int t) {

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
    public void updateViewPager(List<PostersItem> postersItem) {
        if (postersItem.size() >= 5) {
            customPagerAdapter = new CustomPagerAdapter(this, new ArrayList<>(postersItem.subList(0, 5)));
        } else {
            customPagerAdapter = new CustomPagerAdapter(this, new ArrayList<>(postersItem));
        }

        vpActivityDetails.setAdapter(customPagerAdapter);
        ciActivityDetails.setViewPager(vpActivityDetails);
    }

    @Override
    public void updateViews(MovieDetailsResponse movieDetails) {
        setToolbarTitle(movieDetails.getTitle());
        tvActivityDetailsTitle.setText(movieDetails.getTitle());
        tvActivityDetailsOverview.setText(movieDetails.getOverview());
        popularity = movieDetails.getPopularity();

        rbActivityDetailsRating.setRating((float) ((popularity * 5) / 100));
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
