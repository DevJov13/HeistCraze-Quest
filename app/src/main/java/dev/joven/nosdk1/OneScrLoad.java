package dev.joven.nosdk1;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.WindowManager;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.VideoView;

@SuppressLint("CustomSplashScreen")
public class OneScrLoad extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_scr_load);
        getWindow().setFlags(1024,1024);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) actionBar.hide();

        VideoView splash = findViewById(R.id.videoView);

        Uri splashFile = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.load                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        );
        splash.setVideoURI(splashFile);
        splash.start();
        // Set a completion listener for the video playback
        splash.setOnCompletionListener(mediaPlayer -> {
            // Stop video playback and hide the VideoView
            splash.stopPlayback();
            splash.setVisibility(View.GONE);

            // Delayed start of the next activity after video completion
            new Handler(Looper.getMainLooper()).postDelayed(() -> {
                // Create an Intent to start the next activity
                Intent webApp = new Intent(this, OneContent.class);

                // Add flags to clear the back stack and create a new task
                webApp.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                // Start the next activity and finish the current one
                startActivity(webApp);
                finish();
            }, 4000);
        });
    }
}