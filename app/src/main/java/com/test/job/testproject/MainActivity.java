package com.test.job.testproject;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.nfc.Tag;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.facebook.FacebookSdk;
import com.facebook.applinks.AppLinkData;

import bolts.AppLinks;

public class MainActivity extends AppCompatActivity {
    WebView webView;
    private SharedPreferences preferences;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.setAcceptCookie(true);
        webView = new WebView(this);
        setContentView(webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebClient());
        webView.loadUrl("http://github.com");
        AppLinkData.fetchDeferredAppLinkData(this, new AppLinkData.CompletionHandler() {
                    @Override
                    public void onDeferredAppLinkDataFetched(AppLinkData appLinkData) {

                        preferences = getPreferences(Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = preferences.edit();

                        try {
                            if (appLinkData.getTargetUri().getQueryParameter("source") != null && !appLinkData.getTargetUri().getQueryParameter("source").isEmpty()) {
                                editor.putString("source", appLinkData.getTargetUri().getQueryParameter("source"));
                                editor.apply();
                                editor.commit();
                            }
                            if (appLinkData.getTargetUri().getQueryParameter("campaign") != null && !appLinkData.getTargetUri().getQueryParameter("campaign").isEmpty()) {
                                editor.putString("campaign", appLinkData.getTargetUri().getQueryParameter("campaign"));
                                editor.apply();
                                editor.commit();
                            }
                            if (appLinkData.getTargetUri().getQueryParameter("ad") != null && !appLinkData.getTargetUri().getQueryParameter("ad").isEmpty()) {
                                editor.putString("ad", appLinkData.getTargetUri().getQueryParameter("ad"));
                                editor.apply();
                                editor.commit();
                            }
                            if (appLinkData.getTargetUri().getQueryParameter("pid") != null && !appLinkData.getTargetUri().getQueryParameter("pid").isEmpty()) {
                                editor.putString("pid", appLinkData.getTargetUri().getQueryParameter("pid"));
                                editor.apply();
                                editor.commit();
                            }
                            if (appLinkData.getTargetUri().getQueryParameter("sub1") != null && !appLinkData.getTargetUri().getQueryParameter("sub1").isEmpty()) {
                                editor.putString("sub1", appLinkData.getTargetUri().getQueryParameter("sub1"));
                                editor.apply();
                                editor.commit();
                            }
                            if (appLinkData.getTargetUri().getQueryParameter("sub2") != null && !appLinkData.getTargetUri().getQueryParameter("sub2").isEmpty()) {
                                editor.putString("sub2", appLinkData.getTargetUri().getQueryParameter("sub2"));
                                editor.apply();
                                editor.commit();
                            }
                            if (appLinkData.getTargetUri().getQueryParameter("sub3") != null && !appLinkData.getTargetUri().getQueryParameter("sub3").isEmpty()) {
                                editor.putString("sub3", appLinkData.getTargetUri().getQueryParameter("sub3"));
                                editor.apply();
                                editor.commit();
                            }
                            if (appLinkData.getTargetUri().getQueryParameter("sub4") != null && !appLinkData.getTargetUri().getQueryParameter("sub4").isEmpty()) {
                                editor.putString("sub4", appLinkData.getTargetUri().getQueryParameter("sub4"));
                                editor.apply();
                                editor.commit();
                            }
                            if (appLinkData.getTargetUri().getQueryParameter("sub5") != null && !appLinkData.getTargetUri().getQueryParameter("sub5").isEmpty()) {
                                editor.putString("sub5", appLinkData.getTargetUri().getQueryParameter("sub5"));
                                editor.apply();
                                editor.commit();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        try {
                            if (preferences.getString("source", "organic").equals("organic") && bolts.AppLinks.getTargetUrlFromInboundIntent(MainActivity.this, getIntent()).getQueryParameter("source") != null && !bolts.AppLinks.getTargetUrlFromInboundIntent(MainActivity.this, getIntent()).getQueryParameter("source").isEmpty()) {
                                editor.putString("source", bolts.AppLinks.getTargetUrlFromInboundIntent(MainActivity.this, getIntent()).getQueryParameter("source"));
                                editor.apply();
                                editor.commit();
                            }
                            if (preferences.getString("campaign", "").isEmpty() && bolts.AppLinks.getTargetUrlFromInboundIntent(MainActivity.this, getIntent()).getQueryParameter("campaign") != null && !AppLinks.getTargetUrlFromInboundIntent(MainActivity.this, getIntent()).getQueryParameter("campaign").isEmpty()) {
                                editor.putString("campaign", AppLinks.getTargetUrlFromInboundIntent(MainActivity.this, getIntent()).getQueryParameter("campaign"));
                                editor.apply();
                                editor.commit();
                            }
                            if (preferences.getString("ad", "").isEmpty() && AppLinks.getTargetUrlFromInboundIntent(MainActivity.this, getIntent()).getQueryParameter("ad") != null && !AppLinks.getTargetUrlFromInboundIntent(MainActivity.this, getIntent()).getQueryParameter("ad").isEmpty()) {
                                editor.putString("ad", AppLinks.getTargetUrlFromInboundIntent(MainActivity.this, getIntent()).getQueryParameter("ad"));
                                editor.apply();
                                editor.commit();
                            }
                            if (preferences.getString("pid", "1").equals("1") && AppLinks.getTargetUrlFromInboundIntent(MainActivity.this, getIntent()).getQueryParameter("pid") != null && !AppLinks.getTargetUrlFromInboundIntent(MainActivity.this, getIntent()).getQueryParameter("pid").isEmpty()) {
                                editor.putString("pid", AppLinks.getTargetUrlFromInboundIntent(MainActivity.this, getIntent()).getQueryParameter("pid"));
                                editor.apply();
                                editor.commit();
                            }
                            if (preferences.getString("sub1", "").isEmpty() && AppLinks.getTargetUrlFromInboundIntent(MainActivity.this, getIntent()).getQueryParameter("sub1") != null && !AppLinks.getTargetUrlFromInboundIntent(MainActivity.this, getIntent()).getQueryParameter("sub1").isEmpty()) {
                                editor.putString("sub1", AppLinks.getTargetUrlFromInboundIntent(MainActivity.this, getIntent()).getQueryParameter("sub1"));
                                editor.apply();
                                editor.commit();
                            }
                            if (preferences.getString("sub2", "").isEmpty() && AppLinks.getTargetUrlFromInboundIntent(MainActivity.this, getIntent()).getQueryParameter("sub2") != null && !AppLinks.getTargetUrlFromInboundIntent(MainActivity.this, getIntent()).getQueryParameter("sub2").isEmpty()) {
                                editor.putString("sub2", AppLinks.getTargetUrlFromInboundIntent(MainActivity.this, getIntent()).getQueryParameter("sub2"));
                                editor.apply();
                                editor.commit();
                            }
                            if (preferences.getString("sub3", "").isEmpty() && AppLinks.getTargetUrlFromInboundIntent(MainActivity.this, getIntent()).getQueryParameter("sub3") != null && !AppLinks.getTargetUrlFromInboundIntent(MainActivity.this, getIntent()).getQueryParameter("sub3").isEmpty()) {
                                editor.putString("sub3", AppLinks.getTargetUrlFromInboundIntent(MainActivity.this, getIntent()).getQueryParameter("sub3"));
                                editor.apply();
                                editor.commit();
                            }
                            if (preferences.getString("sub4", "").isEmpty() && AppLinks.getTargetUrlFromInboundIntent(MainActivity.this, getIntent()).getQueryParameter("sub4") != null && !AppLinks.getTargetUrlFromInboundIntent(MainActivity.this, getIntent()).getQueryParameter("sub4").isEmpty()) {
                                editor.putString("sub4", AppLinks.getTargetUrlFromInboundIntent(MainActivity.this, getIntent()).getQueryParameter("sub4"));
                                editor.apply();
                                editor.commit();
                            }
                            if (preferences.getString("sub5", "").isEmpty() && AppLinks.getTargetUrlFromInboundIntent(MainActivity.this, getIntent()).getQueryParameter("sub5") != null && !AppLinks.getTargetUrlFromInboundIntent(MainActivity.this, getIntent()).getQueryParameter("sub5").isEmpty()) {
                                editor.putString("sub5", AppLinks.getTargetUrlFromInboundIntent(MainActivity.this, getIntent()).getQueryParameter("sub5"));
                                editor.apply();
                                editor.commit();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            java.lang.System.out.println("NOOOO");
                        }


                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                webView.loadUrl("http://newmobads.com/www/app/slot/template/index.html?os=android&bundle=" + getPackageName() + "&source=" + preferences.getString("source", "organic") + "&campaign=" + preferences.getString("campaign", "") + "&ad=" + preferences.getString("ad", "") + "&pid=" + preferences.getString("pid", "1") + "&sub1=" + preferences.getString("sub1", "") + "&sub2=" + preferences.getString("sub2", "") + "&sub3=" + preferences.getString("sub3", "") + "&sub4=" + preferences.getString("sub4", "") + "&sub5=" + preferences.getString("sub5", ""));
                                Log.i("TAG", webView.getUrl());
                            }
                        });
                    }
                }
        );


    }

    @Override
    public void onBackPressed() {
        if(webView.canGoBack()){
            webView.goBack();
        }else {
            super.onBackPressed();
        }
    }
}
