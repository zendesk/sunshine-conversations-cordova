package io.smooch.cordova;

import android.app.Application;

import io.smooch.core.Settings;
import io.smooch.core.Smooch;

public class SmoochApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        // Replace <your_app_token> with the token from https://app.smooch.io/
        Smooch.init(this, "<your_app_token>");
    }
}
