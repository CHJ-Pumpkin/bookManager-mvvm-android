package com.a209350309.bookmanager;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Book.class},exportSchema = false,version = 1)
abstract public class BookDatabase extends RoomDatabase {
    public static BookDatabase INSTANCE=null;
    public final static String DB_NAME="book.db";
    //确保整个程序里数据对象只有一份，单实例模式
    public static BookDatabase getInstance(Context context){
        if (INSTANCE==null){
            INSTANCE= Room.databaseBuilder(context,BookDatabase.class,DB_NAME)
                    .allowMainThreadQueries()//
                    .build();//
        }
        return INSTANCE;
    }

    public abstract BookDao bookDao();

}
