package com.binarapps.android.cookielogger;

import android.content.Context;

import com.binarapps.android.cookielogger.interfaces.CLogInterface;

/**
 * Created by Cookie on 25.08.2017.
 */

class AppContext {

    protected Context context;
    protected CLogInterface send;
    private static AppContext appContext = null;

    private AppContext(Context context, CLogInterface send) {
        this.context = context;
        this.send = send;
    }

    public static void initialize(Context context, CLogInterface send) {
        appContext = new AppContext(context, send);
    }

    protected static AppContext getInstance() throws NullPointerException {
        if(appContext == null) {
            throw new NullPointerException("CLog wasn't initialized");
        }
        return appContext;
    }
}
