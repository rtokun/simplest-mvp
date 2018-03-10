package com.example.artyom.simplestmvp;

import android.app.Application;

/**
 * Created by artyom on 09/03/2018.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initSingletons();
    }

    private void initSingletons() {
        Injector.getInstance()
                .init(this);
    }
}
