package com.example.yanyun.presenter.collection.saying;

import com.example.yanyun.database.entity.FavoriteEntity;
import com.example.yanyun.model.collection.saying.CollectSayingModel;
import com.example.yanyun.model.collection.saying.ICollectSayingModel;
import com.example.yanyun.view.collection.saying.ICollectionSaying;

import java.util.ArrayList;
import java.util.List;

/**
 * description ： 收藏的Saying的P层
 * author : HI-IR
 * email : qq2420226433@outlook.com
 * date : 2025/1/25 18:56
 */
public class CollectionSayingPresenter {
    ICollectSayingModel iCollectSayingModel;
    ICollectionSaying iCollectionSaying;

    public CollectionSayingPresenter(ICollectionSaying iCollectionSaying) {
        this.iCollectionSaying = iCollectionSaying;
        iCollectSayingModel= new CollectSayingModel();
    }

    //更新收藏的数据
    public void doUpData(){
        iCollectSayingModel.getFavoriteData(new ICollectSayingModel.CallBack() {
            @Override
            public void onSuccess(ArrayList<FavoriteEntity> favorites) {
                iCollectionSaying.setAdapter(favorites);
            }

            @Override
            public void onError() {
                iCollectionSaying.showError();
            }
        });
    }

}
