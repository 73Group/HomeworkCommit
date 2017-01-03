package com.example.cx.ui;

/**
 * Created by cx on 17/1/3.
 */

public class Item {

    public Item(String name, String size, String content,int id) {
        this.name = name;
        this.size = size;
        this.content = content;
        this.drawableId = id;

    }
    public String name;
    public String size;
    public String content;
    public int drawableId;
}
