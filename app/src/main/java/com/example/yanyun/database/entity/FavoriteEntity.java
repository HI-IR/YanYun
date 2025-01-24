package com.example.yanyun.database.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

/**
 * description ： Favorites的实体类
 * author : HI-IR
 * email : qq2420226433@outlook.com
 * date : 2025/1/24 20:58
 */
//favorites实体类的user_id和Users实体类的id相关联
@Entity(tableName = "favorites", foreignKeys =@ForeignKey(entity = UsersEntity.class,
        parentColumns = "id",
        childColumns = "user_id"),
        indices = {@Index(value = {"user_id"})})//为 user_id 列创建索引,索引能够加快数据库的查询速度
public class FavoriteEntity {
    @PrimaryKey(autoGenerate = true)
    private int favorite_id;

    @ColumnInfo
    private long user_id;


    /**
     *type即为收藏的类型：Saying(美言),Poem(诗歌),Image(美图)
     */
    @ColumnInfo
    private String favorite_type;

    //收藏的具体内容
    @ColumnInfo
    private String favorite_content;

    @ColumnInfo
    private String favorite_author;

    @ColumnInfo
    private String favorite_time;


    public FavoriteEntity(long user_id, String favorite_type, String favorite_content, String favorite_author, String favorite_time) {
        this.user_id = user_id;
        this.favorite_type = favorite_type;
        this.favorite_content = favorite_content;
        this.favorite_author = favorite_author;
        this.favorite_time = favorite_time;
    }

    public int getFavorite_id() {
        return favorite_id;
    }

    public void setFavorite_id(int favorite_id) {
        this.favorite_id = favorite_id;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public String getFavorite_type() {
        return favorite_type;
    }

    public void setFavorite_type(String favorite_type) {
        this.favorite_type = favorite_type;
    }

    public String getFavorite_content() {
        return favorite_content;
    }

    public void setFavorite_content(String favorite_content) {
        this.favorite_content = favorite_content;
    }

    public String getFavorite_time() {
        return favorite_time;
    }

    public void setFavorite_time(String favorite_time) {
        this.favorite_time = favorite_time;
    }

    public String getFavorite_author() {
        return favorite_author;
    }

    public void setFavorite_author(String favorite_author) {
        this.favorite_author = favorite_author;
    }
}
