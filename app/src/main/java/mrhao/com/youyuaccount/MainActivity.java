package mrhao.com.youyuaccount;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import mrhao.com.youyuaccount.adapter.BottomMenuPageAdapter;
import mrhao.com.youyuaccount.fragment.AssetsFragment;
import mrhao.com.youyuaccount.fragment.FindFragment;
import mrhao.com.youyuaccount.fragment.HomePageFragment;
import mrhao.com.youyuaccount.fragment.SettingFragment;
import mrhao.com.youyuaccount.widget.BaseActivity;
import mrhao.com.youyuaccount.widget.MyNoSlideViewpager;

public class MainActivity extends BaseActivity {


    @BindView(R.id.bottom_menu)
    BottomNavigationView bottomMenu;

    List<Fragment> fragmentList = new ArrayList<>();
    BottomMenuPageAdapter ad;
    @BindView(R.id.img_addAccount)
    ImageView imgAddAccount;
    @BindView(R.id.viewpager_main)
    MyNoSlideViewpager viewpagerMain;
    @BindView(R.id.main_drawer)
    DrawerLayout mainDrawer;
    @BindView(R.id.img_menu)
    ImageView imgMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        bottomMenu.setItemIconTintList(null);
        setBottomMenu();
    }

    private void setBottomMenu() {
        imgAddAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "添加一笔账单", Toast.LENGTH_SHORT).show();
            }
        });

        imgMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mainDrawer.openDrawer(Gravity.LEFT);//调用此方法，显示侧滑菜单
            }
        });


        //往listfragment列表中添加fragment页面
        fragmentList.add(new HomePageFragment()); //首页
        fragmentList.add(new AssetsFragment()); //资产
        fragmentList.add(new HomePageFragment()); //添加一比记账
        fragmentList.add(new FindFragment()); //发现
        fragmentList.add(new SettingFragment()); //我的

        ad = new BottomMenuPageAdapter(getSupportFragmentManager(), this, fragmentList);
        viewpagerMain.setAdapter(ad);


        //BottomMenu子选项点击事件
        bottomMenu.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {


                switch (menuItem.getItemId()) {

                    case R.id.bottommenu1:
                        viewpagerMain.setCurrentItem(0);
                        mainDrawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);//打开手动侧滑
                        imgMenu.setVisibility(View.VISIBLE);
                        return true;
                    case R.id.bottommenu2:
                        viewpagerMain.setCurrentItem(1);
                        mainDrawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);//关闭手动侧滑
                        imgMenu.setVisibility(View.GONE);
                        return true;
                    case R.id.bottommenu3:
                        viewpagerMain.setCurrentItem(3);
                        mainDrawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);//关闭手动侧滑
                        imgMenu.setVisibility(View.GONE);
                        return true;
                    case R.id.bottommenu4:
                        viewpagerMain.setCurrentItem(4);
                        imgMenu.setVisibility(View.GONE);
                        mainDrawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);//关闭手动侧滑
                        return true;
                    default:
                        break;
                }
                return false;
            }
        });


    }


}
