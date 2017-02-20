package com.jhonlee.homenews.view.news;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.jhonlee.homenews.R;


import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lijin on 2017/2/18.
 */

public class NewsDetailActivity extends AppCompatActivity {

    @BindView(R.id.webview)
    WebView mView;
    @BindView(R.id.loading)
    protected ProgressBar mLoading;
    @BindView(R.id.iv_news_detail)
    ImageView ivnews;
    @BindView(R.id.toolbar_newsDetail)
    Toolbar mToolbar;

    private String mUrl;
    private String mImgUrl;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newsdetail);
        ButterKnife.bind(this);
        mToolbar.setTitle("");
        initView();
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//返回按钮
       // initWebViewSettings(mView);
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    private void initWebViewSettings(WebView webView) {
        //能够和js交互
        webView.getSettings().setJavaScriptEnabled(true);
        //缩放,设置为不能缩放可以防止页面上出现放大和缩小的图标
        webView.getSettings().setBuiltInZoomControls(false);
        //缓存
        webView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        //开启DOM storage API功能
        webView.getSettings().setDomStorageEnabled(true);
        //开启application Cache功能
        webView.getSettings().setAppCacheEnabled(false);
    }
    private void initView(){
        mUrl = getIntent().getStringExtra("url");
        mImgUrl = getIntent().getStringExtra("imgurl");
        Glide.with(this).load(mImgUrl).into(ivnews);
        mView.loadUrl(mUrl);
        mView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        mView.getSettings().setUseWideViewPort(true);
        mView.getSettings().setLoadWithOverviewMode(true);

        mView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                mToolbar.setTitle(mView.getTitle());
                if (newProgress == 100) {
                    //加载完网页进度条消失
                    mLoading.setVisibility(View.GONE);

                } else {
                    //开始加载网页时显示进度条
                    mLoading.setVisibility(View.VISIBLE);
                    //设置进度值
                }



            }

    /*        @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
                int currentapiVersion=android.os.Build.VERSION.SDK_INT;
                  //  mToolbar.setTitle(title);
            }*/
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_browser, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode==KeyEvent.KEYCODE_BACK&&mView.canGoBack()){
            mView.goBack();
            return true;
        }else {
            return super.onKeyDown(keyCode, event);
        }
    }
}
