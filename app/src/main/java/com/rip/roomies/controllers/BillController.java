package com.rip.roomies.controllers;

import android.os.AsyncTask;

import com.rip.roomies.models.Bill;
import com.rip.roomies.util.InfoStrings;
import com.rip.roomies.views.BillContainer;

import java.util.Locale;
import java.util.logging.Logger;

/**
 * Created by VinnysMacOS on 5/22/16.
 */
public class BillController {
    private static final Logger log = Logger.getLogger(BillController.class.getName());

    private static BillController controller;
    private BillContainer bills;

    /**
     * Gets the singleton bill controller.
     * @return The bill controller
     */
    public static BillController getController() {
        if (controller == null) {
            controller = new BillController();
        }

        return controller;
    }

    public void createBill(final String name, final String description, final String amount, final BillContainer bills) {
        this.bills = bills;

        // Create and run a new thread
        new AsyncTask<Void, Void, Bill>() {
            @Override
            protected Bill doInBackground(Void... v) {
                log.info(String.format(Locale.US, InfoStrings.CREATEBILL_CONTROLLER,
                        name, description, Float.parseFloat(amount)));

                // Create request user and get response from createUser()
                Bill request = new Bill(name, description, Float.parseFloat(amount));
                Bill response = request.createBill();
                return response;
            }

            @Override
            protected void onPostExecute(Bill result) {
                //if the bill returned wasnt null, add it to the container
                if (result != null) {
                    //add the bill returned from the DB to the BillContainer. Has uniq bill id, owner id, name, desc, amount...
                    bills.addBill(result);
                }
            }
        }.execute();
    }

    public void removeBill(final int billRowID) {
        // Create and run a new thread
        new AsyncTask<Void, Void, Bill>() {
            @Override
            protected Bill doInBackground(Void... v) {
               // log.info(String.format(Locale.US, InfoStrings.CREATEBILL_CONTROLLER,
                //        name, description, Float.parseFloat(amount)));

                // Create request user and get response from createUser()
                Bill request = new Bill();
                return request.removeBill(billRowID);
            }

            @Override
            protected void onPostExecute(Bill result) {
                //if the bill returned wasnt null,remove it from the billcontainer
                if (result != null) {
                    //remove the bill from the BillContainer.
                    bills.removeBill(result);
                }
            }
        }.execute();

    }


}
