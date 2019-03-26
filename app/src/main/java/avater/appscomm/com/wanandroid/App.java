package avater.appscomm.com.wanandroid;

import android.app.Application;

import com.tencent.bugly.crashreport.CrashReport;

import avater.appscomm.com.wanandroid.db.ObjectBox;
import avater.appscomm.com.wanandroid.net.InternetUtils;

public class App extends Application {

    private static App app;

    @Override
    public void onCreate() {
        super.onCreate();
        CrashReport.initCrashReport(this);
        app = this;
        ObjectBox.init(this);
        //网络相关
        InternetUtils.INSTANCE.init(this);
        //账户相关
    }

    public static App getMyApplication() {
        return app;
    }
}
