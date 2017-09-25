package io.smooch.cordova;

import android.app.Application;

import io.smooch.core.Settings;
import io.smooch.core.Smooch;
import io.smooch.core.SmoochCallback;

public class SmoochApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Smooch.init(this, new Settings("<your_app_id>"), new SmoochCallback() {
            @Override
            public void run(Response response) {
                // Your code after init is complete
            }
        });
    }
}
