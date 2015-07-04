package com.wisdomlanna.sharedpreferencesexample;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by AdminPond on 4/7/2558.
 */
public class LogUser {
    SharedPreferences pref;
    SharedPreferences.Editor editor;

    Context context;

    int PRIVATE_MODE = 0;
    private static final String PREF_NAME = "LogUser";
    public static final String KEY_NAME = "name";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_FLAG = "flagLogin";

    public String name;
    public String email;
    public boolean flagLogin;

    public LogUser(Context context) {
        this.context = context;
        pref = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void savePrf(String name, String email, boolean flag) {
        editor.putString(KEY_NAME, name);
        editor.putString(KEY_EMAIL, email);
        editor.putBoolean(KEY_FLAG, flag);
        editor.commit();
    }

    public void getPrf() {
        pref = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        name = pref.getString(KEY_NAME, "");
        email = pref.getString(KEY_EMAIL, "");
        flagLogin = pref.getBoolean(KEY_FLAG, false);
    }

    public void clearPrf() {
        editor.clear();
        editor.commit();
    }
}