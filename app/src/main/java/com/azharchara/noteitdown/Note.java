package com.azharchara.noteitdown;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * Created by Azhar Chara on 22/08/17.
 */
@Table(database = DatabaseHandler.class)
public class Note extends BaseModel {

    //private variables
    @Column
    @PrimaryKey (autoincrement = true)
    int id;

    @Column
    String title;

    @Column
    String Content;

    @Column
    String date;

    public Note(int id, String title, String Content, String date){
        this.id = id;
        this.title = title;
        this.Content = Content;
        this.date = date;
    }

    //default constructor
    public Note() {}

    //getters & setters
    public int getID(){
        return this.id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
