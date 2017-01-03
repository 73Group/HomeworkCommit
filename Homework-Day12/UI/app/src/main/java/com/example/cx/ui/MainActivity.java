package com.example.cx.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends Activity {

    private RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        rv = new RecyclerView(this);
        setContentView(R.layout.activity_main);
        //把rv作为Activity的内容布局
        rv = (RecyclerView) findViewById(R.id.list);
        //设置布局，使用线性布局
        rv.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        rv.setAdapter(new MyAdapter());

    }
}
