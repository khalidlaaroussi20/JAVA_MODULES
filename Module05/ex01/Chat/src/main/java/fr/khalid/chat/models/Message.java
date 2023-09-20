package fr.khalid.chat.models;

import java.util.Date;

public class Message {
    private long _id;

    private String _text;

    public  User author;
    public  Room room;

    public Date date;


    public  Message(long id, String text, User author, Room room) {
        this._id = id;
        this._text = text;
        this.author = author;
        this.room = room;
        this.date = new Date();
    }

    public long getId() {
        return _id;
    }

    public String getText() {
        return _text;
    }



    public void setId(long _id) {
        this._id = _id;
    }

    public void setText(String _text) {
        this._text = _text;
    }



    @Override
    public String toString() {
        return "id = " + _id + "\ntext = " + _text  + "\ndata = " + date + "\n";
    }
}
