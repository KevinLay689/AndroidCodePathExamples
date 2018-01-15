package com.example.kevinlay.androidfundamentalspractice.dagger;

import android.app.Application;

import com.example.kevinlay.androidfundamentalspractice.dagger.component.DaggerNetComponent;
import com.example.kevinlay.androidfundamentalspractice.dagger.component.NetComponent;
import com.example.kevinlay.androidfundamentalspractice.dagger.module.AppModule;
import com.example.kevinlay.androidfundamentalspractice.dagger.module.NetModule;

/**
 * Created by kevinlay on 1/15/18.
 */

public class MyApp extends Application {

    private NetComponent mNetComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        // Dagger%COMPONENT_NAME%
        mNetComponent = DaggerNetComponent.builder()
                // list of modules that are part of this component need to be created here too
                .appModule(new AppModule(this)) // This also corresponds to the name of your module: %component_name%Module
                .netModule(new NetModule("https://api.github.com"))
                .build();

        // If a Dagger 2 component does not have any constructor arguments for any of its modules,
        // then we can use .create() as a shortcut instead:
        //  mNetComponent = com.codepath.dagger.components.DaggerNetComponent.create();
    }

    public NetComponent getNetComponent() {
        return mNetComponent;
    }
}
