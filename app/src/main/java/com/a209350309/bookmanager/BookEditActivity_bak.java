package com.a209350309.bookmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import java.util.ArrayList;

public class BookEditActivity_bak extends AppCompatActivity implements View.OnClickListener {

    private  BookViewModel viewModel;
    private long curId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_edit_bak);
        findViewById(R.id.btnOk).setOnClickListener(this);
        findViewById(R.id.btnCance).setOnClickListener(this);

        viewModel=new ViewModelProvider(this).get(BookViewModel.class);

        Intent intent=getIntent();
        long bookId=intent.getLongExtra("BOOKID",0);

        Book book=viewModel.getBook(bookId);
        if (book!=null){
            curId=book.getId();
            EditText etName = findViewById(R.id.etName);
            etName.setText(book.getName());

            EditText etAuthor = findViewById(R.id.etAuthor);
            etAuthor.setText(book.getAuthor());

            EditText etPublish = findViewById(R.id.etPublish);
            etPublish.setText(book.getPublish());

            EditText etPrice = findViewById(R.id.etPrice);
            etPrice.setText(String.valueOf(book.getPrice()));

        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnOk:
                insertBook();
                finish();
                break;
            case R.id.btnCance:
                finish();
                break;
        }
    }

    private void insertBook(){
        EditText etName=findViewById(R.id.etName);
        String bookName=etName.getText().toString();

        EditText etAuthor=findViewById(R.id.etAuthor);
        String bookAuthor=etAuthor.getText().toString();

        EditText etPublish=findViewById(R.id.etPublish);
        String bookPublish=etPublish.getText().toString();

        EditText etPrice=findViewById(R.id.etPrice);
        float bookPrice=Float.parseFloat(etPrice.getText().toString());
        Long id=null;
        if (curId>0)id=curId;
        Book book =new Book(id,bookName,bookAuthor,bookPrice,bookPublish);

        viewModel.addBook(book);
//        BookDatabase database=BookDatabase.getInstance(this);
//        BookDao bookDao=database.bookDao();
//        bookDao.insertBook(book);
        

    }
}