package com.example.anyang.partymassworklistview.utils;

import android.content.Context;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.anyang.partymassworklistview.R;

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

    public GrideViewAdapter(Context context)
    {
        inflater = LayoutInflater.from(context);
        icons = new int[] { R.drawable.icon_home_1, R.drawable.icon_home_2, R.drawable.icon_home_3, R.drawable.icon_home_4,
                R.drawable.icon_home_5, R.drawable.icon_home_6, R.drawable.icon_home_7, R.drawable.icon_home_8,
                R.drawable.icon_home_9, R.drawable.icon_home_10};
        items = new String[icons.length];
        items[0] = "时事";
        items[1] = "工委动态";
        items[2] = "组织工作";
        items[3] = "宣传工作";
        items[4] = "党建研究";
        items[5] = "纪检工作";
        items[6] = "机关工会";
        items[7] = "机关青年";
        items[8] = "机关妇女";
        items[9] = "网上党校";
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


