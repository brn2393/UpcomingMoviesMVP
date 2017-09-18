package com.buddhabhushan.b.mobisysassignment.domain.adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.buddhabhushan.b.mobisysassignment.R;
import com.buddhabhushan.b.mobisysassignment.data.models.PostersItem;
import com.buddhabhushan.b.mobisysassignment.domain.Constants;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by B on 18-09-2017.
 */

public class CustomPagerAdapter extends PagerAdapter {
    Context context;
    ArrayList<PostersItem> list;
    LayoutInflater layoutInflater;


    public CustomPagerAdapter(Context context, ArrayList<PostersItem> list) {
        this.context = context;
        this.list = list;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        View itemView = layoutInflater.inflate(R.layout.item_posters_pager, container, false);

        ImageView imageView = (ImageView) itemView.findViewById(R.id.item_image);

        Picasso.with(context)
                .load(Constants.URL_IMAGE_BASE + list.get(position).getFilePath())
                .into(imageView);

        container.addView(itemView);

        //listening to image click
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(context, "you clicked image " + (position + 1), Toast.LENGTH_LONG).show();
            }
        });

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}