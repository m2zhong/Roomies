package com.rip.roomies.activities.bills;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.rip.roomies.R;
import com.rip.roomies.activities.GenericActivity;
import com.rip.roomies.controllers.BillController;
import com.rip.roomies.events.bills.AddBillListener;
import com.rip.roomies.models.Bill;
import com.rip.roomies.views.BillContainer;

public class Bills extends GenericActivity {

    private final int EDIT_BILL_RESULT_CODE= 1;
    private final int ADD_BILL_RESULT_CODE = 2;
    private final int REQUEST_CODE = 1;


    private BillContainer youowe_bills_container;
    private BillContainer oweyou_bills_container;
    private Button addBill;
    private Bill theBillToEdit;


    private TextView aBillsName, aBillsDescription, aBillsAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bills);

        //set the Listeners which will set the controllers
        /* Linking xml objects to java */
        addBill = (Button) findViewById(R.id.add_bill_btn);
        youowe_bills_container = (BillContainer) findViewById(R.id.bills_youowe_container);
        oweyou_bills_container = (BillContainer) findViewById(R.id.bills_oweyou_container);

        addBill.setOnClickListener(new AddBillListener(this, youowe_bills_container,oweyou_bills_container));

        //populate list of bills
        BillController.populateBills(youowe_bills_container, oweyou_bills_container);
    }


    /**
     * This is called from one of the edit bill buttons listeners for a
     * particular bill. Will start the ModifyBill activity and will
     * send it the original fields for the bill, so the user can edit them.
     *
     * @param name The name of the person the user owes or has lent money to.
     * @param description The description for the bill.
     * @param amount The amount for the bill.
     *
     */
    public void toEditBillScreen(TextView name, TextView description, TextView amount, Bill theBillToEdit) {
        //grab the TextView's for this particular bill.
        aBillsAmount = amount;
        aBillsDescription = description;
        aBillsName = name;
        this.theBillToEdit = theBillToEdit;

        //Get ready for transferring to the Modify Bill activity.
        Intent intent = new Intent(getApplicationContext(), ModifyBill.class);

        //send the ModifyBill activity key-value pairs so that
        //when the activity starts, its EditText fields for name, desc,
        //and amount are filled correctly.
        intent.putExtra("Orig_Key_Name", name.getText());
        intent.putExtra("Orig_Key_Description", description.getText());
        intent.putExtra("Orig_Key_Amount", amount.getText());
        intent.putExtra("Key_Bill_Row_ID", String.valueOf(theBillToEdit.getRowID()));

        //Start the ModifyBill activity, when its finished, onActivityResult
        //will be called.
        startActivityForResult(intent, REQUEST_CODE);
    }

    public void toAddBillScreen() {
        startActivityForResult(new Intent(getApplicationContext(), AddBill.class), REQUEST_CODE);
    }



    /**
     * This is called from two places.
     * 1)From one of the edit bill buttons listeners for a
     * particular bill. Will start the ModifyBill activity and will
     * send it the original fields for the bill. So the user can edit them.
     * 2) From the Add a new Bill page when the user wants to submit the new bill and
     * go back to the main Bills page(ie this activity).
     *
     * @param data The updated Strings for the name, description, and amount.
     */
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode,resultCode,data);

        if(resultCode == EDIT_BILL_RESULT_CODE) {

            //Grab the updated Strings for the bills name, description, and
            //amount fields
            String updName = data.getStringExtra("Upd_Key_Name");
            String updDescription = data.getStringExtra("Upd_Key_Description");
            String updAmount = data.getStringExtra("Upd_Key_Amount");

            //reset the bills name,description,amount to whatever the user edited.
            theBillToEdit.setName(updName);
            theBillToEdit.setDescription(updDescription);
            theBillToEdit.setAmount(Float.parseFloat(updAmount));

            //reset the text for the 3 TextViews of the bill the user
            //selected in the main IOU's page.
            aBillsName.setText(updName);
            aBillsDescription.setText(updDescription);
            aBillsAmount.setText(updAmount);

            //update the DB bill entry
            BillController.getController().modifyBill(theBillToEdit);

        }
        else if(resultCode == ADD_BILL_RESULT_CODE) {
            String newName = data.getStringExtra("Key_New_Name");
            String newDescription = data.getStringExtra("Key_New_Description");
            String newAmount = data.getStringExtra("Key_New_Amount");

            //the args are all OK to be inserted into the database, ie amount is a parsable float
            BillController.getController().createBill(newName, newDescription, newAmount, youowe_bills_container,
                    oweyou_bills_container);
        }
    }

    @Override
    public void onBackPressed() {
        this.toHome();
    }

}
