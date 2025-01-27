package com.example.yanyun.collection.presenter;

import androidx.fragment.app.Fragment;

import com.example.yanyun.FragmentInterface;
import com.example.yanyun.collection.view.ICollectionActivity;
import com.example.yanyun.collection.view.image.CollectionImageFragment;
import com.example.yanyun.collection.view.poem.CollectionPoemFragment;
import com.example.yanyun.collection.view.saying.CollectionSayingFragment;

import java.util.ArrayList;

/**
 * description ：收藏页面的Presenter
 *
 * author : HI-IR
 * email : qq2420226433@outlook.com
 * date : 2025/1/25 17:59
 */
public class CollectionPresenter {
    ICollectionActivity iCollectionActivity;
    //建立View层的连接
    public CollectionPresenter(ICollectionActivity iCollectionActivity) {
        this.iCollectionActivity = iCollectionActivity;
    }

    //初始化Collectiong页
    public  void initView(){
        ArrayList<FragmentInterface> fragments = new ArrayList<>();
        fragments.add(new FragmentInterface() {
            @Override
            public Fragment back() {
                return new CollectionSayingFragment();
            }
        });

        fragments.add(new FragmentInterface() {
            @Override
            public Fragment back() {
                return new CollectionPoemFragment();
            }
        });

        fragments.add(new FragmentInterface() {
            @Override
            public Fragment back() {
                return new CollectionImageFragment();
            }
        });

        iCollectionActivity.setAdapter(fragments);
    }
}
