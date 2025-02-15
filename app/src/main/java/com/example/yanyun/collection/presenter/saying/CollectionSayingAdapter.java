package com.example.yanyun.collection.presenter.saying;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
    private CollectionSayingPresenter collectionSayingPresenter;

    private int clickCount = 1;//点击c次数

    public CollectionSayingAdapter(ArrayList<FavoriteEntity> favorites, CollectionSayingPresenter collectionSayingPresenter) {
        this.favorites = favorites;
        this.collectionSayingPresenter = collectionSayingPresenter;
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
        holder.mCollect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickCount++;
                //如果点击数为奇数则显示收藏，为偶数则显示未收藏

                if (clickCount % 2 == 1) {
                    holder.mCollect.setImageResource(R.drawable.collected);
                    collectionSayingPresenter.Collect(holder.mContent.getText().toString(), holder.mAuthor.getText().toString());
                } else {
                    holder.mCollect.setImageResource(R.drawable.uncollected);
                    collectionSayingPresenter.unCollect(holder.mContent.getText().toString());
                }
            }
        });


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

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mContent;
        TextView mAuthor;
        View view;
        ImageView mCollect;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mContent = itemView.findViewById(R.id.tv_collection_saying_content);
            mAuthor = itemView.findViewById(R.id.tv_collection_saying_author);
            mCollect = itemView.findViewById(R.id.iv_collection_collect);
            view = itemView;
        }
    }
}
