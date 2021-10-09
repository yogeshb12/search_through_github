package com.android.github.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class AppPreferences {

    private static Context mContext;
    private static SharedPreferences.Editor mEditor;
    private static SharedPreferences mSharedPreferences;

    public AppPreferences set(Context context, String preferences) {
        mContext = context;
        mSharedPreferences = getPreferences(preferences);
        mEditor = mSharedPreferences.edit();
        return this;
    }

    private SharedPreferences getPreferences(String preferences) {
        return mContext.getSharedPreferences(preferences, Context.MODE_PRIVATE);
    }

    public <T> AppPreferences setData(String key, T value) {

        Class primitiveClass = value.getClass();

        switch (primitiveClass.getSimpleName()) {
            case "String":
                mEditor.putString(key, value.toString());
                break;
            case "Integer":
                mEditor.putInt(key, (Integer) value);
                break;
            case "Float":
                mEditor.putFloat(key, (Float) value);
                break;
            case "Boolean":
                mEditor.putBoolean(key, (Boolean) value);
                break;
        }

        mEditor.commit();
        return this;
    }

    public static void clear(Context context) {
        mContext = context;
        mSharedPreferences = new AppPreferences().getPreferences(Constants.PREFERENCES);
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.clear();
        editor.apply();
    }
}