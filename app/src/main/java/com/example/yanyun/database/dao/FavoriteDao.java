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

    // 查询是否存在相同内容的数据
    @Query("SELECT COUNT(*) FROM favorites WHERE favorite_content = :content AND user_id = :user_id")
    int countByContent(String content,Long user_id);

    @Insert
    void InsertData(FavoriteEntity favorite);//收藏数据

    @Query("DELETE FROM favorites WHERE favorite_content = :content ")
    void DeleteDataByContent(String content);//删除收藏

    @Query("SELECT * FROM favorites WHERE user_id =:user_id AND favorite_type = 'Saying' ORDER BY favorite_id")
    List<FavoriteEntity> FindFavoriteSayingByid(String user_id);

    @Query("SELECT * FROM favorites WHERE user_id =:user_id AND favorite_type = 'Peom' ORDER BY favorite_id")
    List<FavoriteEntity> FindFavoritePeomByid(String user_id);

    @Query("SELECT * FROM favorites WHERE user_id =:user_id AND favorite_type = 'Imag' ORDER BY favorite_id")
    List<FavoriteEntity> FindFavoriteImageByid(String user_id);


}
