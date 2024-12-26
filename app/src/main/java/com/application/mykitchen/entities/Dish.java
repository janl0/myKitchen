package com.application.mykitchen.entities;

import android.widget.TextView;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Dish
{
    @PrimaryKey
    public int uid;
    @ColumnInfo(name = "dish_title")
    public String dishTitle;
    @ColumnInfo(name = "dish_image")
    public int imageId;

    public String getDishTitle()
    {
        return dishTitle;
    }
}
