package com.rip.roomies.events.goods;

import android.view.View;

import com.rip.roomies.activities.GenericActivity;
import com.rip.roomies.models.Good;
import com.rip.roomies.server.ServerRequest;
import com.rip.roomies.util.InfoStrings;

import java.net.URISyntaxException;
import java.util.logging.Logger;

/**
 * Created by Han on 6/2/2016.
 */
public class RemindGoodListener implements View.OnClickListener {
    private static final Logger log = Logger.getLogger(RemindGoodListener.class.getName());

    private int receiverID;
    private GenericActivity activity;
    private Good good;

    /**
     * Complete Good Listener Constructor
     *
     * @param context  Activity that is using the listener
     * @param receiverID  The ID of the person you want to remind
     */
    public RemindGoodListener(GenericActivity context, int receiverID, Good good) {
        this.receiverID = receiverID;
        this.activity = context;
        this.good = good;
    }

    /**
     * completeGood.onClickListener
     *
     * @param v the View object passed in by ViewGood activity
     */
    @Override
    public void onClick(View v) {
        try {
            ServerRequest.remindDuty(receiverID, good.getName());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        log.info(InfoStrings.REMIND_GOOD_EVENT);
    }

}
