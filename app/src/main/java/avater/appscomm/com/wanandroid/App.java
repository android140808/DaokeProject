package avater.appscomm.com.wanandroid;

import android.app.Application;

import com.tencent.bugly.crashreport.CrashReport;

import avater.appscomm.com.wanandroid.db.ObjectBox;

public class App extends Application {

    private static App app;

    @Override
    public void onCreate() {
        super.onCreate();
        CrashReport.initCrashReport(this);
        app = this;
        ObjectBox.init(this);
        //网络相关
        //账户相关
    }

    public static App getMyApplication() {
        return app;
    }
}
