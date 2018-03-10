package com.example.artyom.simplestmvp.data.database;

import android.content.SharedPreferences;
import android.support.annotation.Nullable;

import com.example.artyom.simplestmvp.data.model.SomeData;
import com.google.gson.Gson;

/**
 * Created by artyom on 10/03/2018.
 * This class is an implementation of the local database interface abstraction. Here "under the hood"
 * the implementation of the methods can be done either by shared preferences, or by Room DataBase or any other
 * way.
 */

public class LocalDatabaseImpl implements LocalDatabase {

    public static final String SOME_DATA_KEY = "some_data";
    public static final String NOT_FOUND = "not_found";


    private final SharedPreferences mSharedPreferences;
    private final Gson mGson;

    public LocalDatabaseImpl(SharedPreferences sharedPreferences,
                             Gson gson) {
        this.mSharedPreferences = sharedPreferences;
        mGson = gson;
    }

    @Override
    public void saveSomeData(SomeData someDataToSave) {
        String serialized = mGson.toJson(someDataToSave);
        mSharedPreferences.edit()
                .putString(SOME_DATA_KEY, serialized)
                .apply();
    }

    @Override
    @Nullable
    public SomeData getSomeData() {
        String serialized = mSharedPreferences.getString(SOME_DATA_KEY, NOT_FOUND);

        if (!serialized.equals(NOT_FOUND)) {
            return mGson.fromJson(serialized, SomeData.class);
        }

        return null;
    }
}
