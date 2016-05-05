package com.rip.roomies.models;

/**
 * Created by Kanurame on 4/25/2016.
 */
public class User {
    private static User activeUser;

    public static User getActiveUser() {
        return activeUser;
    }

    //------- CONSTRUCTORS -------//

    public User(String username, String passwd) {

    }

    public User(int id, String username, String email) {

    }

    public User(String firstName, String lastName, String username, String email,
                String passwd) {

    }

    //------- DATABASE METHODS -------//

    public User addToGroup() {
        return null;
    }

    public User createUser() {
        return null;
    }

    public User login() {
        return null;
    }

    public boolean passRetrieve() {
        return false;
    }

    //------- OBJECT METHODS -------//

    public String getEmail() {
        return null;
    }

    public String getFirstName() {
        return null;
    }

    public int getGroupId() {
        return 0;
    }

    public int getId() {
        return 0;
    }

    public String getLastName() {
        return null;
    }

    public String getUsername() {
        return null;
    }
}
