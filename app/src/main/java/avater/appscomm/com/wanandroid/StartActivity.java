package avater.appscomm.com.wanandroid;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import avater.appscomm.com.wanandroid.utils.PermissionUtil;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= 23 && PermissionUtil.checkPermission(this, PermissionUtil.PERMISSIONS_STORAGE).length > 0) {
            PermissionUtil.checkAndRequestPermissions(this, PermissionUtil.PERMISSIONS_STORAGE);
        } else {
            intentToMainActivity();
        }
    }

    private void intentToMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        this.finish();
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        boolean hasPermissionDenin = false;
        if (requestCode == PermissionUtil.REQUEST_CODE) {
            for (int i = 0; i < grantResults.length; i++) {
                if (grantResults[i] == -1) {
                    hasPermissionDenin = true;
                    break;
                }
            }
            if (hasPermissionDenin) {
                Toast.makeText(this, "拒绝权限，将导致图片加载不出来！！", Toast.LENGTH_LONG).show();
            }
            intentToMainActivity();
        }
    }
}
