package com.example.anyang.partymassworklistview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * 在android中，不能在一个拥有Scrollbar的组件中嵌入另一个拥有Scrollbar的组件，会发生滑动冲突
 * 导致嵌入的控件只显示一到两行数据，例如：listview嵌套gridview的场景
 * 解决方案：首先让子控件的内容全部显示出来，禁用它的滚动。如果超过了父控件的范围则显示父控件的scrollbar滚动显示内容
 * -----自定义GridView组件，继承自GridView，重载onMeasure方法，设置固定大小
 * Created by anyang on 2016/3/29.
 */
public class MyGridView extends GridView {

    public MyGridView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    public MyGridView(Context context) {
        super(context);
    }

    /**
     * 设置不滚动,显示所有
     */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
    {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);

    }
}
