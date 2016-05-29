package com.rip.roomies.functions;

import com.rip.roomies.models.Duty;
import com.rip.roomies.models.DutyLog;

/**
 * Created by Tony Phan on 5/26/2016.
 */
public interface ListDutyLogsFunction
{
    void ListDutyLogsFail();
    void ListDutyLogsSuccess(DutyLog[] duties);
}
