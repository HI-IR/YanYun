package com.example.yanyun.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.yanyun.database.entity.FavoriteEntity;

import java.util.List;

/**
 * description ： Favorites表的DAO
 * 收藏.取消收藏.搜索言，诗,图
 * author : HI-IR
 * email : qq2420226433@outlook.com
 * date : 2025/1/24 21:00
 */
@Dao
public interface FavoriteDao {

    @Query("SELECT COUNT(*) FROM favorites WHERE favorite_type = 'Saying' AND user_id = :user_id")
    int countSayingByid(Long user_id);

    @Query("SELECT COUNT(*) FROM favorites WHERE favorite_type = 'Poem' AND user_id = :user_id")
    int countPoemByid(Long user_id);

    @Query("SELECT COUNT(*) FROM favorites WHERE favorite_type = 'Image' AND user_id = :user_id")
    int countImageByid(Long user_id);

    // 查询是否存在相同内容的数据
    @Query("SELECT COUNT(*) FROM favorites WHERE favorite_content = :content AND user_id = :user_id")
    int countByContent(String content, Long user_id);

    @Insert
    void InsertData(FavoriteEntity favorite);//收藏数据

    @Query("DELETE FROM favorites WHERE favorite_content = :content AND user_id =:user_id ")
    void DeleteDataByContent(String content, long user_id);//删除收藏

    @Query("SELECT * FROM favorites WHERE user_id =:user_id AND favorite_type = 'Saying' ORDER BY favorite_id")
    List<FavoriteEntity> FindFavoriteSayingByid(long user_id);

    @Query("SELECT * FROM favorites WHERE user_id =:user_id AND favorite_type = 'Poem' ORDER BY favorite_id")
    List<FavoriteEntity> FindFavoritePoemByid(long user_id);

    @Query("SELECT * FROM favorites WHERE user_id =:user_id AND favorite_type = 'Image' ORDER BY favorite_id")
    List<FavoriteEntity> FindFavoriteImageByid(long user_id);

    @Query("SELECT COUNT(*) FROM favorites WHERE user_id =:user_id AND favorite_type = 'Image' AND favorite_author = :author")
    int countImageByAuthor(long user_id, String author);

    @Query("DELETE FROM favorites WHERE favorite_author = :author AND user_id =:user_id")
    void DeleteDataByAuthor(String author, long user_id);
}
