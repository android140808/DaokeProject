package avater.appscomm.com.wanandroid.utils;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.res.Configuration;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;

public enum DisplayUtil {
    INSTANCE;
    private static float mDensity;
    private static float mScaledDensity;

    public void setCustomDenstity(@NonNull Activity activity, @NonNull final Application application) {
        DisplayMetrics displayMetrics = application.getResources().getDisplayMetrics();
        if (mDensity == 0) {
            mDensity = displayMetrics.density;
            mScaledDensity = displayMetrics.scaledDensity;
            application.registerComponentCallbacks(new ComponentCallbacks() {
                @Override
                public void onConfigurationChanged(Configuration configuration) {
                    if (configuration != null && configuration.fontScale > 0) {
                        mScaledDensity = application.getResources().getDisplayMetrics().scaledDensity;
                    }
                }

                @Override
                public void onLowMemory() {

                }
            });
            float targetDensity = displayMetrics.widthPixels / 360;
            float targetScaleDensity = targetDensity * (mScaledDensity / mDensity);
            int targetDensityDpi = (int) (160 * targetDensity);
            displayMetrics.density = targetDensity;
            displayMetrics.scaledDensity = targetScaleDensity;
            displayMetrics.density = targetDensityDpi;
            DisplayMetrics dm = activity.getResources().getDisplayMetrics();
            dm.density = targetDensity;
            dm.scaledDensity = targetScaleDensity;
            dm.densityDpi = targetDensityDpi;

        }

    }
}
