package com.example.artyom.simplestmvp;

import android.app.Application;
import android.content.Context;
import android.preference.PreferenceManager;

import com.example.artyom.simplestmvp.data.database.LocalDatabase;
import com.example.artyom.simplestmvp.data.database.LocalDatabaseImpl;
import com.example.artyom.simplestmvp.data.network.SomeNetworkService;
import com.example.artyom.simplestmvp.data.network.WeatherNetworkService;
import com.google.gson.Gson;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by artyom on 09/03/2018.
 * This is the main class that holds all Singletons
 */

public class Injector implements SingletonsProvider {

    private static final Injector ourInstance = new Injector();

    private Context mAppContext;

    private SomeNetworkService mNetworkService;

    private WeatherNetworkService mWeatherNetworkService;

    private LocalDatabase mLocalDatabase;

    private Gson mGson;

    private Injector() {
    }

    public static Injector getInstance() {
        return ourInstance;
    }

    public void init(Application application) {
        mAppContext = application.getApplicationContext();
    }

    @Override
    public LocalDatabase getLocalDatabase() {
        if (mLocalDatabase == null) {
            mLocalDatabase = initLocalDatabase();
        }
        return mLocalDatabase;
    }

    private LocalDatabase initLocalDatabase() {
        return new LocalDatabaseImpl(PreferenceManager.getDefaultSharedPreferences(mAppContext),
                getGson());
    }

    @Override
    public SomeNetworkService getSomeNetworkService() {
        if (mNetworkService == null) {
            mNetworkService = initNetworkService();
        }

        return mNetworkService;
    }

    @Override
    public WeatherNetworkService getWeatherNetworkService() {
        if (mWeatherNetworkService == null) {
            mWeatherNetworkService = initWeatherService();
        }

        return mWeatherNetworkService;
    }

    private WeatherNetworkService initWeatherService() {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(getGson()))
                .baseUrl("https://weather_base_url.com/")
                .client(new OkHttpClient.Builder().build())
                .build()
                .create(WeatherNetworkService.class);
    }

    private SomeNetworkService initNetworkService() {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(getGson()))
                .baseUrl("https://some_base_url.com/")
                .client(new OkHttpClient.Builder().build())
                .build()
                .create(SomeNetworkService.class);
    }

    public Gson getGson() {
        if (mGson == null) {
            mGson = new Gson();
        }

        return mGson;
    }

}
