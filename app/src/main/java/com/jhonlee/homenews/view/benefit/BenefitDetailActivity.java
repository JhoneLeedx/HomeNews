package com.jhonlee.homenews.view.benefit;

import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.jhonlee.homenews.R;
import com.kymjs.rxvolley.RxVolley;
import com.kymjs.rxvolley.client.HttpCallback;
import com.kymjs.rxvolley.client.ProgressListener;
import com.kymjs.rxvolley.http.VolleyError;
import com.kymjs.rxvolley.toolbox.FileUtils;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

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
    @OnClick({R.id.iv_preview_down,R.id.iv_preview_fav,R.id.iv_preview_menu,R.id.iv_preview_share,R.id.btn_set_wallpaper})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.iv_preview_share:
                //Constants.intentSystemShare(this, Constants.shareText);
                break;
            case R.id.iv_preview_fav:
                Toast.makeText(this, "喜欢", Toast.LENGTH_SHORT).show();
                break;
            case R.id.iv_preview_down:
                    downImg(mUrl);
                break;
            case R.id.iv_preview_menu:
                /*popWnd.showAtLocation(ll_bottom_bar, Gravity.BOTTOM
                        , ScreenUtils.getInstance(this).getScreenWidth() / 2
                        , 350);
                这里的350 应该按照View的思路 去进行测量，这里暂时未处理*/
                break;
            case R.id.btn_set_wallpaper:
                //dialog_setwallpaper.show();
                setDesktopWallpaper();
                break;
        }
    }

    private void downImg(String url){
        RxVolley.download(FileUtils.getSDCardPath() + "/LoveWallpaper/" + System.currentTimeMillis() + ".png"
                , url
                , new ProgressListener() {
                    @Override
                    public void onProgress(long transferredBytes, long totalSize) {

                    }
                }, new HttpCallback() {
                    @Override
                    public void onSuccess(String t) {
                        Toast.makeText(BenefitDetailActivity.this, "下载成功", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(VolleyError error) {
                        Toast.makeText(BenefitDetailActivity.this, "下载失败" + error.toString(), Toast.LENGTH_SHORT).show();
                        // L.i(error.toString());
                    }
                });
    }
    private WallpaperManager wpManager;
    //设置桌面壁纸
    private void setDesktopWallpaper() {
        //壁纸管理器
        wpManager = WallpaperManager.getInstance(this);
        Glide.with(this).load(mUrl).asBitmap().into(new SimpleTarget<Bitmap>() {
            @Override
            public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                try {
                    wpManager.setBitmap(resource);
                    Toast.makeText(BenefitDetailActivity.this, "桌面壁纸设置成功", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    Toast.makeText(BenefitDetailActivity.this, "桌面壁纸设置失败", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
