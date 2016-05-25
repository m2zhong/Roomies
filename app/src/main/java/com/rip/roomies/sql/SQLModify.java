package com.rip.roomies.sql;

import com.rip.roomies.models.Bill;
import com.rip.roomies.util.Exceptions;
import com.rip.roomies.util.SQLStrings;

import java.util.Locale;
import java.util.logging.Logger;

/**
 * Created by Kanurame on 5/19/2016.
 */
public class SQLModify {
    private static final Logger log = Logger.getLogger(SQLModify.class.getName());


    public static void modifyBill(Bill billToModify) {

        try {
            SQLQuery.execute(String.format(Locale.US, SQLStrings.MODIFY_BILL_SQL, billToModify.getRowID(),
                    billToModify.getName(), billToModify.getDescription(),
                    billToModify.getAmount()));
        } catch (Exception e) {
            log.severe(Exceptions.stacktraceToString(e));
            return;
        }

    }

}
