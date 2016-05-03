package com.rip.roomies.models;

import com.rip.roomies.sql.SQLCreate;
import com.rip.roomies.sql.SQLLogin;

/**
 * Created by Kanurame on 4/25/2016.
 */
public class User {
    public static User loggedInUser;

    public int id = 0;
    public String firstName = "";
    public String lastName = "";
    public String username = "";
    public String email = "";
    private String password = "";
    public int room;

    //------- CONSTRUCTORS -------//

    public User(String username, String passwd) {
        this.username = username;
        this.password = passwd;
    }

    public User(int id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }

    public User(String firstName, String lastName, String username, String email,
                String passwd) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = passwd;
    }

    //------- DATABASE METHODS -------//

    public boolean createUser() {
        return SQLCreate.createUser(this);
    }

    public boolean login() {
        if (SQLLogin.login(this)) {
            password = "";
            loggedInUser = this;
            return true;
        }
        else
            return false;
    }

    public boolean passRetrieve() {
        return SQLLogin.passRetrieve(this);
    }

    public boolean update() {
        //TODO
        return false;
    }

    //------- OBJECT METHODS -------//

    public void setFields(int id, String firstName, String lastName, String username,
                          String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
    }

    public void setRoom(int roomId) {
        this.room = roomId;
    }
}
