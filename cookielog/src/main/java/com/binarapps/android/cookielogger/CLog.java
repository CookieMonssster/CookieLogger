package com.binarapps.android.cookielogger;

import android.content.Context;
import android.util.Log;

/**
 * Created by Cookie on 24.08.2017.
 */

public class CLog {

    public static final String TAG = "CLog";

    public static void initialize(Context context) {
        AppContext.initialize(context.getApplicationContext());
    }

    public static void d(String report) {
        Log.d(TAG, report);
        try {
            ReportStorageManager.updateReport(AppContext.getInstance(), report);
        } catch (NullPointerException e) {
            Log.e(TAG, "Initialize CLog first", e);
        }
    }

    public static void printSingleReport() {
        try {
            ReportStorageManager.printSingleReport(AppContext.getInstance());
        } catch (NullPointerException e) {
            Log.e(TAG, "Initialize CLog first", e);
        }
    }

}
