package com.example.yanyun.Model.Home.PoemModel;

import android.os.Handler;

/**
 * description ： Poem的Model层接口
 *  * 获取古诗与作者数据
 * author : HI-IR
 * email : qq2420226433@outlook.com
 * date : 2025/1/21 18:01
 */
public interface IPoemModel {
    void GetPoem(Handler handler);//获取古诗与作者数据
}
