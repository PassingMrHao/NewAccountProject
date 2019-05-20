package mrhao.com.youyuaccount.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.gyf.immersionbar.ImmersionBar;

import mrhao.com.youyuaccount.MainActivity;
import mrhao.com.youyuaccount.R;
import mrhao.com.youyuaccount.widget.BaseActivity;

public class LoadingActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        ImmersionBar.with(this)
                .statusBarDarkFont(true, 0.2f) //原理：如果当前设备支持状态栏字体变色，会设置状态栏字体为黑色，如果当前设备不支持状态栏字体变色，会使当前状态栏加上透明度，否则不执行透明度
                .init();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                startActivity(new Intent(LoadingActivity.this, MainActivity.class));
                finish();
            }
        }, 2800);
    }
}
