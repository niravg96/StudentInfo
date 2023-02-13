package com.example.studentinfo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class ImageAdapter extends PagerAdapter
{

    Context mcontext;

    ImageAdapter(Context context)
    {
        this.mcontext = context;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public boolean isViewFromObject(@NonNull @androidx.annotation.NonNull View view, @NonNull @androidx.annotation.NonNull Object object) {
        return view == ((ImageView)object);
    }
    private int[] sliderImageId = new int[]{
            R.drawable.college,R.drawable.college2,R.drawable.college3,R.drawable.college4
    };
    public Object instantiateItem(ViewGroup container,int position){
        ImageView imageView = new ImageView((mcontext));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setImageResource(sliderImageId[position]);
        ((ViewPager)container).addView(imageView,0);
        return imageView;
    }
    public  void destroyItem(ViewGroup container,int position,Object object)
    {
        ((ViewPager)container).removeView((ImageView)object);
    }
}
