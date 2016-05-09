package com.rip.roomies.models;

import com.rip.roomies.sql.SQLCreate;
import com.rip.roomies.sql.SQLLogin;
import java.util.logging.Logger;

/**
 * Created by Kanurame on 4/25/2016.
 */
public class User {
    private int id = 0;
    private String firstName = "";
    private String lastName = "";
    private String username = "";
    private String email = "";
    private String password = "";

    private static User activeUser;
	private static final Logger log = Logger.getLogger(User.class.getName());

	//------- CONSTRUCTORS -------//

    /**
     * Constructor used when logging in. Constructs the current active user using only the
     * information provided at the Login prompt.
     * @param username The User's login username.
     * @param passwd The User's password, as entered on the login screen.
     */
    public User(String username, String passwd) {
        this.username = username;
        this.password = passwd;
    }

    /**
     * Constructor used when retrieving a User's information from the database.
     * @param id The unique ID identifying this User in the database.
     * @param username The User's login username.
     * @param email The email address used to contact this User.
     */
    public User(int id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }

    /**
     * Constructor used when creating a User. Populates all fields except id.
     * @param firstName The User's first name.
     * @param lastName The User's last name.
     * @param username The User's login username.
     * @param email The email address used to contact this User.
     * @param passwd The User's password used to login.
     */
    public User(String firstName, String lastName, String username, String email,
                String passwd) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = passwd;
    }

	//------- DATABASE METHODS -------//

    /**
     * Connects to the database, logging in with information provided at the login prompt.
     * @return The newly logged-in user.
     */
    public User login() {
        User loggedIn = SQLLogin.login(this);

        if (loggedIn != null) {
            password = "";
            activeUser = this;
        }
        return loggedIn;
    }

    /**
     * Connects to the database, adding this User to an existing Group.
     * @return The new User instance, with its Group set.
     */
    public User addToGroup() {
        //TODO
        return null;
    }

    /**
     * Connects to the database, creating a new User with the information provided.
     * @return The newly created User.
     */
    public User createUser() {
        return SQLCreate.createUser(this);
    }

    /**
     * Connects to the database and emails the User their password, which they have forgotten.
     * @return true if the information used to retrieve the password was valid.
     */
    public boolean passRetrieve() {
        return SQLLogin.passRetrieve(this);
    }

	//------- OBJECT METHODS -------//

    /**
     * Unified mutator, setting all fields except for the password.
     * @param id The unique ID identifying this User in the database.
     * @param firstName The User's first name.
     * @param lastName The User's last name.
     * @param username The User's login username.
     * @param email The email address used to contact this User.
     */
    public void setFields(int id, String firstName, String lastName, String username,
                          String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
    }

    public static User getActiveUser() {
        return activeUser;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getId() {
        return id;
    }

    public int getGroupId() {
        //TODO
        return 0;
    }
}
