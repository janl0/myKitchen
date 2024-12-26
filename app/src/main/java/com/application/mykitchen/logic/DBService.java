package com.application.mykitchen.logic;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.application.mykitchen.entities.Consumable;

public class DBService extends SQLiteOpenHelper {
    private Context context;
    private static final String DATABASE_NAME = "MyKitchen.db";
    private static final int DATABASE_VERSION = 1;

    // DISH-Table
    private static final String DISH_TABLE_NAME = "dish";
    private static final String DISH_COLUMN_ID = "id";
    private static final String DISH_COLUMN_TITLE = "dish_title";
    private static final String DISH_COLUMN_IMG = "image_rsc";

    // CONSUMABLES-Table
    private static final String CONS_TABLE_NAME = "cons";
    private static final String CONS_COLUMN_ID = "id";
    private static final String CONS_COLUMN_NAME = "name";
    private static final String CONS_COLUMN_SURNAME = "surname";
    private static final String CONS_COLUMN_IMG = "image_src";
    private static final String CONS_COLUMN_QUANT = "quant";
    private static final String CONS_COLUMN_UNIT = "unit";

    public DBService(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(@NonNull SQLiteDatabase db) {
        String queryDishTable =
                "CREATE TABLE " + DISH_TABLE_NAME +
                        " (" + DISH_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        DISH_COLUMN_TITLE + " TEXT, " +
                        DISH_COLUMN_IMG + " INTEGER);";

        String queryConsTable =
                "CREATE TABLE " + CONS_TABLE_NAME +
                        " (" + CONS_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        CONS_COLUMN_NAME + " TEXT, " +
                        CONS_COLUMN_SURNAME + " TEXT, " +
                        CONS_COLUMN_IMG + " INTEGER, " +
                        CONS_COLUMN_QUANT + " TEXT, " +
                        CONS_COLUMN_UNIT + " INTEGER);";
        db.execSQL(queryDishTable);
        db.execSQL(queryConsTable);
    }

    @Override
    public void onUpgrade(@NonNull SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + DISH_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + CONS_TABLE_NAME);
        onCreate(db);
    }

    /**
     * Methode zum Speichern von Cosumable-Objekten in der Datenbank mit Prüfung
     * ob Objekt schon existiert
     *
     * @param cons Consumable-Objekt welches in der Datenbank gespeichert werden soll
     */
    public void addConsumable(@NonNull Consumable cons)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        /*
        Cursor c = db.rawQuery("SELECT * FROM " + CONS_TABLE_NAME +
                " WHERE " + CONS_COLUMN_NAME + " = " +
                cons.getName().trim() + ";", null);
        c.moveToFirst();

        if (c.getCount() != 0)
            return;

         */
        ContentValues cv = new ContentValues();

        cv.put(CONS_COLUMN_NAME, cons.getName());
        cv.put(CONS_COLUMN_SURNAME, cons.getSurname() != null ? cons.getSurname() : "");
        // TODO: BIlder hinzufügen
        cv.put(CONS_COLUMN_QUANT, cons.getQuant());
        cv.put(CONS_COLUMN_UNIT, cons.getUnit());

        long result = db.insert(CONS_TABLE_NAME, null, cv);

        if(result == -1)
            System.err.println("Beim einsetzten von: " + cons.getName() + " ist etwas schiefgelaufen");
        else
            System.out.println("Erfolgreich gespeichert");
    }

    public void loadConsumable()
    {
        SQLiteDatabase db = this.getReadableDatabase();
    }
}
