package com.example.yanyun.home.presenter.image;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import androidx.annotation.NonNull;

import com.example.yanyun.json.ImageApiWapper;
import com.example.yanyun.json.ImageJson;
import com.example.yanyun.home.model.imageModel.IImageModel;
import com.example.yanyun.home.model.imageModel.ImageModel;
import com.example.yanyun.home.view.image.IImageView;

import java.lang.ref.WeakReference;

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
        handler = new MyHandler(this);
    }

    public void doUpdateInfo(int count) {
        imageModel.getPoem(handler,count);
    }

    //收藏
    public void Collect(String content,String author){
        imageModel.collection(content,author);
    }

    //取消收藏
    public void unCollect(String content){
        imageModel.unCollection(content);
    }

    class MyHandler extends Handler {
        WeakReference<ImagePresenter> imageViewWeakReference;

        public MyHandler(ImagePresenter imagePresenter) {
            super(Looper.getMainLooper());
            WeakReference<ImagePresenter> imagePresenterWeakReference = new WeakReference<>(imagePresenter);
            this.imageViewWeakReference = imagePresenterWeakReference;
        }

        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0) {
                ImageApiWapper<ImageJson> temp = (ImageApiWapper<ImageJson>) msg.obj;
                if (temp.status == 1) {

                    imageViewWeakReference.get().imageView.setInfo(temp);
                } else {
                    imageViewWeakReference.get().imageView.showError("发生错误，请稍后重试");
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
