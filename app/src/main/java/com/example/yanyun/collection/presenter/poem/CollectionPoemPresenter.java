package com.example.yanyun.collection.presenter.poem;

import com.example.yanyun.database.entity.FavoriteEntity;
import com.example.yanyun.collection.model.poem.CollectPoemModel;
import com.example.yanyun.collection.model.poem.ICollectPoemModel;
import com.example.yanyun.collection.view.poem.ICollectionPoem;

import java.util.ArrayList;

/**
 * description ： TODO:类的作用
 * author : HI-IR
 * email : qq2420226433@outlook.com
 * date : 2025/1/25 18:23
 */
public class CollectionPoemPresenter {
    ICollectPoemModel iCollectPoemModel;
    ICollectionPoem iCollectionPoem;

    public CollectionPoemPresenter(ICollectionPoem iCollectionPoem) {
        this.iCollectionPoem = iCollectionPoem;
        iCollectPoemModel = new CollectPoemModel();
    }

    //更新收藏的数据
    public void doUpData(){
        iCollectPoemModel.getFavoriteData(new ICollectPoemModel.CallBack() {
            @Override
            public void onSuccess(ArrayList<FavoriteEntity> favorites) {
                iCollectionPoem.setAdapter(favorites);
            }

            @Override
            public void onError() {
                iCollectionPoem.showError();
            }
        });
    }

}
