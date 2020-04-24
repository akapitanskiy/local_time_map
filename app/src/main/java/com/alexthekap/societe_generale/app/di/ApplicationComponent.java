package com.alexthekap.societe_generale.app.di;

import com.alexthekap.societe_generale.app.di.module.InteractorsModule;
import com.alexthekap.societe_generale.app.di.module.NetworkModule;
import com.alexthekap.societe_generale.app.presentation_layer.Map.MapsPresenter;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author Alexey Kapitanskiy created on 20.04.2020
 */

@Singleton
@Component(modules = {NetworkModule.class, InteractorsModule.class})
public interface ApplicationComponent {

//    MapsPresenter getMapsPresenter();

    void inject(MapsPresenter.Factory factory);
}
