package com.example.anyang.partymassworklistview.utils;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.example.anyang.partymassworklistview.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 填充ViewPager页面的适配器
 * Created by anyang on 2016/3/29.
 */
public class ViewPagerAdapter extends PagerAdapter {
    private List<ImageView> imageViews; // 滑动的图片集合
    private int[] imageResId; // 图片ID
    private String[] titles; // 图片标题
    private Context context;

    public ViewPagerAdapter(Context context){
        this.context = context;
        imageResId = new int[] {R.drawable.viewpager_image_0, R.drawable.viewpager_image_1, R.drawable.viewpager_image_2};
        titles = new String[imageResId.length];
        titles[0] = "攻坚克难，振奋精神，全力实现“十三五”良好开局";
        titles[1] = "对标“五大”发展理念，聚焦“五个”创新作为";
        titles[2] = "国家发改委到我市督导专项建设基金实施工作";
        imageViews = new ArrayList<ImageView>();
        // 初始化图片资源
        for (int i = 0; i < imageResId.length; i++) {
            ImageView imageView = new ImageView(context);
            imageView.setImageResource(imageResId[i]);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageViews.add(imageView);
        }
    }

    public String getTitle(int index){
        return titles[index];
    }

    public int getImageViews(){
        return imageViews.size();
    }

    @Override
    public int getCount() {
        return imageResId.length;
    }
    @Override
    public Object instantiateItem(View arg0, int arg1) {
        ((ViewPager)arg0).addView(imageViews.get(arg1));
        return imageViews.get(arg1);
    }
    @Override
    public void destroyItem(View arg0, int arg1, Object arg2) {
        ((ViewPager)arg0).removeView((View) arg2);
    }
    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0 == arg1;
    }
    @Override
    public int getItemPosition(Object object){
        return POSITION_NONE;
    }


}
