package com.rip.roomies.activities.duties;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.rip.roomies.activities.GenericActivity;
import com.rip.roomies.functions.ListDutyLogsFunction;
import com.rip.roomies.models.DutyLog;
import com.rip.roomies.views.DutyContainer;
import com.rip.roomies.R;
import com.rip.roomies.models.Duty;
import com.rip.roomies.util.DisplayStrings;

import java.util.logging.Logger;

/**
 * Created by Tony Phan on 5/26/2016.
 */
public class ListDutyLogs extends GenericActivity implements ListDutyLogsFunction
{
    private static final Logger log = Logger.getLogger(ListAllDuties.class.getName());
    DutyContainer dc;

    @Override
    public void onCreate(Bundle savedInstance) {

        super.onCreate(savedInstance);
        setContentView(R.layout.activity_duty_log);

		/* Linking xml objects to java */
        dc = (DutyContainer) findViewById(R.id.duty_list);

        final Activity self = this;



    }


    @Override
    public void ListDutyLogsFail() {
        Toast.makeText(this, DisplayStrings.LOG_DUTY_FAIL, Toast.LENGTH_LONG).show();
    }

    @Override
    public void ListDutyLogsSuccess(DutyLog[] duties)
    {
        for (Duty d : duties) {
            dc.addDuty(d);
        }
    }
}
