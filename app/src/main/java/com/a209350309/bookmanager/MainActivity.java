package com.a209350309.bookmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener {

    //    private BookDatabase database;
    private BookAdapter adapter;
    private BookViewModel viewModel;

    private View.OnClickListener clickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Book book=(Book)v.getTag();
            Intent intent=new Intent(MainActivity.this,BookEditActivity_bak.class);
            long bookId=book.getId();
            intent.putExtra("BOOKID",bookId);
            viewModel.setCurrentBook(book);
            startActivity(intent);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //实例化BookViewModel对象
        viewModel = new ViewModelProvider(this).get(BookViewModel.class);

        //初始化数据库
//        database=BookDatabase.getInstance(this);
        //给按钮绑定点击事件
        findViewById(R.id.floatingAdd).setOnClickListener(this);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,
                RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

//        adapter = new BookAdapter();
        adapter = new BookAdapter(this,clickListener);
        adapter.setLongClickListener(this);
        recyclerView.setAdapter(adapter);

        viewModel.getData().observe(this, new Observer<List<Book>>() {
            @Override
            public void onChanged(List<Book> books) {
                adapter.setDataChange((ArrayList<Book>) books);
            }
        });


    }

    @Override
    public boolean onLongClick(View v) {
        Book book=(Book) v.getTag();
        viewModel.deleteBook(book);
        return false;
    }

    @Override
    protected void onStart() {
        super.onStart();
        viewModel.loadbooks();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
//        BookDao bookDao=database.bookDao();
//        ArrayList<Book> books=(ArrayList)bookDao.loadAll();
//        adapter.setDataChange(books);
    }


    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, BookEditActivity_bak.class);
        startActivity(intent);
//        long id=(long)Math.random();
//        Book book=new Book(id,"Android Programming","Add",98.0f,"def");
//        BookDao bookDao=database.bookDao();
//        bookDao.insertBook(book);
//        ArrayList<Book> books=(ArrayList)bookDao.loadAll();
//        adapter.setDataChange(books);
    }
}