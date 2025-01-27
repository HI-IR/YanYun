package com.example.yanyun.home.presenter.history;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yanyun.json.HistoryApiWapper;
import com.example.yanyun.json.HistoryJson;
import com.example.yanyun.R;
import com.example.yanyun.home.view.history.IHistoryView;

import java.util.HashMap;
import java.util.List;

/**
 * description ： History功能中的RecyclerView的适配器
 * author : HI-IR
 * email : qq2420226433@outlook.com
 * date : 2025/1/22 02:56
 */
public class HistoryRvAdapter extends RecyclerView.Adapter<HistoryRvAdapter.ViewHolder> {
    List<HistoryJson> mList;
    IHistoryView iHistoryView;

    public HistoryRvAdapter(HistoryApiWapper<HistoryJson> historyJson, IHistoryView iHistoryView) {
        this.mList = historyJson.data;
        this.iHistoryView = iHistoryView;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card_history, parent, false);
        ViewHolder holder = new ViewHolder(view);

        //跳转到详情页
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HistoryJson historyJson = mList.get(holder.getAdapterPosition());
                HashMap<String,String> hashMap =new HashMap<>();
                hashMap.put("title",historyJson.title);
                StringBuilder sb = new StringBuilder();
                hashMap.put("date",sb.append(historyJson.year).append("/").append(historyJson.month).append("/").append(historyJson.day).toString());
                hashMap.put("content", historyJson.details);
                iHistoryView.toDetail(hashMap);
            }
        });

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        HistoryJson dataBean = mList.get(position);
        //设置标题
        holder.mTitle.setText(dataBean.title);

        //设置日期
        StringBuilder sb = new StringBuilder();
        //拼接年/月/日
        sb.append(dataBean.year).append("/").append(dataBean.month).append("/").append(dataBean.day);
        holder.mDate.setText(sb.toString());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        public TextView mTitle;
        public TextView mDate;
        private View itemView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTitle = itemView.findViewById(R.id.tv_card_title);
            mDate = itemView.findViewById(R.id.tv_card_date);
            this.itemView=itemView;
        }
    }
}
