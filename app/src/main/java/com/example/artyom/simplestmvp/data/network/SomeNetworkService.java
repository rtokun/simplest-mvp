package com.example.artyom.simplestmvp.data.network;

import com.example.artyom.simplestmvp.data.model.SomeData;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by artyom on 10/03/2018.
 */

public interface SomeNetworkService {

    @GET("/url_to_some_servoce")
    Call<SomeData> getSomeDataFromRemoteService();

}
