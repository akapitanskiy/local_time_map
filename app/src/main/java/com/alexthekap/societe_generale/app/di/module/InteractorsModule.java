package com.alexthekap.societe_generale.app.di.module;

import com.alexthekap.societe_generale.app.business.time.AskGeoComInteractor;
import com.alexthekap.societe_generale.app.network.api.AskGeoComApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * created on 23.04.2020 19:39
 */
@Module
public class InteractorsModule {

    @Singleton
    @Provides
    AskGeoComInteractor providesAskGeoComInteractor(AskGeoComApi askGeoComApi) {
        return new AskGeoComInteractor(askGeoComApi);
    }
}
