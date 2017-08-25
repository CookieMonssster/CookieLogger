package com.binarapps.android.example;

import android.util.Log;

import com.binarapps.android.cookielogger.interfaces.CLogInterface;

/**
 * Created by Cookie on 25.08.2017.
 */

public class SendReportApi implements CLogInterface {

    @Override
    public void sendSingleReport(String report) {
        Log.d("send", "Sending Single Report");
    }

    @Override
    public void sendGlobalReport(String report) {
        Log.d("send", "Sending Global Report");
    }
}
