package com.rip.roomies.models;

/**
 * Created by Kanurame on 4/25/2016.
 */
public class User {
    //------- CONSTRUCTORS -------//

    public User(String username, String passwd) {

    }

    public User(int id, String username, String email) {

    }

    public User(String firstName, String lastName, String username, String email,
                String passwd) {

    }

    //------- DATABASE METHODS -------//

    public boolean createUser() {
        return false;
    }

    public boolean login() {
        return false;
    }

    public boolean passRetrieve() {
        return false;
    }

    public boolean update() {
        return false;
    }

    //------- OBJECT METHODS -------//

    public void setFields(int id, String firstName, String lastName, String username,
                          String email) {

    }

    public void setRoom(int roomId) {

    }
}
