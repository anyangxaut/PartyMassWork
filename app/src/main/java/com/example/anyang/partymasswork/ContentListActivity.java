package com.example.anyang.partymasswork;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.anyang.partymasswork.entity.News;
import com.example.anyang.partymasswork.utils.ListViewAdapter;

public class ContentListActivity extends AppCompatActivity {
    // ListView相关
    private ListView listView = null;
    private News news;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_list);

        // ListView内容填充
        listView = (ListView)findViewById(R.id.listview_contents);
        news = new News();
        listView.setAdapter(new ListViewAdapter(this, news.getTitles(), news.getImages()));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ContentListActivity.this, ContentShowActivity.class);
                intent.putExtra("index", position);
                startActivity(intent);
            }
        });
    }
}
