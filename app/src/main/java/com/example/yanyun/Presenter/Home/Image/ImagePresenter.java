package com.example.yanyun.Presenter.Home.Image;

import android.os.Handler;
import android.os.Message;

import androidx.annotation.NonNull;

import com.example.yanyun.Model.Bean.Json.ImageJson;
import com.example.yanyun.Model.Home.ImageModel.IImageModel;
import com.example.yanyun.Model.Home.ImageModel.ImageModel;
import com.example.yanyun.View.Home.Image.IImageView;

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

    public ImagePresenter(IImageView imageView) {
        this.imageView = imageView;
        imageModel = new ImageModel();
        handler = new MyHandler();
    }

    public void doUpdateInfo(int count) {
        imageModel.GetPoem(handler,count);
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
}
