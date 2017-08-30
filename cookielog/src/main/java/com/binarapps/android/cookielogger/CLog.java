package com.binarapps.android.cookielogger;

import android.content.Context;
import android.util.Log;

import com.binarapps.android.cookielogger.defs.StringKeys;
import com.binarapps.android.cookielogger.interfaces.CLogInterface;

import java.util.List;
import java.util.Map;


/**
 * Created by Cookie on 24.08.2017.
 */

public class CLog {

    public static final String TAG = "CLog";

    public static void initialize(Context context, CLogInterface send) {
        AppContext.initialize(context, send, false);
    }

    public static void initialize(Context context, CLogInterface send, boolean logToLogcat) {
        AppContext.initialize(context, send, logToLogcat);
    }

    public static void initialize(Context context, CLogInterface send, String tag) {
        AppContext.initialize(context, send, tag);
    }

    public static void d(String report) {
        d(report, AppContext.getInstance().logToLogcat);
    }

    public static void d(Map<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            d(entry.getKey() + StringKeys.VALUE_SEPARATOR + entry.getValue());
        }
    }
    public static void d(List<String> list) {
        for(String value : list) {
            d(value);
        }
    }

    public static void d(String report, boolean logToLogcat) {
        if(logToLogcat) Log.d(TAG, report);
        ReportStorageManager.updateReport(AppContext.getInstance().context, report);
    }

    public static void e(String report) {
        e(report, AppContext.getInstance().logToLogcat);
    }

    public static void e(Map<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            e(entry.getKey() + StringKeys.VALUE_SEPARATOR + entry.getValue());
        }
    }
    public static void e(List<String> list) {
        for(String value : list) {
            e(value);
        }
    }

    public static void e(String report, boolean logToLogcat) {
        if(logToLogcat) Log.e(TAG, report);
        ReportStorageManager.updateReport(AppContext.getInstance().context, report);
    }

    public static void printSingleReport() {
        ReportStorageManager.printSingleReport(AppContext.getInstance().context);
    }

    public static void sendSingleReport() {
        String report = ReportStorageManager.getSingleReport(AppContext.getInstance().context);
        ReportStorageManager.clearSingleReport(AppContext.getInstance().context);
        AppContext.getInstance().send.sendSingleReport(report);
    }

    public static void sendGlobalReport() {
        String report = ReportStorageManager.getGlobalReport(AppContext.getInstance().context);
        ReportStorageManager.clearSingleReport(AppContext.getInstance().context);
        AppContext.getInstance().send.sendGlobalReport(report);
    }
}
