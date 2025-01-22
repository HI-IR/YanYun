package com.example.yanyun.view.home.image;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.yanyun.model.bean.json.ImageJson;
import com.example.yanyun.presenter.home.image.ImagePresenter;
import com.example.yanyun.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

/**
 * description ： Home页的子Fragment--Image
 * author : HI-IR
 * email : qq2420226433@outlook.com
 * date : 2025/1/20 19:39
 */
public class ImageView extends Fragment implements IImageView{
    private BottomNavigationView mBottomNavigationView;
    private int clickCountCollection = 0;
    private int clickCountRefresh = 0;
    private ProgressBar mProgressBar;
    private ImagePresenter imagePresenter;
    private android.widget.ImageView mImage;
    private TextView mCopyright;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_image, container, false);
        initView(view);
        initEvent();

        return view;
    }

    private void initEvent() {
        doUpdateInfo(clickCountRefresh);

        //点击爱心收藏，TODO 暂未完全实现等待接入数据库
        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_collection: {
                        clickCountCollection++;
                        //如果点击数为奇数则显示收藏，为偶数则显示未收藏
                        int resourcesId = (clickCountCollection % 2 == 1) ? R.drawable.collected : R.drawable.uncollected;
                        item.setIcon(resourcesId);
                        break;
                    }
                    case R.id.menu_refresh: {
                        clickCountRefresh = (clickCountRefresh + 1) % 8;
                        doUpdateInfo(clickCountRefresh);
                    }
                }
                return true;
            }
        });
    }

    private void initView(View view) {
        mBottomNavigationView = view.findViewById(R.id.bottomNavigationView_image);
        mProgressBar = view.findViewById(R.id.progressBar_image);
        imagePresenter = new ImagePresenter(this);
        mImage = view.findViewById(R.id.iv_image_img);
        mCopyright =view.findViewById(R.id.tv_imge_copyright);
        mBottomNavigationView.setItemIconTintList(null);
    }

    @Override
    public void showLoading() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void doUpdateInfo(int count) {
        showLoading();
        imagePresenter.doUpdateInfo(count);
    }

    @Override
    public void setInfo(ImageJson imageJson) {

        //设置图片信息
        RequestOptions requestOptions = new RequestOptions().placeholder(R.drawable.loading)
                .fallback(R.drawable.error);
        Glide.with(getContext()).load(imageJson.bing.url).apply(requestOptions).into(mImage);

        //设置版权信息
        mCopyright.setText(imageJson.bing.copyright);

        hideLoading();
    }

    @Override
    public void showError(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }
}
