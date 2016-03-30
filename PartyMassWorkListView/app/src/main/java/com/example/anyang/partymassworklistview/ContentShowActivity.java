package com.example.anyang.partymassworklistview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.anyang.partymassworklistview.entity.News;

public class ContentShowActivity extends AppCompatActivity {

    private News news;
    private int index;

    private TextView title;
    private ImageView image;
    private TextView content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_show);

        Intent intent = getIntent();
        index = intent.getIntExtra("index", 0);

        news = new News();

        title = (TextView)findViewById(R.id.textview_title);
        image = (ImageView)findViewById(R.id.imageview_image);
        content = (TextView)findViewById(R.id.textview_content);

        title.setText(news.getTitle(index));
        image.setImageResource(news.getImage(index));
        content.setText(news.getConten(index));
    }
}
