package com.rip.roomies.models;

import com.rip.roomies.sql.SQLAdd;
import com.rip.roomies.sql.SQLCreate;
import com.rip.roomies.sql.SQLFind;
import com.rip.roomies.sql.SQLGet;
import com.rip.roomies.util.InfoStrings;

import java.util.logging.Logger;

/**
 * A class that represents a group of people that share housing together.
 */
public class Group {
	private String name = "";
	private String description = "";
    private int id;
	private User[] members;

	private static Group activeGroup;
	private static final Logger log = Logger.getLogger(Group.class.getName());

	//------- CONSTRUCTORS -------//

	/**
	 * Constructor that creates a new Group.
	 *
	 * @param name        The name of this Group.
	 * @param description The description of the Group.
	 */
	public Group(String name, String description) {
		this.name = name;
		this.description = description;
	}

    /**
     * Constructor that creates a new Group.
     *
     * @param id          This Group's unique id.
     * @param name        The name of this Group.
     * @param description The description of the Group.
     */
    public Group(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

	/**
	 * Constructor that creates a new Group.
	 *
	 * @param id          This Group's unique id.
	 * @param name        The name of this Group.
	 * @param description The description of the Group.
	 * @param members     The array of members that belong to this group
	 */
	public Group(int id, String name, String description, User[] members) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.members = members;
	}

	//------- DATABASE METHODS -------//

	/**
	 * Connects to the database, adding multiple users to the current group object and returning
	 * the result.
	 * @param users The list of users to add to this group
	 * @return The group returned by the SQL call
	 */
	public Group addUsers(User... users) {
		log.info(InfoStrings.ADD_USERS_TO_GROUP_MODEL);
		Group group = SQLAdd.addUsersToGroup(users, this);

		// We add members to this object in case it is already activeGroup
		if (group != null) {
			members = group.getMembers();
		}

		return group;
	}

	public Group getUsers() {
		log.info(InfoStrings.GET_GROUP_USERS_MODEL);
		Group group = SQLGet.getGroupUsers(this);

		return group;
	}

	/**
	 * Connects to the database, creating a new Group with the name and description used in this
	 * object's fields.
	 *
	 * @return The newly created Group.
	 */
	public Group createGroup(User user) {
		log.info(InfoStrings.CREATEGROUP_MODEL);
		return SQLCreate.createGroup(this, user);
	}

	/**
	 * Connects to the database and locates the Group with the properties of this group.
	 *
	 * @return The Group read from the database.
	 */
	public Group findGroup() {
		log.info(InfoStrings.JOINGROUP_MODEL);
		return SQLFind.findGroup(this);
	}

	/**
	 * Gets the duties that belong to this group.
	 * @return The array of duties
	 */
	public Duty[] getDuties() {
		log.info(InfoStrings.GET_GROUP_DUTIES_MODEL);
		return SQLGet.getGroupDuties(this);
	}

	//------- OBJECT METHODS -------//

	public static Group getActiveGroup() {
		return activeGroup;
	}

	public static void setActiveGroup(Group group) {
		activeGroup = group.getUsers();
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public int getId() {
		return id;
	}

	public User[] getMembers() {
		return members;
	}
}