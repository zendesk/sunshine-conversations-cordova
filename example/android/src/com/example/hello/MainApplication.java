package com.example.hello;

import android.app.Application;

import io.smooch.core.Smooch;

/**
 * Created by edwardchan on 15-09-03.
 */
public class MainApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        // Initialize SupportKit with your app token
        // Get your own at https://app.supportkit.io/
        // and paste it here!
        Smooch.init(this, "alx94r0yp43vfhkekdszttbes");
    }
}