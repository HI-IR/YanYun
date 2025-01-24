package com.example.yanyun.database.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * description ： 实体类，用户
 * author : HI-IR
 * email : qq2420226433@outlook.com
 * date : 2025/1/23 20:58
 */
@Entity(tableName = "users")
public class UsersEntity {
    @PrimaryKey
    private long id;

    @ColumnInfo(name = "public_name")
    private String publicName;

    @ColumnInfo(name = "username")
    private String username;


    public UsersEntity(@NonNull long id, String publicName, String username) {
        this.id = id;
        this.publicName = publicName;
        this.username = username;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPublicName() {
        return publicName;
    }

    public void setPublicName(String publicName) {
        this.publicName = publicName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
