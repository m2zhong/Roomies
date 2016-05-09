package com.rip.roomies.models;

import com.rip.roomies.sql.SQLCreate;
import com.rip.roomies.sql.SQLLogin;
import java.util.logging.Logger;

/**
 * Created by Kanurame on 4/25/2016.
 */
public class User {
    public int id = 0;
    public String firstName = "";
    public String lastName = "";
    public String username = "";
    public String email = "";
    private String password = "";
    public int room;

    private static User activeUser;
	private static final Logger log = Logger.getLogger(User.class.getName());

	public static User getActiveUser() {
		return activeUser;
	}

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

    public User addToGroup() {
        //TODO
        return null;
    }

    public User createUser() {
        return SQLCreate.createUser(this);
    }

    public User login() {
        User loggedIn = SQLLogin.login(this);

        if (loggedIn != null) {
            password = "";
            activeUser = this;
        }
        return loggedIn;
    }

    public boolean passRetrieve() {
        return SQLLogin.passRetrieve(this);
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

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getGroupId() {
        //TODO
        return 0;
    }

    public int getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
