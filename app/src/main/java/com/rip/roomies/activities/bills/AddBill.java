package com.rip.roomies.activities.bills;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.rip.roomies.R;
import com.rip.roomies.activities.GenericActivity;

public class AddBill extends GenericActivity {

    private EditText name;
    private EditText description;
    private EditText amount;
    private Button submitNewBill;

    private final int RESULT_CODE_ADD_BILL = 2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_bill);

        //link xml objects to java
        name = (EditText) findViewById(R.id.addBillName);
        description = (EditText) findViewById(R.id.addBillDescription);
        amount = (EditText) findViewById(R.id.addBillAmount);
        submitNewBill = (Button) findViewById(R.id.submitNewBill);


        submitNewBill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("Key_New_Name", name.getText().toString());
                intent.putExtra("Key_New_Description", description.getText().toString());
                intent.putExtra("Key_New_Amount", amount.getText().toString());
                setResult(RESULT_CODE_ADD_BILL, intent);
                finish();
            }

        });


    }

}
