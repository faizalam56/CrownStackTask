package com.crownstack.task;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;


import com.crownstack.task.databinding.DetailBinding;
import com.crownstack.task.utility.ViewModel;

public class DetailsActivity extends AppCompatActivity {

    private DetailBinding datailBinding;
    private ViewModel viewModel;
    private ProgressBar progressBar;
    private WebView webView;
    private String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        datailBinding = DataBindingUtil.setContentView(this,R.layout.activity_details);
        datailBinding.executePendingBindings();
        viewModel = new ViewModel();
        viewModel.setDialogVisibility(true);
        datailBinding.setDvm(viewModel);

        url = getIntent().getExtras().getString("url");
        init();
    }

    private void init(){

        webView = (WebView) findViewById(R.id.webview);

        WebSettings webSetting = webView.getSettings();
        webSetting.setJavaScriptEnabled(true);
        webSetting.setDisplayZoomControls(true);
        webView.loadUrl(url);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                viewModel.setDialogVisibility(false);
            }
        });
    }
}
