package mrhao.com.youyuaccount.widget;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.gyf.immersionbar.ImmersionBar;

public class BaseActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //由于没有很好的办法解决状态栏与布局顶部重叠的问题，暂定所有布局添加 android:paddingTop="20dp" 属性
        ImmersionBar.with(this)
                .statusBarDarkFont(true, 0.2f) //原理：如果当前设备支持状态栏字体变色，会设置状态栏字体为黑色，如果当前设备不支持状态栏字体变色，会使当前状态栏加上透明度，否则不执行透明度
                .init();
    }


}
