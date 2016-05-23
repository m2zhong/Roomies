package com.rip.roomies.controllers;

import android.os.AsyncTask;

import com.rip.roomies.models.Bill;
import com.rip.roomies.views.BillContainer;

import java.util.logging.Logger;

/**
 * Created by VinnysMacOS on 5/22/16.
 */
public class BillController {
    private static final Logger log = Logger.getLogger(BillController.class.getName());

    private static BillController controller;

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

        // Create and run a new thread
        new AsyncTask<Void, Void, Bill>() {
            @Override
            protected Bill doInBackground(Void... v) {
            //    log.info(String.format(Locale.US, InfoStrings.CREATEUSER_CONTROLLER,
             //           lastName, firstName, username, email));

                // Create request user and get response from createUser()
                Bill request = new Bill(name, description, Float.parseFloat(amount));
                Bill response = request.createBill();
                return response;
            }

            @Override
            protected void onPostExecute(Bill result) {
                // If fail, call fail callback. Otherwise, call success callback
                if (result != null) {
                    bills.addBill(result);
                }

            }
        }.execute();




    }


}
