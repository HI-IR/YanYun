package com.example.yanyun.collection.presenter.saying;

import com.example.yanyun.collection.model.saying.CollectSayingModel;
import com.example.yanyun.collection.model.saying.ICollectSayingModel;
import com.example.yanyun.collection.view.saying.ICollectionSaying;
import com.example.yanyun.database.entity.FavoriteEntity;

import java.util.ArrayList;


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
        iCollectSayingModel = new CollectSayingModel();
    }

    //更新收藏的数据
    public void doUpData() {
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
