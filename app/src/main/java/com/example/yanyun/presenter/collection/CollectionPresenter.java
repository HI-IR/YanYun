package com.example.yanyun.presenter.collection;

import androidx.fragment.app.Fragment;

import com.example.yanyun.presenter.FragmentInterface;
import com.example.yanyun.view.collection.ICollectionActivity;
import com.example.yanyun.view.collection.image.CollectionImage;
import com.example.yanyun.view.collection.poem.CollectionPoem;
import com.example.yanyun.view.collection.saying.CollectionSaying;

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
                return new CollectionSaying();
            }
        });

        fragments.add(new FragmentInterface() {
            @Override
            public Fragment back() {
                return new CollectionPoem();
            }
        });

        fragments.add(new FragmentInterface() {
            @Override
            public Fragment back() {
                return new CollectionImage();
            }
        });

        iCollectionActivity.setAdapter(fragments);
    }
}
