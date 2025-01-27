package com.example.yanyun.collection.presenter.saying;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yanyun.R;
import com.example.yanyun.database.entity.FavoriteEntity;

import java.util.ArrayList;

/**
 * description ： 收藏的Saying的Adapter
 * author : HI-IR
 * email : qq2420226433@outlook.com
 * date : 2025/1/25 17:46
 */
public class CollectionSayingAdapter extends RecyclerView.Adapter<CollectionSayingAdapter.ViewHolder> {
    ArrayList<FavoriteEntity> favorites = new ArrayList<>();

    public CollectionSayingAdapter(ArrayList<FavoriteEntity> favorites) {
        this.favorites = favorites;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_saying, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        FavoriteEntity favoriteEntity = favorites.get(position);
        holder.mContent.setText(favoriteEntity.getFavoriteContent());
        holder.mAuthor.setText(favoriteEntity.getFavoriteAuthor());
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return favorites.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView mContent;
        TextView mAuthor;
        View view;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mContent =itemView.findViewById(R.id.tv_collection_saying_content);
            mAuthor = itemView.findViewById(R.id.tv_collection_saying_author);
            view = itemView;
        }
    }
}
