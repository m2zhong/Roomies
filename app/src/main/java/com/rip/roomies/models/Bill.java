package com.rip.roomies.models;

import com.rip.roomies.sql.SQLCreate;
import com.rip.roomies.sql.SQLLogin;
import com.rip.roomies.util.InfoStrings;

import java.util.logging.Logger;

/**
 * Created by VinnysMacOS on 5/21/16.
 */
public class Bill {

    private int id = 0;
    private String name = "";
    private String description = "";
    private int amount = 0;


   // private static User activeUser;
    private static final Logger log = Logger.getLogger(Bill.class.getName());

    //------- CONSTRUCTORS -------//

    /**
     * Constructor used when logging in. Constructs the current active user using only the
     * information provided at the Login prompt.
     *
     * @param name The name associated with this bill.
     * @param description The descipriton associated with this bill.
     * @param amount The amount associated with this bill.
     */
    public Bill(String name, String description, int amount) {
        this.name = name;
        this.description = description;
        this.amount = amount;
    }

    /**
     * Constructor used when returning a Bill inserted into the DB from SQLCreate.createBill
     *
     * @param id The id from the resultset returned from the CreateBill SQL procedure.
     * @param name The name associated with this bill.
     * @param description The description associated with this bill.
     * @param amount The amount associated with this bill.
     */
    public Bill(int id, String name, String description, int amount) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.amount = amount;
    }


    //------- DATABASE METHODS -------//

    public static boolean connect() {
        return SQLLogin.connect();
    }


    /**
     * Connects to the database, creating a new Bill with the information provided.
     *
     * @return The newly created Bill.
     */
    public Bill createBill() {
        log.info(InfoStrings.CREATEBILL_MODEL);
        return SQLCreate.createBill(this);
    }

    /**
     * Connects to the database, and attempts to find a user with one of the unique fields
     * of this class.
     * @return If found, the whole user will be returned. Otherwise, null is returned
     */
//    public User findUser() {
//        log.info(InfoStrings.FIND_USER_MODEL);
//        return SQLFind.findUser(this);
//    }



    //------- OBJECT METHODS -------//



    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getAmount() { return amount; }

    public int getId() {
        return id;
    }


    //ehh
//    public static User getActiveUser() {
//        return activeUser;
//    }

}
