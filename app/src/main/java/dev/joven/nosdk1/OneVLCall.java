package dev.joven.nosdk1;

import android.content.Context;
import com.android.volley.RequestQueue;

public class OneVLCall {
    private static RequestQueue mRequestQueue;
    private OneVLCall() {}
    public static void init(Context context) {
        mRequestQueue = com.android.volley.toolbox.Volley.newRequestQueue(context);
    }
    public static RequestQueue getRequestQueue() {
        if (mRequestQueue != null) {
            return mRequestQueue;
        } else {
            throw new IllegalStateException("RequestQueue not initialized");
        }
    }
}
