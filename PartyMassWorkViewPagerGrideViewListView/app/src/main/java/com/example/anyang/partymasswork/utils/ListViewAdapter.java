package com.example.anyang.partymasswork.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.anyang.partymasswork.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by anyang on 2016/3/22.
 */
public class ListViewAdapter extends BaseAdapter {
    // ListView内容控件
    private List<String> titles;
    private List<Integer> icons;
    private LayoutInflater inflater;
    private SimpleDateFormat format;

    public ListViewAdapter(Context context, List<String> titles, List<Integer> icons) {
        this.titles = titles;
        this.icons = icons;
        inflater = LayoutInflater.from(context);
        format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }

    @Override
    public int getCount() {
        return titles.size();
    }

    @Override
    public Object getItem(int position) {
        return titles.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if(convertView == null) {
            holder = new ViewHolder();
            // 通过LayoutInflater实例化布局
            convertView = inflater.inflate(R.layout.listview_item, null);
            holder.imageview = (ImageView)convertView.findViewById(R.id.imageview_photo);
            holder.textView_title = (TextView)convertView.findViewById(R.id.textview_title);
            holder.textView_time = (TextView)convertView.findViewById(R.id.textview_time);
            convertView.setTag(holder);
        } else {
            // 通过Tag找到缓存的布局
            holder = (ViewHolder)convertView.getTag();
        }
        // 设置布局中控件要显示的视图
        holder.imageview.setImageResource(icons.get(position));
        holder.textView_title.setText(titles.get(position));
        holder.textView_time.setText(format.format(new Date()));
        return convertView;
    }

    public final class ViewHolder {
        public ImageView imageview;
        public TextView textView_title;
        public TextView textView_time;
    }
}
