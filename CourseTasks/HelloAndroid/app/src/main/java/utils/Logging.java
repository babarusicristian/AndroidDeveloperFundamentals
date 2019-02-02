package utils;

import android.util.Log;

import cristian.babarusi.helloandroid.BuildConfig;

public class Logging {
    public static void show(Object obj, String message) {
        if (BuildConfig.DEBUG) {
            Log.e(obj.getClass().getName(), message);
        }
    }
}
