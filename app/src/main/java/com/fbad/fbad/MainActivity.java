package com.fbad.fbad;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import com.facebook.ads.AdSettings;
import com.facebook.ads.AdSize;
import com.fbad.fbad.model.facebook.FacebookInjectedScript;
import com.fbad.fbad.ui.HijackedAdView;

public class MainActivity extends AppCompatActivity {

    LinearLayout adContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupUI();
    }

    private void setupUI() {
        findViewById(R.id.btn_addBanner).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addAd();
            }
        });
        adContainer = (LinearLayout) findViewById(R.id.banner_container);
    }

    void addAd() {
        // Instantiate an HijackedAdView view
        HijackedAdView adView = HijackedAdView.Builder
                .with(this)
                .setPlacementID("YOUR_PLACEMENT_ID")
                .setAdSize(AdSize.BANNER_HEIGHT_50)
                .setAdListener(null) //Default: loads injectedAd only
                .setInjectedAd(new FacebookInjectedScript(links[clickCounter], images[clickCounter]))
                .build();

        // Add the ad view to your activity layout
        adContainer.addView(adView);
        AdSettings.addTestDevice("aa42e8c2d9d463584daf2abbeb5c2874");

        // Request an ad
        adView.loadAd();

        //incrementing links(Bonus)
        increment();
    }

    //region Mocking code for injection
    /*
    Put whatever links & images you like here
     */
    String[] links = {"https://avatars3.githubusercontent.com/u/2118838?v=4&s=200",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSGV0x0ifpsEFXrBl-4Gn-GGe7a9ugvWjzuz4duwftZtifqP2Nx",
            "http://www.webmynesystems.com/images/hire-android.png"};

    String[] images = {"https://media.licdn.com/mpr/mpr/shrinknp_400_400/AAEAAQAAAAAAAA19AAAAJDRmOWQxOGFlLTAzMjItNDQ3NS04MWRhLTliMWE0M2I4Yzg3NQ.jpg",
            "https://il.linkedin.com/mpr/mpr/shrinknp_400_400/AAEAAQAAAAAAAAWZAAAAJGFkZmMzOGU0LWU4ZTItNDc1Ni1iOGIwLWUxZDA3NjEwYzY5OA.jpg",
            "http://image-store.slidesharecdn.com/573ce91c-4b17-4ac5-9f2d-58836c1599fa-original.png"};
    int clickCounter;

    private void increment() {
        clickCounter++;
        if (clickCounter >= links.length)
            clickCounter = 0;
    }
    //endregion
}
