package com.jieleo.xmly_plus.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.jieleo.xmly_plus.R;

public class WebActivity extends BaseActivity {
    private WebView mWebViewActivityWeb;

    private String url;

    @Override
    protected int bindLayout() {
        return R.layout.activity_web;
    }

    @Override
    protected void initView() {
        mWebViewActivityWeb = (WebView) findViewById(R.id.web_view_activity_web);

    }

    @Override
    protected void initData() {
        url=getIntent().getStringExtra("url");
        Log.d("WebActivity", url);
        WebSettings webSettings=mWebViewActivityWeb.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mWebViewActivityWeb.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(url);
                return super.shouldOverrideUrlLoading(view, request);
            }
        });
        mWebViewActivityWeb.loadUrl(url);
    }

    @Override
    protected void bindEvent() {

    }

    @Override
    public void onClick(View v) {

    }
}
