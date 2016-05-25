package com.rip.roomies.models;

import com.rip.roomies.sql.SQLCreate;
import com.rip.roomies.sql.SQLFind;
import com.rip.roomies.sql.SQLGet;
import com.rip.roomies.sql.SQLLogin;
import com.rip.roomies.util.InfoStrings;

import java.util.logging.Logger;

/**
 * This class represents a potential user of the Roomies system.
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
	 *
	 * @param username The User's login username.
	 * @param passwd   The User's password, as entered on the login screen.
	 */
	public User(String username, String passwd) {
		this.username = username;
		this.password = passwd;
	}

	/**
	 * Constructor used when retrieving a User's information from the database.
	 *
	 * @param id       The unique ID identifying this User in the database.
	 * @param username The User's login username.
	 * @param email    The email address used to contact this User.
	 */
	public User(int id, String username, String email) {
		this.id = id;
		this.username = username;
		this.email = email;
	}

	/**
	 * Constructor used when creating a User. Populates all fields except id.
	 *
	 * @param firstName The User's first name.
	 * @param lastName  The User's last name.
	 * @param username  The User's login username.
	 * @param email     The email address used to contact this User.
	 * @param passwd    The User's password used to login.
	 */
	public User(String firstName, String lastName, String username, String email,
	            String passwd) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.email = email;
		this.password = passwd;
	}

	/**
	 * Constructor used when creating a User. Populates all fields, including id.
	 *
	 * @param firstName The User's first name.
	 * @param lastName  The User's last name.
	 * @param username  The User's login username.
	 * @param email     The email address used to contact this User.
	 * @param passwd    The User's password used to login.
	 */
	public User(int id, String firstName, String lastName, String username, String email,
	            String passwd) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.email = email;
		this.password = passwd;
	}

	//------- DATABASE METHODS -------//

	public static boolean connect() {
		return SQLLogin.connect();
	}

	/**
	 * Connects to the database, logging in with information provided at the login prompt.
	 *
	 * @return The newly logged-in user.
	 */
	public User login() {
		log.info(InfoStrings.LOGIN_MODEL);
		User loggedIn = SQLLogin.login(this);

		if (loggedIn != null) {
			activeUser = loggedIn;
		}

		password = "";
		return loggedIn;
	}

	/**
	 * Logs off the user by removing the static activeUser field.
	 */
	public static void logoff() {
		log.info(InfoStrings.LOGOFF);
		activeUser = null;
	}

	/**
	 * Connects to the database, creating a new User with the information provided.
	 *
	 * @return The newly created User.
	 */
	public User createUser() {
		log.info(InfoStrings.CREATEUSER_MODEL);
		return SQLCreate.createUser(this);
	}

	/**
	 * Connects to the database, and attempts to find a user with one of the unique fields
	 * of this class.
	 * @return If found, the whole user will be returned. Otherwise, null is returned
	 */
	public User findUser() {
		log.info(InfoStrings.FIND_USER_MODEL);
		return SQLFind.findUser(this);
	}

	/**
	 * Connects to the database, and finds all of the Groups this User is in.
	 * @return Returns an array of Groups that this user is in.
	 */
	public Group[] getGroups() {
		return SQLGet.getGroups(this);
	}

	/**
	 * Connects to the database and emails the User their password, which they have forgotten.
	 *
	 * @return true if the information used to retrieve the password was valid.
	 */
	public boolean passRetrieve() {
		log.info(InfoStrings.PASSRETRIEVE_MODEL);
		return SQLLogin.passRetrieve(this);
	}

	/**
	 * Gets the duties that belong to a user in current group context.
	 * @param group The group object of the context
	 * @return The array of duties
	 */
	public Duty[] getDuties(Group group) {
		log.info(InfoStrings.GET_USER_DUTIES_MODEL);
		return SQLGet.getUserDuties(group, this);
	}

	//------- OBJECT METHODS -------//

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

	@Override
	public String toString() {
		return firstName + " " + lastName;
	}
}
