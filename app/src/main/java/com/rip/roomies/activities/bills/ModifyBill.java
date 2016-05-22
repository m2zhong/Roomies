package com.rip.roomies.activities.bills;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.rip.roomies.R;
import com.rip.roomies.activities.GenericActivity;

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

        name.setText(nametext);
        description.setText(desctext);
        amount.setText(amounttext);

        submitChanges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("Upd_Key_Name", name.getText().toString());
                intent.putExtra("Upd_Key_Description", description.getText().toString());
                intent.putExtra("Upd_Key_Amount", amount.getText().toString());
                setResult(EDIT_BILL_RESULT_CODE, intent);
                finish();
            }

        });

    }





}
