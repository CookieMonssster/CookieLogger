package com.binarapps.android.cookielogger;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

/**
 * Created by Cookie on 25.08.2017.
 */

class ReportStorageManager {

    private static final String CLOG_PREFERENCES = "CLog_preferences";
    private static final String SINGLE_REPORT = "single_report";
    private static final String GLOBAL_REPORT = "global_report";
    private static final String EMPTY_STRING = "";
    private static final String NEW_LINE = "\n";

    protected static void updateReport(Context context, String reportLine) {
        StringBuilder singleReport = new StringBuilder(getPrefs(context).getString(SINGLE_REPORT, EMPTY_STRING));
        StringBuilder globalReport = new StringBuilder(getPrefs(context).getString(GLOBAL_REPORT, EMPTY_STRING));
        singleReport.append(NEW_LINE);
        globalReport.append(NEW_LINE);
        singleReport.append(reportLine);
        globalReport.append(reportLine);

        getPrefs(context).edit().putString(SINGLE_REPORT, singleReport.toString()).commit();
        getPrefs(context).edit().putString(GLOBAL_REPORT, globalReport.toString()).commit();
    }

    protected static String getSingleReport(Context context) {
        return getPrefs(context).getString(SINGLE_REPORT, EMPTY_STRING);
    }

    protected static void printSingleReport(Context context) {
        Log.d(CLog.TAG, getSingleReport(context));
    }

    protected static String getGlobalReport(Context context) {
        return getPrefs(context).getString(GLOBAL_REPORT, EMPTY_STRING);
    }

    protected static void printGlobalReport(Context context) {
        Log.d(CLog.TAG, getGlobalReport(context));
    }

    protected static void clearSingleReport(Context context) {
        clearReport(context, SINGLE_REPORT);
    }

    protected static void clearGlobalReport(Context context) {
        clearReport(context, GLOBAL_REPORT);
    }

    private static void clearReport(Context context, String report) {
        getPrefs(context).edit().putString(report, EMPTY_STRING).commit();
    }

    protected static SharedPreferences getPrefs(Context context) {
        return context.getSharedPreferences(CLOG_PREFERENCES, Activity.MODE_PRIVATE);
    }
}
