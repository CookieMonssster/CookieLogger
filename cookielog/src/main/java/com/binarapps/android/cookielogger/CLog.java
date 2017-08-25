package com.binarapps.android.cookielogger;

import android.content.Context;
import android.util.Log;

import com.binarapps.android.cookielogger.interfaces.CLogInterface;


/**
 * Created by Cookie on 24.08.2017.
 */

public class CLog {

    public static final String TAG = "CLog";

    public static void initialize(Context context, CLogInterface send) {
        AppContext.initialize(context.getApplicationContext(), send);
    }

    public static void d(String report) {
        Log.d(TAG, report);
        ReportStorageManager.updateReport(AppContext.getInstance().context, report);
    }

    public static void printSingleReport() {
        ReportStorageManager.printSingleReport(AppContext.getInstance().context);
    }

    public static void sendSingleReport() {
        String report = ReportStorageManager.getSingleReport(AppContext.getInstance().context);
        AppContext.getInstance().send.sendSingleReport(report);
    }

    public static void sendGlobalReport() {
        String report = ReportStorageManager.getGlobalReport(AppContext.getInstance().context);
        AppContext.getInstance().send.sendGlobalReport(report);
    }

}
