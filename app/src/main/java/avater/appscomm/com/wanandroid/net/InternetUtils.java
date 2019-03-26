package avater.appscomm.com.wanandroid.net;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;

public enum InternetUtils {
    INSTANCE;
    /**
     * 没有连接网络
     */
    private static final int NETWORK_NONE = -1;
    /**
     * 移动网络
     */
    private static final int NETWORK_MOBILE = 0;
    /**
     * 无线网络
     */
    private static final int NETWORK_WIFI = 1;
    private Context context;

    public void init(Context context) {
        this.context = context;
    }

    @SuppressLint("MissingPermission")
    public int getNetWorkState() {
        if (context == null) {
            throw new UnsupportedOperationException("please use InternetUtils before init it");
        }
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        Network[] allNetworks = manager.getAllNetworks();
        for (int i = 0; i < allNetworks.length; i++) {
            NetworkInfo networkInfo = manager.getNetworkInfo(allNetworks[i]);
            if (networkInfo.isConnected()) {
                if (networkInfo.getType() == ConnectivityManager.TYPE_MOBILE) {
                    return NETWORK_MOBILE;
                } else {
                    return NETWORK_WIFI;
                }
            }
        }
        return NETWORK_NONE;
    }
}
