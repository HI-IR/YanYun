package com.example.yanyun.view.home.history;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yanyun.Detail;
import com.example.yanyun.model.bean.json.HistoryJson;
import com.example.yanyun.presenter.home.history.HistoryPresenter;
import com.example.yanyun.presenter.home.history.HistoryRvAdapter;
import com.example.yanyun.R;

import java.util.HashMap;

/**
 * description ： Home页的子Fragment--Image
 * author : HI-IR
 * email : qq2420226433@outlook.com
 * date : 2025/1/21 13:32
 */
public class HistoryView extends Fragment implements IHistoryView {
    private ProgressBar mProgressBar;
    private RecyclerView mRecyclerView;
    private HistoryPresenter mHistoryPresenter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_history, container, false);
        initView(view);
        initEvent();
        return view;
    }

    private void initEvent() {
        mHistoryPresenter=new HistoryPresenter(this);
        doUpdateInfo();
    }

    private void initView(View view) {
        mProgressBar = view.findViewById(R.id.progressBar_history);
        mRecyclerView=view.findViewById(R.id.rv_history_content);
    }

    @Override
    public void showLoading() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void doUpdateInfo() {
        showLoading();
        mHistoryPresenter.doUpdateInfo();
    }

    //设置信息
    @Override
    public void setInfo(HistoryJson historyJson) {
        mRecyclerView.setAdapter(new HistoryRvAdapter(historyJson,this));
        //设置线性布局
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(linearLayoutManager);
        hideLoading();
    }

    @Override
    public void showError(String msg) {
        Toast.makeText(getContext(),msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void toDetail(HashMap<String, String> data) {
        Intent intent =new Intent(getContext(), Detail.class);
        for(String i : data.keySet()){
            intent.putExtra(i,data.get(i));
        }
        startActivity(intent);
    }
}
