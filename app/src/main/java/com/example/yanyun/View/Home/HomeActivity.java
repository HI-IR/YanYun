package com.example.yanyun.View.Home;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import androidx.drawerlayout.widget.DrawerLayout;

import com.example.yanyun.R;
import com.google.android.material.navigation.NavigationView;

public class HomeActivity extends AppCompatActivity {
    DrawerLayout mDrawerLayout;//侧划窗口
    NavigationView mNavigationView;
    Toolbar mToolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
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
                if(item.getItemId()==R.id.item_menu_saying){
                    Toast.makeText(HomeActivity.this,"我喜欢的言",Toast.LENGTH_SHORT).show();
                } else if (item.getItemId()==R.id.item_menu_poem) {
                    Toast.makeText(HomeActivity.this,"我喜欢的诗",Toast.LENGTH_SHORT).show();
                }else if(item.getItemId()==R.id.item_menu_image){
                    Toast.makeText(HomeActivity.this,"我喜欢的图",Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });


    }

    private void initView() {
        mDrawerLayout=findViewById(R.id.drawerlayout_home);
        mNavigationView=findViewById(R.id.nv_home);
        mNavigationView.setItemIconTintList(null);//设置menu为原色
        mToolbar=findViewById(R.id.toolbar_home);

    }
}