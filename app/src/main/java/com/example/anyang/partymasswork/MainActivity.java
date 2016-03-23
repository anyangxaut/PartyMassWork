package com.example.anyang.partymasswork;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.anyang.partymasswork.entity.News;
import com.example.anyang.partymasswork.utils.GrideViewAdapter;
import com.example.anyang.partymasswork.utils.ListViewAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    // ViewPager相关
    private ViewPager viewPager; // android-support-v4中的滑动组件
    private TextView title_tv; // 图片标题显示控件
    private List<ImageView> imageViews; // 滑动的图片集合
    private List<View> dots; // 图片标题下面的点
    private String[] titles; // 图片标题
    private int[] imageResId; // 图片ID
    private int currentItem = 0; // 当前图片的索引号
    private ScheduledExecutorService scheduledExecutorService; // 定时执行页面切换

    // GrideView相关
    private GridView gridview;
    private GrideViewAdapter adapter;
    private int[] icons;
    private String[] items;

    // ListView相关
    private ListView listView = null;
    private News news;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // ViewPager内容填充
        imageResId = new int[] {R.drawable.viewpager_image_0, R.drawable.viewpager_image_1, R.drawable.viewpager_image_2};
        titles = new String[imageResId.length];
        titles[0] = "攻坚克难，振奋精神，全力实现“十三五”良好开局";
        titles[1] = "对标“五大”发展理念，聚焦“五个”创新作为";
        titles[2] = "国家发改委到我市督导专项建设基金实施工作";
        imageViews = new ArrayList<ImageView>();
        // 初始化图片资源
        for (int i = 0; i < imageResId.length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(imageResId[i]);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageViews.add(imageView);
        }
        dots = new ArrayList<View>();
        dots.add(findViewById(R.id.v_dot0));
        dots.add(findViewById(R.id.v_dot1));
        dots.add(findViewById(R.id.v_dot2));
        title_tv = (TextView)findViewById(R.id.title_tv);
        title_tv.setText(titles[0]);//
        viewPager = (ViewPager)findViewById(R.id.viewpager_images);
        viewPager.setAdapter(new ViewPagerAdapter());// 设置填充ViewPager页面的适配器
        // 设置一个监听器，当ViewPager中的页面改变时调用
        viewPager.setOnPageChangeListener(new MyPageChangeListener());

        // GrideView内容填充
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
        adapter = new GrideViewAdapter(this, items, icons);
        gridview = (GridView)findViewById(R.id.gridview_items);
        gridview.setAdapter(adapter);

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                Intent intent = new Intent(MainActivity.this, ContentListActivity.class);
                startActivity(intent);
            }
        });

        // ListView内容填充
        listView = (ListView)findViewById(R.id.listview_news);
        news = new News();
        listView.setAdapter(new ListViewAdapter(this, news.getTitles(), news.getImages()));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, ContentShowActivity.class);
                intent.putExtra("index", position);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // ActionBar菜单选项
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Actionbar点击事件
        int id = item.getItemId();
        // 特定菜单处理
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // 处理导航栏点击事件
        int id = item.getItemId();

        if (id == R.id.nav_menu_0) {

        } else {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
        }

//        } else if (id == R.id.nav_menu_1) {
//
//
//        } else if (id == R.id.nav_menu_2) {
//
//        } else if (id == R.id.nav_menu_3) {
//
//        } else if (id == R.id.nav_menu_4) {
//
//        } else if (id == R.id.nav_menu_5) {
//
//        } else if (id == R.id.nav_menu_6) {
//
//        } else if (id == R.id.nav_menu_7) {
//
//        } else if (id == R.id.nav_menu_8) {
//
//        } else if (id == R.id.nav_menu_9) {
//
//        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    // 切换当前显示的图片
    private Handler handler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            viewPager.setCurrentItem(currentItem);// 切换当前显示的图片
        };
    };

    /**
     * 切换图片的任务线程
     */
    private class ScrollTask implements Runnable {
        public void run() {
            synchronized (viewPager) {
                currentItem = (currentItem + 1) % imageViews.size();
                handler.obtainMessage().sendToTarget(); // 通过Handler切换图片
            }
        }
    }

    /**
     * 当ViewPager中页面的状态发生改变时调用
     */
    private class MyPageChangeListener implements OnPageChangeListener {
        private int oldPosition = 0;
        /**
         * 当ViewPager中一个新的图片被选择的时候，该方法会被回调
         * 参数position是新选中图片的索引号
         */
        public void onPageSelected(int position) {
            currentItem = position;
            title_tv.setText(titles[position]);
            dots.get(oldPosition).setBackgroundResource(R.drawable.dot_normal);
            dots.get(position).setBackgroundResource(R.drawable.dot_focused);
            oldPosition = position;
        }
        public void onPageScrollStateChanged(int arg0) {

        }
        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }
    }

    /**
     * 填充ViewPager页面的适配器
     */
    private class ViewPagerAdapter extends PagerAdapter {
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
            ((ViewPager)arg0).removeView((View)arg2);
        }
        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;
        }
    }

    @Override
    protected void onStart() {
        // 按指定频率周期执行某个任务
        // 只有一个线程的线程池，因此所有提交的任务是顺序执行
        scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        // 当Activity显示出来后，每3秒钟切换一次图片显示
        /**
         * new ScrollTask()：执行线程
         * 1：初始化延时
         * 3：两次开始执行最小间隔时间
         * TimeUnit.SECONDS:计时单位
         */
        scheduledExecutorService.scheduleAtFixedRate(new ScrollTask(), 1, 3, TimeUnit.SECONDS);
        super.onStart();
    }

    @Override
    protected void onStop() {
        // 当Activity不可见的时候停止切换
        scheduledExecutorService.shutdown();
        super.onStop();
    }

}
