package com.example.yanyun.database.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.yanyun.database.entity.UsersEntity;

/**
 * description ： Users表的DAO
 * 插入用户，查询用户id
 * author : HI-IR
 * email : qq2420226433@outlook.com
 * date : 2025/1/24 21:00
 */
@Dao
public interface UsersDao {
    @Insert()
    void InsertUser(UsersEntity user);//插入用户

    @Query("select id from users where username = :username")
    long GetId(String username);//查询用户id

    @Query("select username from users where id =:id")
    String getUserName(long id);
}
