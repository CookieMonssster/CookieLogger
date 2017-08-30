package com.binarapps.android.cookielogger.defs;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Cookie on 30.08.2017.
 */

@StringDef({StringKeys.VALUE_SEPARATOR})
@Retention(RetentionPolicy.SOURCE)
public @interface StringKeys {
    String VALUE_SEPARATOR = ": ";
}
