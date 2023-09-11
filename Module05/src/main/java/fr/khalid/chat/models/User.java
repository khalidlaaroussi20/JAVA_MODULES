package fr.khalid.chat.models;

import java.util.List;

public class User {
    private long _id;

    private String _login;

    private  String _password;


    public List<Room> createdRooms;

    public   List<Room> rooms;


    public  User(long id, String login, String password) {
        this._id = id;
        this._login = login;
        this._password = password;

    }

    public long getId() {
        return _id;
    }

    public String getLogin() {
        return _login;
    }

    public String getPassword() {
        return _password;
    }


    public void setId(long _id) {
        this._id = _id;
    }

    public void setLogin(String _login) {
        this._login = _login;
    }

    public void setPassword(String _password) {
        this._password = _password;
    }


    @Override
    public String toString() {
        return "id = " + _id + " login = " + _login + "\n\n";
    }
}


