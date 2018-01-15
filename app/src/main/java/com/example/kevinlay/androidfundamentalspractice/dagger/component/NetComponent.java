package com.example.kevinlay.androidfundamentalspractice.dagger.component;

import com.example.kevinlay.androidfundamentalspractice.dagger.Dagger2Activity;
import com.example.kevinlay.androidfundamentalspractice.dagger.module.AppModule;
import com.example.kevinlay.androidfundamentalspractice.dagger.module.NetModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by kevinlay on 1/15/18.
 */

@Singleton
@Component(modules={AppModule.class, NetModule.class})
public interface NetComponent {
    void inject(Dagger2Activity activity);
    // void inject(MyFragment fragment);
    // void inject(MyService service);
}
