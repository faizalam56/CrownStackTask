package com.crownstack.task.utility;

import android.databinding.BindingAdapter;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.BitmapImageViewTarget;

import java.util.concurrent.TimeUnit;

public class BindingUtil {
    @BindingAdapter("bind:imageUrl")
    public static void loadImage(ImageView view, String imageUrl) {

        Glide.with(view.getContext()).load(imageUrl).asBitmap().centerCrop().into(new BitmapImageViewTarget(view) {
            @Override
            protected void setResource(Bitmap resource) {
                RoundedBitmapDrawable circularBitmapDrawable =
                        RoundedBitmapDrawableFactory.create(view.getContext().getResources(), resource);
                circularBitmapDrawable.setCircular(true);
                view.setImageDrawable(circularBitmapDrawable);
            }
        });
    }


    @BindingAdapter("android:text")
    public static void setText(TextView textView, long millis) {

        long minutes = (millis / 1000) / 60;
        int seconds = (int)((millis / 1000) % 60);
        textView.setText(""+minutes+":"+seconds);
    }

}
