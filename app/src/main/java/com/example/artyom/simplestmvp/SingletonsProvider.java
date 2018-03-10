package com.example.artyom.simplestmvp;

import com.example.artyom.simplestmvp.data.database.LocalDatabase;
import com.example.artyom.simplestmvp.data.network.SomeNetworkService;
import com.google.gson.Gson;

/**
 * Created by artyom on 10/03/2018.
 */

public interface SingletonsProvider {

    LocalDatabase getLocalDatabase();

    SomeNetworkService getSomeNetworkService();

    Gson getGson();

}
