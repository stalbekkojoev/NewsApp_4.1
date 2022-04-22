package com.example.newsapp_41;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;

public class Prefs {

    private final SharedPreferences preferences;

    public Prefs(Context context) {
        preferences = context.getSharedPreferences("settings", Context.MODE_PRIVATE);
    }

    public void saveUserName(String name) {
        preferences.edit().putString("name", name).apply();
    }
    public String isUserName(){
        return preferences.getString("name", "");
    }
    public void saveImage(Uri uri){
        preferences.edit().putString("image", String.valueOf(uri)).apply();
    }
    public Uri isImage(){
        return Uri.parse(preferences.getString("image", ""));
    }
}
