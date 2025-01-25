package com.example.yanyun.presenter.collection.Image;

import com.example.yanyun.database.entity.FavoriteEntity;
import com.example.yanyun.model.collection.image.CollectImageModel;
import com.example.yanyun.model.collection.image.ICollectImageModel;
import com.example.yanyun.model.collection.poem.CollectPoemModel;
import com.example.yanyun.model.collection.poem.ICollectPoemModel;
import com.example.yanyun.view.collection.image.ICollectionImage;

import java.util.ArrayList;

/**
 * description ： TODO:类的作用
 * author : HI-IR
 * email : qq2420226433@outlook.com
 * date : 2025/1/25 20:03
 */
public class CollectionImagePresenter {
    ICollectImageModel iCollectImageModel;
    ICollectionImage iCollectionImage;

    public CollectionImagePresenter(ICollectionImage iCollectionImage) {
        this.iCollectionImage = iCollectionImage;
        iCollectImageModel = new CollectImageModel();
    }

    //更新收藏的数据
    public void doUpData(){
        iCollectImageModel.getFavoriteData(new ICollectImageModel.CallBack() {
            @Override
            public void onSuccess(ArrayList<FavoriteEntity> favorites) {
                iCollectionImage.setAdapter(favorites);
            }

            @Override
            public void onError() {
                iCollectionImage.showError();
            }
        });
    }
}
