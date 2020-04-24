package com.alexthekap.societe_generale.app.di.module;

import com.alexthekap.societe_generale.app.network.api.AskGeoComApi;
import com.google.gson.Gson;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * created on 23.04.2020 15:41
 */
@Module
public class NetworkModule {

    private final String askGeoComUrl;

    public NetworkModule(String askGeoComUrl) {
        this.askGeoComUrl = askGeoComUrl;
    }

    @Provides
    @Singleton
    NetworkModule providesNetworkModule() {
        return this;
    }

    @Provides
    @Singleton
    Gson providesGson() {
        return new Gson().newBuilder().create();
    }

    @Provides
    @Singleton
    OkHttpClient providesOkHttpClient() {
        OkHttpClient.Builder okHttpBuilder = new OkHttpClient.Builder();
        return okHttpBuilder.build();
    }

    @Provides
    @Singleton
    Retrofit.Builder providesRetrofitBuilder() {
        return new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create());
    }

    @Named("AskGeoCom")
    @Provides
    @Singleton
    Retrofit providesAskGeoComRetrofit(Retrofit.Builder retrofitBuilder,
                                       OkHttpClient okHttpClient,
                                       Gson gson) {
        return retrofitBuilder
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(askGeoComUrl)
                .build();
    }

    @Provides
    @Singleton
    AskGeoComApi provideAskGeoComApi(@Named("AskGeoCom") Retrofit retrofit) {
        return retrofit.create(AskGeoComApi.class);
    }
}
