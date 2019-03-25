package avater.appscomm.com.wanandroid.db;

import android.content.Context;

import avater.appscomm.com.wanandroid.db.entity.MyObjectBox;
import io.objectbox.BoxStore;

public class ObjectBox {
    private static BoxStore boxStore;

    public static void init(Context context) {
        boxStore = MyObjectBox.builder().androidContext(context).build();//先生成Entity（HomeArticleDB）类后再次重新编译即可
    }

    public static BoxStore getBoxStore() {
        return boxStore;
    }
}
