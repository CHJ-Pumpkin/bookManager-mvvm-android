package com.a209350309.bookmanager;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

//实例化
@Entity(tableName = "book")
public class Book {
    @PrimaryKey(autoGenerate = true)
    private Long id;
    private String name;
    private String author;
    private float price;
    private String publish;

    public Book(Long id,String name, String author, float price, String publish) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.price = price;
        this.publish = publish;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getPublish() {
        return publish;
    }

    public void setPublish(String publish) {
        this.publish = publish;
    }
}
