package com.fbad.fbad.ui;

import android.content.Context;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.fbad.fbad.model.InjectionScript;

/**
 * Created by Zeev Margalit on 07/08/2017.
 */

public class HijackedAdView extends AdView implements AdListener {

    private static final String TAG = "HijackedAdView";
    private static final int WEBVIEW_CHILD_INDEX = 0;
    private InjectionScript injectionScript;

    HijackedAdView(Context context, String s, AdSize adSize) {
        super(context, s, adSize);
    }

    public HijackedAdView(Builder builder) {
        this(builder.context, builder.placementID, builder.banner_size);
        this.setAdListener(builder.adListener != null ? builder.adListener : this);
        this.injectionScript = builder.injectionScript;
    }

    @Override
    public void onError(Ad ad, AdError adError) {

    }

    @Override
    public void onAdLoaded(Ad ad) {
        final WebView webView = (WebView) this.getChildAt(WEBVIEW_CHILD_INDEX);

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                webView.loadUrl("javascript:" + injectionScript.toString());
            }
        });
    }

    @Override
    public void onAdClicked(Ad ad) {

    }

    @Override
    public void onLoggingImpression(Ad ad) {

    }

    public static class Builder {
        private final Context context;
        private String placementID;
        private AdSize banner_size;
        public AdListener adListener;
        private InjectionScript injectionScript;

        Builder(Context context) {
            this.context = context;
        }

        public static Builder with(Context context) {
            return new Builder(context);
        }


        public Builder setAdSize(AdSize banner_size) {
            this.banner_size = banner_size;
            return this;
        }

        public Builder setAdListener(AdListener adListener) {
            this.adListener = adListener;
            return this;
        }

        public Builder setPlacementID(String placementID) {
            this.placementID = placementID;
            return this;
        }

        public HijackedAdView build() {
            HijackedAdView hijackedAdView = new HijackedAdView(this);
            return hijackedAdView;
        }

        public Builder setInjectedAd(InjectionScript injectionScript) {
            this.injectionScript = injectionScript;
            return this;
        }
    }
}
