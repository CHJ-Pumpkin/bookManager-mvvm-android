package com.a209350309.bookmanager;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface BookDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)//如果遇到冲突就执行替换策略
    public void insertBook(Book... books);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    public void updateBook(Book... books);

    @Delete
    public void deleteBook(Book... books);

    @Query("select * from book;")
    public List<Book> loadAll();

    @Query("select * from book where author like :author;")
    public List<Book> findBooks(String author);

    @Query("select * from book where id = :id")
    public Book findBookById(long id);
}
