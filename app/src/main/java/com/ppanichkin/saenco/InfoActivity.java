package com.ppanichkin.saenco;


import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class InfoActivity extends AppCompatActivity {
    private WebView webView = null;
    private Button button;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        WebView webView = (WebView) findViewById(R.id.webview);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView webView, String url) {
                // все ссылки, в которых содержится домен
                // будут открываться внутри приложения
                if (url.contains("saenco.ru")) {
                    return false;
                }
                // все остальные ссылки будут спрашивать какой браузер открывать
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                InfoActivity.this.startActivity(intent);
                return true;
            }
        });
          webView.loadUrl("https://www.saenco.ru");
    }


}

