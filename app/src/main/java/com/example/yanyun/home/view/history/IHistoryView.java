package com.example.yanyun.home.view.history;

import com.example.yanyun.json.HistoryApiWapper;
import com.example.yanyun.json.HistoryJson;

import java.util.HashMap;

/**
 * description ： HistoryView的接口
 * 显示加载条，隐藏加载条，更新数据，设置数据，显示错误信息
 * author : HI-IR
 * email : qq2420226433@outlook.com
 * date : 2025/1/21 13:38
 */
public interface IHistoryView {
    void showLoading();//显示加载条

    void hideLoading();//隐藏加载条

    void doUpdateInfo();//更新数据

    public void setInfo(HistoryApiWapper<HistoryJson> historyJson);//设置数据

    void showError(String msg);//显示错误信息

    void toDetail(HashMap<String,String> data);//跳转详情页
}
