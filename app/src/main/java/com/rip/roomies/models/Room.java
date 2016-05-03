package com.rip.roomies.models;

import com.rip.roomies.sql.SQLCreate;
import com.rip.roomies.sql.SQLFind;

/**
 * Created by Kanurame on 5/2/2016.
 */
public class Room {
    String name = "";

    //------- CONSTRUCTORS -------//

    public Room(String name) {
        this.name = name;
    }

    //------- DATABASE METHODS -------//

    public boolean createRoom() {
        return SQLCreate.createRoom(this);
    }

    public boolean findRoom() {
        return SQLFind.findRoom(this);
    }

    //------- OBJECT METHODS -------//
}
