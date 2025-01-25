package com.example.yanyun.view.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager2.widget.ViewPager2;

import com.example.yanyun.presenter.FragmentInterface;
import com.example.yanyun.presenter.main.MainPresenter;
import com.example.yanyun.presenter.main.MainVp2Adapter;
import com.example.yanyun.R;
import com.example.yanyun.view.collection.CollectionActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements IMainView {
    private DrawerLayout mDrawerLayout;//侧划窗口
    private NavigationView mNavigationView;
    private Toolbar mToolbar;
    private ViewPager2 mVp2;
    private MainPresenter mMainPresenter;
    private BottomNavigationView mBottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initEvent();
    }

    private void initEvent() {
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerLayout.openDrawer(Gravity.LEFT);
            }
        });


        //侧边菜单的点击事件
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.item_menu_saying) {
                    Toast.makeText(MainActivity.this, "我喜欢的言", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, CollectionActivity.class);
                    intent.putExtra("goal","Saying");
                    startActivity(intent);

                } else if (item.getItemId() == R.id.item_menu_poem) {
                    Toast.makeText(MainActivity.this, "我喜欢的诗", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, CollectionActivity.class);
                    intent.putExtra("goal","Poem");
                    startActivity(intent);

                } else if (item.getItemId() == R.id.item_menu_image) {
                    Toast.makeText(MainActivity.this, "我喜欢的图", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, CollectionActivity.class);
                    intent.putExtra("goal","Image");
                    startActivity(intent);
                }
                return true;
            }
        });

        mVp2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                mMainPresenter.onPagerSelected(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });

        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.menu_book: {
                        mVp2.setCurrentItem(0);
                        break;
                    }
                    case R.id.menu_other: {
                        mVp2.setCurrentItem(1);
                        break;
                    }
                    case R.id.menu_user: {
                        mVp2.setCurrentItem(2);
                        break;
                    }
                    default: {
                        break;
                    }
                }

                return true;
            }
        });

    }


    private void initView() {
        mVp2 = findViewById(R.id.viewPager2);
        mDrawerLayout = findViewById(R.id.drawerlayout_home);
        mNavigationView = findViewById(R.id.nv_home);
        mNavigationView.setItemIconTintList(null);//设置menu为原色
        mToolbar = findViewById(R.id.toolbar_home);
        mMainPresenter = new MainPresenter(this);
        mMainPresenter.initMain();
        mBottomNavigationView = findViewById(R.id.bottomNavigationView);
    }

    @Override
    public void setAdapter(ArrayList<FragmentInterface> mFragments) {
        mVp2.setAdapter(new MainVp2Adapter(this, mFragments));
    }

    //底部菜单栏颜色状态改变
    @Override
    public void menuChanged(int position) {
        switch (position) {
            case 0: {
                mBottomNavigationView.setSelectedItemId(R.id.menu_book);
                break;
            }
            case 1: {
                mBottomNavigationView.setSelectedItemId(R.id.menu_other);
                break;
            }
            case 2: {
                mBottomNavigationView.setSelectedItemId(R.id.menu_user);
                break;
            }
            default: {
                break;
            }
        }
    }
}