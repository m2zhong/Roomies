package com.rip.roomies.models;

import com.rip.roomies.sql.SQLCreate;
import java.util.logging.Logger;

/**
 * Created by Kanurame on 5/2/2016.
 */
public class Group {
    private String name = "";
    private String description = "";

    private static final Logger log = Logger.getLogger(Group.class.getName());

    //------- CONSTRUCTORS -------//

    /**
     * Constructor that creates a new Group.
     * @param name The name of this Group.
     * @param description The description of the Group.
     */
    public Group(String name, String description) {
        this.name = name;
        this.description = description;
    }

    //------- DATABASE METHODS -------//

    /**
     * Connects to the database, creating a new Group with the name and description used in this
     * object's fields.
     * @return The newly created Group.
     */
    public Group createGroup() {
        return SQLCreate.createGroup(this);
    }

    //------- OBJECT METHODS -------//

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        //TODO
        return 0;
    }
}