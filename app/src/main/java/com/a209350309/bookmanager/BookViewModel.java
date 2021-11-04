package com.a209350309.bookmanager;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class BookViewModel extends AndroidViewModel {
    //定义一个存储数据的容器MutableLiveData
    private MutableLiveData<List<Book>> data;
    //数据库对象成员
    private BookDatabase database;

    private Book currentBook;

    public BookViewModel(@NonNull Application application) {
        super(application);
        database = BookDatabase.getInstance(application);
    }

    public MutableLiveData<List<Book>> getData() {
        if (data == null) {
            data = new MutableLiveData<>();
        }
        return data;
    }

    public void loadbooks() {
        List<Book> result = database.bookDao().loadAll();
        getData().setValue(result);
    }

    public void addBook(Book... books) {
        database.bookDao().insertBook(books);
        loadbooks();
    }

    public void deleteBook(Book... books) {
        database.bookDao().deleteBook(books);
        loadbooks();
    }

    public Book getBook(long id) {
        return database.bookDao().findBookById(id);
    }

    public void setCurrentBook(Book book) {
        this.currentBook = book;
    }

    public Book getCurrentBook() {
        return currentBook;
    }
}
