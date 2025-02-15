package com.example.yanyun.collection.presenter.Image;

import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.yanyun.R;
import com.example.yanyun.database.entity.FavoriteEntity;

import java.util.ArrayList;

/**
 * description ： 收藏的Image的Adapter
 * author : HI-IR
 * email : qq2420226433@outlook.com
 * date : 2025/1/25 18:35
 */
public class CollectionImageAdapter extends RecyclerView.Adapter<CollectionImageAdapter.ViewHolder> {
    ArrayList<FavoriteEntity> favorites;

    public CollectionImageAdapter(ArrayList<FavoriteEntity> favorites) {
        this.favorites = favorites;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        FavoriteEntity favoriteEntity = favorites.get(position);

        //将Base64编码的字节数组转化为字节数组
        byte[] decode = Base64.decode(favoriteEntity.getFavoriteContent(), Base64.DEFAULT);

        Glide.with(holder.mImg).load(decode).placeholder(R.drawable.loading).fallback(R.drawable.error).into(holder.mImg);
        //设置版权信息

        holder.mCopyright.setText(favoriteEntity.getFavoriteAuthor());
    }

    @Override
    public int getItemCount() {
        return favorites.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView mImg;
        TextView mCopyright;
        View view;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mImg = itemView.findViewById(R.id.tv_collection_image_image);
            mCopyright = itemView.findViewById(R.id.tv_collection_iamge_copyright);
            view = itemView;

        }
    }
}
