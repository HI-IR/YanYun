package com.example.yanyun.presenter.home.image;

import android.content.Context;
import android.os.Handler;
import android.os.Message;

import androidx.annotation.NonNull;

import com.example.yanyun.model.bean.json.ImageJson;
import com.example.yanyun.model.home.imageModel.IImageModel;
import com.example.yanyun.model.home.imageModel.ImageModel;
import com.example.yanyun.view.home.image.IImageView;

/**
 * description ： ImageView的Presenter层
 * author : HI-IR
 * email : qq2420226433@outlook.com
 * date : 2025/1/22 01:06
 */
public class ImagePresenter {
    Handler handler;
    IImageView imageView;
    IImageModel imageModel;

    public ImagePresenter(IImageView imageView, Context context) {
        this.imageView = imageView;
        imageModel = new ImageModel(context);
        handler = new MyHandler();
    }

    public void doUpdateInfo(int count) {
        imageModel.GetPoem(handler,count);
    }

    //收藏
    public void Collect(String content,String author){
        imageModel.Collection(content,author);
    }

    //取消收藏
    public void unCollect(String content){
        imageModel.unCollection(content);
    }

    class MyHandler extends Handler {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0) {
                ImageJson temp = (ImageJson) msg.obj;
                if (temp.status == 1) {

                    imageView.setInfo(temp);
                } else {
                    imageView.showError("发生错误，请稍后重试");
                }
            }
        }
    }


    public void isCollected(String content){
        imageModel.isCollected(content, new IImageModel.callback() {
            @Override
            public void onCollected() {
                imageView.setCollected();
            }

            @Override
            public void onUnCollected() {
                imageView.setUnCollected();
            }
        });
    }

}
