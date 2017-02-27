package com.jhonlee.homenews.view.send;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Toast;


import com.jhonlee.homenews.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by JhoneLee on 2017/2/23.
 */

public class WebViewActivity extends AppCompatActivity {

    @BindView(R.id.webview)
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        ButterKnife.bind(this);


        webView.setVerticalScrollbarOverlay(true);
        //设置WebView支持JavaScript
        webView.getSettings().setJavaScriptEnabled(true);

        String url = "http://121.42.179.52/wx/test.jsp";
        webView.loadUrl(url);

        //在js中调用本地java方法
        webView.addJavascriptInterface(new JsInterface(this), "AndroidWebView");
        //添加客户端支持
        webView.setWebChromeClient(new WebChromeClient());


    }
    private class JsInterface {
        private Context mContext;

        public JsInterface(Context context) {
            this.mContext = context;
        }

        //在js中调用window.AndroidWebView.showInfoFromJs(name)，便会触发此方法。
        @JavascriptInterface
        public void showInfoFromJs(String name) {
            Toast.makeText(mContext, name, Toast.LENGTH_SHORT).show();
        }
    }

    //在java中调用js代码
    @OnClick(R.id.btn_send)
    public void sendInfoToJs() {
        String msg = "通话时间为...";
        //调用js中的函数：showInfoFromJava(msg)
        webView.loadUrl("javascript:showInfoFromJava('"+msg+"')");
    }
}
