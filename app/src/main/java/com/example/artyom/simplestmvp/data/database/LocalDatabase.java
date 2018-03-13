package com.example.artyom.simplestmvp.data.database;

import com.example.artyom.simplestmvp.data.model.SomeData;

/**
 * Created by artyom on 10/03/2018.
 * This interface is just an abstraction of the local database capabilities.
 * Here we define all the possible interfaces for what should be implemented.
 */

public interface LocalDatabase {

    void saveSomeData(SomeData someDataToSave);

    SomeData getSomeData();

    // Here you continue to define all methods that local database can do
    // ..
    // ..

}
