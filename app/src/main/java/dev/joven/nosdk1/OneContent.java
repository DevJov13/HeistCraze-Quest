package dev.joven.nosdk1;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class OneContent extends AppCompatActivity {
    SharedPreferences appSharedPref;
    private boolean hasUserConsent;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_content);
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) actionBar.hide();

        appSharedPref = getSharedPreferences(OneGlobalCFG.appCode, MODE_PRIVATE);


        ((OneGlobalCFG) getApplication()).checkUserConsent(this, this, true);
        hasUserConsent = ((OneGlobalCFG) getApplication()).getUserConsent();

        OneGlobalV game = findViewById(R.id.game_view);



        new Handler().postDelayed(() -> {
            game.loadUrl(OneGlobalCFG.gameURL);



            BottomNavigationView navUI = findViewById(R.id.navBar);
            Log.d("Success", OneGlobalCFG.success);

            if(OneGlobalCFG.success.equals("success"))
            {
                navUI.setVisibility(View.VISIBLE);

                navUI.setOnNavigationItemSelectedListener(item -> {
                    if(item.getItemId() == R.id.nav_home)
                    {
                        recreate();
                    }
                    else if(item.getItemId() == R.id.nav_notify)
                    {
                        Intent intent = new Intent(Settings.ACTION_APP_NOTIFICATION_SETTINGS);
                        intent.putExtra(Settings.EXTRA_APP_PACKAGE, getPackageName());
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                    }
                    else if(item.getItemId() == R.id.nav_policy)
                    {

                        game.loadUrl(OneGlobalCFG.policyUrl);


                    }

                    return true;
                });
            }
            else
            {
                navUI.setVisibility(View.GONE);

            }
        },1800);

    }
}