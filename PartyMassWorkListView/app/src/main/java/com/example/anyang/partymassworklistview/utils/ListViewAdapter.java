package com.example.anyang.partymassworklistview.utils;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.anyang.partymassworklistview.ContentListActivity;
import com.example.anyang.partymassworklistview.MyGridView;
import com.example.anyang.partymassworklistview.R;
import com.example.anyang.partymassworklistview.entity.News;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by anyang on 2016/3/22.
 */
public class ListViewAdapter extends BaseAdapter {
    // ListView内容控件
    private News news = null;
    private LayoutInflater inflater;
    private SimpleDateFormat format;
    private Context context = null;

    // ViewPager
    private List<View> dots; // 图片标题下面的点
    private int currentItem = 0; // 当前图片的索引号
    private int oldPosition = 0;
    private ViewPagerAdapter viewPagerAdapter;

    private ListViewViewHolder listViewViewHolder = null;
    private ViewPagerViewHolder viewPagerViewHolder = null;
    private GrideViewViewHolder grideViewViewHolder = null;

    public ListViewAdapter(Context context) {
        this.context = context;
        news = new News();
        inflater = LayoutInflater.from(context);
        format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        viewPagerAdapter = new ViewPagerAdapter(context);
    }

    @Override
    public int getCount() {
        return (news.getSize() + 2);
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        int type = 0;
        if(position == 0) {
            type = 0;
        } else if(position == 1) {
            type = 1;
        } else {
            type = 2;
        }
        return type;
    }

    @Override
    public int getViewTypeCount() {
        return 3;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            if(position == 0) {
                // ViewPager
                viewPagerViewHolder = new ViewPagerViewHolder();
                // 通过LayoutInflater实例化布局
                convertView = inflater.inflate(R.layout.viewpager, null);
                viewPagerViewHolder.viewPager = (ViewPager)convertView.findViewById(R.id.viewpager_images);
                viewPagerViewHolder.dot0 = convertView.findViewById(R.id.dot0);
                viewPagerViewHolder.dot1 = convertView.findViewById(R.id.dot1);
                viewPagerViewHolder.dot2 = convertView.findViewById(R.id.dot2);
                viewPagerViewHolder.textView = (TextView)convertView.findViewById(R.id.title_textview);
                dots = new ArrayList<View>();
                dots.add(viewPagerViewHolder.dot0);
                dots.add(viewPagerViewHolder.dot1);
                dots.add(viewPagerViewHolder.dot2);
                convertView.setTag(viewPagerViewHolder);
                viewPagerViewHolder.viewPager.setAdapter(viewPagerAdapter);// 设置填充ViewPager页面的适配器
                // 设置一个监听器，当ViewPager中的页面改变时调用
                viewPagerViewHolder.viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

                    @Override
                    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                    }

                    @Override
                    public void onPageSelected(int position) {
                        currentItem = position;
                        viewPagerViewHolder.textView.setText(viewPagerAdapter.getTitle(position));
                        Log.d("hahhahahaa", "position:" + position + ",oldPosition:" + oldPosition);
                        dots.get(oldPosition).setBackgroundResource(R.drawable.dot_normal);
                        dots.get(position).setBackgroundResource(R.drawable.dot_focused);
                        notifyDataSetInvalidated();
//                    Toast.makeText(context,"position:" + position, Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onPageScrollStateChanged(int state) {

                    }
                });
            } else if(position == 1) {
                grideViewViewHolder = new GrideViewViewHolder();
                // 通过LayoutInflater实例化布局
                convertView = inflater.inflate(R.layout.grideview, null);
                grideViewViewHolder.gridView = (MyGridView)convertView.findViewById(R.id.gridview_items);
                convertView.setTag(grideViewViewHolder);
            } else {
                // ListView
                listViewViewHolder = new ListViewViewHolder();
                // 通过LayoutInflater实例化布局
                convertView = inflater.inflate(R.layout.listview_item, null);
                listViewViewHolder.imageview = (ImageView)convertView.findViewById(R.id.imageview_image);
                listViewViewHolder.textView_title = (TextView)convertView.findViewById(R.id.textview_title);
                listViewViewHolder.textView_time = (TextView)convertView.findViewById(R.id.textview_time);
                convertView.setTag(listViewViewHolder);
            }
        } else {
            // 通过Tag找到缓存的布局
            if(position == 0) {
                // ViewPager
                viewPagerViewHolder = (ViewPagerViewHolder) convertView.getTag();
            } else if(position == 1) {
                // GrideView
                grideViewViewHolder = (GrideViewViewHolder) convertView.getTag();
            } else {
                // ListView
                listViewViewHolder = (ListViewViewHolder) convertView.getTag();
            }
        }
        // 设置布局中控件要显示的视图
        if(position == 0) {
            // ViewPager
            viewPagerViewHolder.textView.setText(viewPagerAdapter.getTitle(currentItem));
            dots.get(oldPosition).setBackgroundResource(R.drawable.dot_normal);
            dots.get(currentItem).setBackgroundResource(R.drawable.dot_focused);
            Log.d("wuwuuwuwuwuw", "oldPosition:" + oldPosition + ",currentItem:" + currentItem);
            oldPosition = currentItem;
            // 当Activity显示出来后，每3秒钟切换一次ViewPager图片显示
//            final ViewPagerViewHolder finalViewPagerViewHolder = viewPagerViewHolder;
//            // 切换当前显示的图片
//            final Handler handler = new Handler() {
//                public void handleMessage(android.os.Message msg) {
//                    finalViewPagerViewHolder.viewPager.setCurrentItem(currentItem);// 切换当前显示的图片
//                };
//            };
//            new Timer().schedule(new TimerTask() {
//                @Override
//                public void run() {
//                    synchronized (finalViewPagerViewHolder.viewPager) {
//                        currentItem = (currentItem + 1) % viewPagerAdapter.getImageViews();
//                        handler.obtainMessage().sendToTarget(); // 通过Handler切换图片
//                    }
//                }
//            }, 2000, 5000);
        } else if(position == 1) {
            // GrideView
            if (grideViewViewHolder.gridView != null) {
                GrideViewAdapter gridViewAdapter = new GrideViewAdapter(context);
                grideViewViewHolder.gridView.setAdapter(gridViewAdapter);
                grideViewViewHolder.gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                            long arg3) {
                        Intent intent = new Intent(context, ContentListActivity.class);
                        context.startActivity(intent);
                    }
                });
            }
        } else {
            // ListView
            listViewViewHolder.imageview.setImageResource(news.getImage(position - 2));
            listViewViewHolder.textView_title.setText(news.getTitle(position - 2));
            listViewViewHolder.textView_time.setText(format.format(new Date()));
        }
        return convertView;
    }

    // ListView
    public final class ListViewViewHolder {
        public ImageView imageview;
        public TextView textView_title;
        public TextView textView_time;
    }

    // ViewPager
    public final class ViewPagerViewHolder {
        public ViewPager viewPager;
        public View dot0;
        public View dot1;
        public View dot2;
        public TextView textView; // 图片标题显示控件
    }

    // GrideView
    public final class GrideViewViewHolder {
        public MyGridView gridView;
    }
}
