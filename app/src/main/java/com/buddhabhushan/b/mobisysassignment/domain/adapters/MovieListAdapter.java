package com.buddhabhushan.b.mobisysassignment.domain.adapters;

/**
 * Created by B on 17-09-2017.
 */

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.buddhabhushan.b.mobisysassignment.R;
import com.buddhabhushan.b.mobisysassignment.data.models.ResultsItem;
import com.buddhabhushan.b.mobisysassignment.domain.Constants;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class MovieListAdapter extends CustomRVAdapter<ResultsItem> {

    private final Context context;

    @BindView(R.id.row_item)
    ConstraintLayout rowItem;
    @BindView(R.id.civ_poster_image)
    CircleImageView civPosterImage;
    @BindView(R.id.tv_movie_name)
    TextView tvMovieName;
    @BindView(R.id.tv_release_date)
    TextView tvReleaseDate;
    @BindView(R.id.tv_adult)
    TextView tvAdult;
    @BindView(R.id.imageView)
    ImageView imageView;

    public MovieListAdapter(Context context, OnViewHolderClick listener) {
        super(context, listener);
        this.context = context;
    }

    @Override
    protected View createView(Context context, ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.row_activity_main_rv, viewGroup, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    protected void bindView(ResultsItem item, ViewHolder viewHolder) {
        if (item != null) {
            tvMovieName.setText(item.getOriginalTitle());
            tvReleaseDate.setText(item.getReleaseDate());
            tvAdult.setText(item.isAdult() ? "(A)" : "(U/A)");
            Picasso.with(context)
                    .load(Constants.URL_IMAGE_BASE + item.getPosterPath())
                    .into(civPosterImage);
        }
    }
}