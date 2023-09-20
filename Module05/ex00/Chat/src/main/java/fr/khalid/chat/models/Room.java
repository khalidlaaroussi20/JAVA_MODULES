package fr.khalid.chat.models;

import java.util.List;

public class Room {

    private long _id;

    private String _name;

    private  User _owner;


    public  List<Message> messages;

    public  Room(long id, String login, User owner) {
        this._id = id;
        this._name = login;
        this._owner = owner;
    }

    public long getId() {
        return _id;
    }

    public String getName() {
        return _name;
    }

    public User getOwner() {
        return _owner;
    }


    public void setId(long _id) {
        this._id = _id;
    }

    public void setName(String _name) {
        this._name = _name;
    }

    public void setOwner(User owner) {
        this._owner = owner;
    }


    @Override
    public String toString() {
        return "id = " + _id + " roomName = " + _name + " owner: \n     "+ _owner + "\n\n";
    }
}
