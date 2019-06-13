package com.jiyuns.alatan_kaoshi.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.jiyuns.alatan_kaoshi.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BFragment extends Fragment {


    private View view;
    private WebView mWebView;

    public BFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_b, container, false);
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        mWebView = (WebView) inflate.findViewById(R.id.webView);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.loadUrl("https://www.baidu.com/");
    }
}
