package com.gelo.ceuapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.internal.BottomNavigationItemView;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ceuonlineportals extends Fragment {

    Animation animAlpha;
    private BottomNavigationItemView mainsite, onlinegrades, campusguidefbpage;
    private WebView wv_onlineportal, wv_loadingscreen;

    public ceuonlineportals() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ceuonlineportals, container, false);

        init(view);
        loadwebsettings();
        offlinemode();

        mainsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animAlpha);
                wv_loadingscreen.setVisibility(View.VISIBLE);
                wv_onlineportal.setVisibility(View.GONE);

                wv_loadingscreen.loadUrl("file:///android_asset/loadingscreen.html");
                wv_onlineportal.setWebViewClient(new WebViewClient() {
                    @Override
                    public void onPageFinished(WebView view, String url) {
                        //hide loading image
                        wv_loadingscreen.setVisibility(View.GONE);
                        //show webview
                        wv_onlineportal.setVisibility(View.VISIBLE);

                    }
                });
                wv_onlineportal.loadUrl("http://www.ceu.edu.ph");
            }
        });

        onlinegrades.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animAlpha);
                wv_loadingscreen.setVisibility(View.VISIBLE);
                wv_onlineportal.setVisibility(View.GONE);

                wv_loadingscreen.loadUrl("file:///android_asset/loadingscreen.html");
                wv_onlineportal.setWebViewClient(new WebViewClient() {
                    @Override
                    public void onPageFinished(WebView view, String url) {
                        //hide loading image
                        wv_loadingscreen.setVisibility(View.GONE);
                        //show webview
                        wv_onlineportal.setVisibility(View.VISIBLE);

                    }
                });
                wv_onlineportal.loadUrl("https://grades.ceu.edu.ph");

            }
        });

        campusguidefbpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animAlpha);
                /*
                wv_onlineportal.loadUrl("https://www.facebook.com/campusguideceumanila");
                wv_onlineportal.setWebViewClient(new WebViewClient());*/

                try {

                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://facewebmodal/f?href=1191136224348285"));
                    startActivity(intent);
                } catch (Exception e) {
                    wv_loadingscreen.setVisibility(View.VISIBLE);
                    wv_onlineportal.setVisibility(View.GONE);

                    wv_loadingscreen.loadUrl("file:///android_asset/loadingscreen.html");
                    wv_onlineportal.setWebViewClient(new WebViewClient() {
                        @Override
                        public void onPageFinished(WebView view, String url) {
                            //hide loading image
                            wv_loadingscreen.setVisibility(View.GONE);
                            //show webview
                            wv_onlineportal.setVisibility(View.VISIBLE);

                        }
                    });
                    wv_onlineportal.loadUrl("https://www.facebook.com/campusguideceumanila");
                }
            }
        });

        return view;
    }


    private void init(View view) {
        //for button animation
        animAlpha = AnimationUtils.loadAnimation(getContext(), R.anim.anim_alpha);

        mainsite = (BottomNavigationItemView) view.findViewById(R.id.nav_ceuwebsite);
        onlinegrades = (BottomNavigationItemView) view.findViewById(R.id.nav_onlinegrades);
        campusguidefbpage = (BottomNavigationItemView) view.findViewById(R.id.nav_campusguidefbpage);
        wv_onlineportal = (WebView) view.findViewById(R.id.wv_onlineportal);
        wv_loadingscreen = (WebView) view.findViewById(R.id.wv_loadingscreen);


        wv_loadingscreen.setVisibility(View.VISIBLE);
        wv_onlineportal.setVisibility(View.GONE);

        wv_loadingscreen.loadUrl("file:///android_asset/loadingscreen.html");
        wv_onlineportal.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                //hide loading image
                wv_loadingscreen.setVisibility(View.GONE);
                //show webview
                wv_onlineportal.setVisibility(View.VISIBLE);

            }
        });
        wv_onlineportal.loadUrl("https://grades.ceu.edu.ph");



    }


    private void loadwebsettings() {
        //        wv_onlineportal.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
        //        wv_onlineportal.getSettings().setAppCacheEnabled(true);
        WebSettings webSettings = wv_onlineportal.getSettings();
        webSettings.setBuiltInZoomControls(true);
        webSettings.setSupportZoom(true);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDisplayZoomControls(false);
        wv_onlineportal.setVerticalScrollBarEnabled(true);
        wv_onlineportal.setHorizontalScrollBarEnabled(true);
        wv_onlineportal.setBackgroundColor(15658734);

        wv_onlineportal.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        wv_onlineportal.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);


    }

    private void offlinemode() {
        Boolean net = ((MainActivity) getActivity()).isNetworkAvailable();
        if (!net) { // loading offline
            wv_onlineportal.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);

            wv_onlineportal.setWebViewClient(new WebViewClient() {
                public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                    wv_onlineportal.loadUrl("file:///android_asset/nointernet.html");

                }
            });
        }
    }


}
