package dev.joven.nosdk1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import android.widget.Toast;

public class OneNotif extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String title = intent.getStringExtra("title");
        String message = intent.getStringExtra("message");



        Toast.makeText(context, "Received Notification: " + title + " - " + message, Toast.LENGTH_SHORT).show();
    }
}