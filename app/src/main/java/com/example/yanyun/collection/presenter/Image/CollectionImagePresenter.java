package com.example.yanyun.collection.presenter.Image;

import com.example.yanyun.collection.model.image.CollectImageModel;
import com.example.yanyun.collection.model.image.ICollectImageModel;
import com.example.yanyun.collection.view.image.ICollectionImage;
import com.example.yanyun.database.entity.FavoriteEntity;

import java.util.ArrayList;

/**
 * description ： 收藏-图片的Presenter
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
    public void doUpData() {
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
