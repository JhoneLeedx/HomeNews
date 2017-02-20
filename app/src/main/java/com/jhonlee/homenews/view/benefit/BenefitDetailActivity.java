package com.jhonlee.homenews.view.benefit;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.jhonlee.homenews.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by JhoneLee on 2017/2/20.
 */
public class BenefitDetailActivity extends AppCompatActivity{

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.image_detail)
    ImageView mImg;

    private String mUrl;
    private String author;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_benefit_detail);
        ButterKnife.bind(this);
        author = getIntent().getStringExtra("author");
        toolbar.setTitle(author);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//返回按钮
        mUrl = getIntent().getStringExtra("url");
        Glide.with(this).load(mUrl).into(mImg);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
