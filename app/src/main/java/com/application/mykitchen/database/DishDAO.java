package com.application.mykitchen.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import com.application.mykitchen.entities.Dish;
import java.util.List;

@Dao
public interface DishDAO
{
    @Query("SELECT * FROM dish")
    List<Dish> getAll();

    @Query("SELECT * FROM dish WHERE uid IN (:dishIds)")
    List<Dish> loadAllByIds(int[] dishIds);

    @Query("SELECT * FROM dish WHERE dish_title LIKE :title LIMIT 1")
    Dish findByName(String title);

    @Insert
    void insertAll(Dish... dishes);

    @Delete
    void delete(Dish dish);
}
