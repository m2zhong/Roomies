package com.rip.roomies.activities.bills;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.rip.roomies.R;
import com.rip.roomies.activities.GenericActivity;

import java.text.DecimalFormat;

public class ModifyBill extends GenericActivity {

    private EditText name;
    private EditText description;
    private EditText amount;
    private Button submitChanges;
    private final int EDIT_BILL_RESULT_CODE = 1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_bill);

        //link xml objects to java
        name = (EditText) findViewById(R.id.editBillName);
        description = (EditText) findViewById(R.id.editBillDescription);
        amount = (EditText) findViewById(R.id.editBillAmount);
        submitChanges = (Button) findViewById(R.id.submitBillChanges);

        String nametext = getIntent().getStringExtra("Orig_Key_Name");
        String desctext = getIntent().getStringExtra("Orig_Key_Description");
        String amounttext = getIntent().getStringExtra("Orig_Key_Amount");
        int rowID = Integer.parseInt(getIntent().getStringExtra("Key_Bill_Row_ID"));

        name.setText(nametext);
        description.setText(desctext);
        amount.setText(amounttext);

        submitChanges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //check the modified arguments and make sure they're ok
                //if parseARgs returns false, means user entered in something wrong.
                if (!parseArgs(name.getText().toString(), description.getText().toString(),
                        amount.getText().toString(), amount)) {
                    return;
                }

                //all edited arguments are Valid, so now update the DB bill entry



                Intent intent = new Intent();
                intent.putExtra("Upd_Key_Name", name.getText().toString());
                intent.putExtra("Upd_Key_Description", description.getText().toString());
                intent.putExtra("Upd_Key_Amount", amount.getText().toString());
                setResult(EDIT_BILL_RESULT_CODE, intent);
                finish();
            }
        });
    }


    /**
     *
     *
     * @param name
     * @param description
     * @param amount
     * @return true if parseArgs failed, ie the user didnt enter in something.
     */

    public boolean parseArgs(String name, String description, String amount, EditText etAmount) {
        float tempFloat;
        DecimalFormat df = new DecimalFormat("#.00");

        //check the name first.
        if (name == "" || description == "" || amount == "") {
            //the number the entered for the amount had non-numeric chars
            Toast.makeText(getApplicationContext(), "Make sure all fields are filled.",
                    Toast.LENGTH_LONG).show();
        }

        try {
            tempFloat = Float.valueOf(amount);

            //now check to make sure it doesnt have hex values a-f.  valueof doesnt check that
            for (int i = 0; i < amount.length(); i++) {
                if (amount.charAt(i) > '9' || amount.charAt(i) < '0' && amount.charAt(i) != '.') {
                    throw new NumberFormatException();
                }
            }

        } catch (NumberFormatException e) {
            Toast.makeText(getApplicationContext(), "Please enter in a valid number for the amount.",
                    Toast.LENGTH_LONG).show();
            etAmount.setText("");
            return false;
        }
        return true;
    }




}
