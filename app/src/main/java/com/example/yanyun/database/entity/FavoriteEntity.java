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
    @ColumnInfo(name = "favorite_id")
    private int favoriteId;

    @ColumnInfo(name = "user_id")
    private long userId;


    /**
     *type即为收藏的类型：Saying(美言),Poem(诗歌),Image(美图)
     */
    @ColumnInfo(name = "favorite_type")
    private String favoriteType;

    //收藏的具体内容
    @ColumnInfo(name = "favorite_content")
    private String favoriteContent;

    @ColumnInfo(name = "favorite_author")
    private String favoriteAuthor;

    @ColumnInfo(name = "favorite_time")
    private String favoriteTime;


    public FavoriteEntity(long userId, String favoriteType, String favoriteContent, String favoriteAuthor, String favoriteTime) {
        this.userId = userId;
        this.favoriteType = favoriteType;
        this.favoriteContent = favoriteContent;
        this.favoriteAuthor = favoriteAuthor;
        this.favoriteTime = favoriteTime;
    }

    public int getFavoriteId() {
        return favoriteId;
    }

    public void setFavoriteId(int favoriteId) {
        this.favoriteId = favoriteId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getFavoriteType() {
        return favoriteType;
    }

    public void setFavoriteType(String favoriteType) {
        this.favoriteType = favoriteType;
    }

    public String getFavoriteContent() {
        return favoriteContent;
    }

    public void setFavoriteContent(String favoriteContent) {
        this.favoriteContent = favoriteContent;
    }

    public String getFavoriteAuthor() {
        return favoriteAuthor;
    }

    public void setFavoriteAuthor(String favoriteAuthor) {
        this.favoriteAuthor = favoriteAuthor;
    }

    public String getFavoriteTime() {
        return favoriteTime;
    }

    public void setFavoriteTime(String favoriteTime) {
        this.favoriteTime = favoriteTime;
    }
}
