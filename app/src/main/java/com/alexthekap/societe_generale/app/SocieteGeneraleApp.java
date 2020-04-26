package com.alexthekap.societe_generale.app;

import android.app.Application;

import com.alexthekap.societe_generale.app.di.DaggerApplicationComponent;
import com.alexthekap.societe_generale.app.di.Injector;
import com.alexthekap.societe_generale.app.di.module.NetworkModule;

/**
 * created on 20.04.2020
 */
public class SocieteGeneraleApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initDagger();
    }

    private void initDagger() {
        Injector.INSTANCE.initAppComponent(
                DaggerApplicationComponent.builder()
                        .networkModule(new NetworkModule(BaseConst.ASK_GEO_COM_BASE_URL))
                        .build()
        );
    }
}
