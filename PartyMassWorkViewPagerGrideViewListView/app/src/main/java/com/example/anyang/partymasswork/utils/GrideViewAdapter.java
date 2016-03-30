package com.example.anyang.partymasswork.utils;

import android.content.Context;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.anyang.partymasswork.R;

import java.util.zip.Inflater;

/**
 * 自定义GrideViewAdapter
 * @author anyang
 *
 */
public class GrideViewAdapter extends BaseAdapter {
    //  图标、文字显示
    private String[] items;
    private int[] icons;
    private LayoutInflater inflater;

    public GrideViewAdapter(Context context, String[] items, int[] icons)
    {
        inflater = LayoutInflater.from(context);
        this.items = items;
        this.icons = icons;
    }

    public int getCount()
    {
        return items.length;
    }

    public Object getItem(int arg0)
    {
        return items[arg0];
    }

    public long getItemId(int position)
    {
        return position;
    }

    /**
     * 获得 LayoutInflater 实例的三种方式：
     * 1. LayoutInflater inflater = getLayoutInflater();  //调用Activity的getLayoutInflater()
     2. LayoutInflater localinflater =  (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
     3. LayoutInflater inflater = LayoutInflater.from(context);所以这三种方式最终本质是都是调用的Context.getSystemService().
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder hodler = null;
        // 判断是否缓存
        if(convertView == null) {
            hodler = new ViewHolder();
            // 通过layoutInflater实例化布局
            convertView = (View)inflater.inflate(R.layout.grideview_item, null);
            hodler.imageview = (ImageView)convertView.findViewById(R.id.imageview_item);
            hodler.textView = (TextView)convertView.findViewById(R.id.textview_item);
            convertView.setTag(hodler);
        } else {
            // 通过Tag找到缓存布局
            hodler = (ViewHolder)convertView.getTag();
        }
        // 设置布局中控件要显示的视图
        hodler.imageview.setImageResource(icons[position]);
        hodler.textView.setText(items[position]);
        return convertView;
    }

    public final class ViewHolder {
        public ImageView imageview;
        public TextView textView;
    }
}


