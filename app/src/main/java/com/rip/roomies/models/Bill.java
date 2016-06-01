package com.rip.roomies.models;

import com.rip.roomies.sql.SQLCreate;
import com.rip.roomies.sql.SQLGet;
import com.rip.roomies.sql.SQLModify;
import com.rip.roomies.sql.SQLRemove;
import com.rip.roomies.util.InfoStrings;

import java.text.DecimalFormat;
import java.util.logging.Logger;

/**
 * Created by VinnysMacOS on 5/21/16.
 */
public class Bill {

    private int ownerID = 0;
    private int rowID = 0;
    private String name = "";
    private String description = "";
    private float amount = 0;

   // private static User activeUser;
    private static final Logger log = Logger.getLogger(Bill.class.getName());

    //------- CONSTRUCTORS -------//

    public Bill() {}

    /**
     * Constructor used when logging in. Constructs the current active user using only the
     * information provided at the Login prompt.
     *
     * @param name The name associated with this bill.
     * @param description The descipriton associated with this bill.
     * @param amount The amount associated with this bill.
     */
    public Bill(String name, String description, float amount) {
        this.name = name;
        this.description = description;
        this.amount = amount;
    }


    /**
     * Constructor used when returning a Bill inserted into the DB from SQLCreate.createBill
     *
     * @param ownerID The ownerID from the resultset returned from the CreateBill SQL procedure.
     * @param rowID The unique bill ID.
     * @param name The name associated with this bill.
     * @param description The description associated with this bill.
     * @param amount The amount associated with this bill.
     */
    public Bill(int ownerID, int rowID, String name, String description, float amount) {
        this.ownerID = ownerID;
        this.rowID = rowID;
        this.name = name;
        this.description = description;
        this.amount = amount;
    }


    //------- DATABASE METHODS -------//

    /**
     * Connects to the database, creating a new Bill with the information provided.
     *
     * @return The newly created Bill.
     */
    public Bill createBill() {
        log.info(InfoStrings.CREATEBILL_MODEL);

        return SQLCreate.createBill(this);
    }

    public Bill removeBill(int rowID) {
        //log statement
        return SQLRemove.removeBill(rowID);
    }

    public void modifyBill(Bill billToModify) {
        SQLModify.modifyBill(billToModify);
    }

    public static CharSequence getTotalBalance() {
        log.info(InfoStrings.GET_BILLS_MODEL);
        Bill[] bills = SQLGet.getUserBills(User.getActiveUser());
        float total = 0;

        if (bills != null) {
            for (Bill bill : bills) {
                total += bill.getAmount();
            }
        }

        DecimalFormat cash = new DecimalFormat("$#");
        return cash.format(total);
    }

    public static CharSequence getNegativeBalance() {
        log.info(InfoStrings.GET_BILLS_MODEL);
        Bill[] bills = SQLGet.getUserBills(User.getActiveUser());
        float total = 0;

        if (bills != null) {
            for (Bill bill : bills) {
                if (bill.getAmount() < 0)
                    total -= bill.getAmount();
            }
        }

        DecimalFormat cash = new DecimalFormat("$#");
        return cash.format(total);
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



    //-------------Getter/setter methods------------//

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public float getAmount() { return amount; }

    public int getOwnerID() { return ownerID; }

    public int getRowID() { return rowID; }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public void setDescription(String newDescription) {
        this.description = newDescription;
    }
}
