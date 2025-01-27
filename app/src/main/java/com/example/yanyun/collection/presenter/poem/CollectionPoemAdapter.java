package com.example.yanyun.collection.presenter.poem;

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
 * description ： 收藏的Poem的Adapter
 * author : HI-IR
 * email : qq2420226433@outlook.com
 * date : 2025/1/25 18:24
 */
public class CollectionPoemAdapter extends RecyclerView.Adapter<CollectionPoemAdapter.ViewHolder>{
    ArrayList<FavoriteEntity> favorites = new ArrayList<>();

    public CollectionPoemAdapter(ArrayList<FavoriteEntity> favorites) {
        this.favorites = favorites;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_poem, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        FavoriteEntity favoriteEntity = favorites.get(position);
        holder.mAuthor.setText(favoriteEntity.getFavoriteAuthor());

        //将标题和内容分开（中间是用\n连接的）
        String[] lines = favoriteEntity.getFavoriteContent().split("\\|");
        holder.mTitle.setText(lines[0]);
        holder.mContent.setText(lines[1]);
    }

    @Override
    public int getItemCount() {
        return favorites.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView mContent;
        TextView mTitle;
        TextView mAuthor;
        View view;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mContent =itemView.findViewById(R.id.tv_collection_poem_content);
            mAuthor = itemView.findViewById(R.id.tv_collection_poem_author);
            mTitle = itemView.findViewById(R.id.tv_collection_poem_title);
            view = itemView;
        }
    }
}
