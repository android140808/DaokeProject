package avater.appscomm.com.wanandroid.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import avater.appscomm.com.wan_andoid.R;
import butterknife.ButterKnife;

public abstract class BaseCompatActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        if (getLayoutId() != R.layout.activity_main) {

        }
    }

    public abstract void initView();

    public abstract int getLayoutId();

    public void initBind() {
        ButterKnife.bind(this);
    }
}
