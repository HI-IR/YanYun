package com.example.yanyun.collection.view;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager2.widget.ViewPager2;

import com.example.yanyun.FragmentInterface;
import com.example.yanyun.R;
import com.example.yanyun.collection.presenter.CollectionAdapter;
import com.example.yanyun.collection.presenter.CollectionPresenter;
import com.example.yanyun.main.view.MainActivity;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

public class CollectionActivity extends AppCompatActivity implements ICollectionActivity {
    private TabLayout mTab;
    private ViewPager2 mVP2;
    private CollectionPresenter mCollectionPresenter;
    private Toolbar mToolbar;

    @Override
    protected void onResume() {
        super.onResume();
        Intent intent = getIntent();
        if (intent.hasExtra("goal")) {
            switch (intent.getStringExtra("goal")) {
                case "Saying": {
                    mVP2.setCurrentItem(0);
                    break;
                }
                case "Poem": {
                    mVP2.setCurrentItem(1);
                    break;
                }
                case "Image": {
                    mVP2.setCurrentItem(2);
                }

            }
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection);
//        // 设置状态栏透明
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            Window window = getWindow();
//            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//            window.setStatusBarColor(android.graphics.Color.TRANSPARENT);
//            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
//        }
        initView();
        mCollectionPresenter.initView();
        initEvent();
    }

    private void initEvent() {
        new TabLayoutMediator(mTab, mVP2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                if (position == 0) {
                    tab.setText("言");
                } else if (position == 1) {
                    tab.setText("诗");
                } else {
                    tab.setText("图");
                }
            }
        }).attach();


        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CollectionActivity.this, MainActivity.class);
                intent.putExtra("launchSource", "CollectionActivity");//声明是由CollectionActivity而来的
                startActivity(intent);
            }
        });
    }

    private void initView() {
        mCollectionPresenter = new CollectionPresenter(this);
        mTab = findViewById(R.id.tab_collection);
        mVP2 = findViewById(R.id.vp2_collection);
        mToolbar = findViewById(R.id.toolbar_collection);
    }

    @Override
    public void setAdapter(ArrayList<FragmentInterface> mFragments) {
        mVP2.setAdapter(new CollectionAdapter(CollectionActivity.this, mFragments));
    }

}