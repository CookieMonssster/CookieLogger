package com.binarapps.android.cookielogger;

import android.content.Context;

import com.binarapps.android.cookielogger.interfaces.CLogInterface;

/**
 * Created by Cookie on 25.08.2017.
 */

public class AppContext {

    protected Context context;
    protected CLogInterface send;
    protected String tag;
    protected boolean logToLogcat;

    private static AppContext instance = null;

    private AppContext(Context context, CLogInterface send) {
        this.context = context;
        this.send = send;
        this.tag = CLog.TAG;
        this.logToLogcat = false;
    }

    private AppContext(Context context, CLogInterface send, boolean logToLogcat) {
        this.context = context;
        this.send = send;
        this.logToLogcat = logToLogcat;
        this.tag = CLog.TAG;
    }

    private AppContext(Context context, CLogInterface send, String tag) {
        this.context = context;
        this.send = send;
        this.tag = tag;
        this.logToLogcat = true;
    }

    protected static void initialize(Context context, CLogInterface send, String tag) {
        instance = new AppContext(context, send, tag);
    }

    protected static AppContext getInstance() {
        if(instance == null) {
            throw new NullPointerException("You need to initialize CLog first");
        }
        return instance;
    }

}
