package cristian.babarusi.module7.utils;

import android.util.Log;

import cristian.babarusi.module7.BuildConfig;

public class Logging {
    
    public static void show (Object obj, String message)
    {
        if(BuildConfig.DEBUG)
        {
            Log.e(obj.getClass().getName(), message);
        }
    }
}