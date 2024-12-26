package com.application.mykitchen.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.application.mykitchen.entities.Dish;

@Database(entities = {Dish.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase
{
    public abstract DishDAO dishDao();
}
