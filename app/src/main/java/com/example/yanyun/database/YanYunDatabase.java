package com.example.yanyun.database;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.yanyun.database.dao.FavoriteDao;
import com.example.yanyun.database.dao.UsersDao;
import com.example.yanyun.database.entity.FavoriteEntity;
import com.example.yanyun.database.entity.UsersEntity;

/**
 * description ： 言韵数据库，单例设计
 * 获得UsersDao，获得FavoriteDao
 * author : HI-IR
 * email : qq2420226433@outlook.com
 * date : 2025/1/24 00:04
 */
@Database(entities = {FavoriteEntity.class, UsersEntity.class},version = 1,exportSchema = false)
public abstract class YanYunDatabase extends RoomDatabase {

    public abstract UsersDao getUsersDao();
    public abstract FavoriteDao getFavoriteDao();

    //写静态内部类,该类中有一个静态属性
    private static class DatabaseHolder{
        private static YanYunDatabase yanyun_database = Room.databaseBuilder(MyApplication.getContext(), YanYunDatabase.class, "yanyun_database").build();//打开数据库
    }

    public static YanYunDatabase getDatabase(){
        return DatabaseHolder.yanyun_database;
    }
}
