package com.rip.roomies.models;

import com.rip.roomies.sql.SQLCreate;

/**
 * Created by Kanurame on 5/2/2016.
 */
public class Group {
    String name = "";
    String description = "";

    //------- CONSTRUCTORS -------//

    public Group(String name, String description) {
        this.name = name;
        this.description = description;
    }

    //------- DATABASE METHODS -------//

    public Group createGroup() {
        return SQLCreate.createGroup(this);
    }

    //------- OBJECT METHODS -------//

    public String getDescription() {
        return description;
    }

    public int getId() {
        //TODO
        return 0;
    }

    public String getName() {
        return name;
    }
}
