package com.binarapps.android.cookielogger;

import android.content.Context;

/**
 * Created by Cookie on 25.08.2017.
 */

class AppContext {

    private Context context;
    private static AppContext appContext = null;

    private AppContext(Context context) {
        this.context = context;
    }

    protected static void initialize(Context context) {
        appContext = new AppContext(context);
    }

    protected static Context getInstance() throws NullPointerException {
        if(appContext == null) {
            throw new NullPointerException("CLog wasn't initialized");
        }
        return appContext.context;
    }
}
