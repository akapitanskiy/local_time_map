package com.alexthekap.societe_generale.app.di;

/**
 * created on 20.04.2020
 */
public enum Injector {
    INSTANCE;

    private ApplicationComponent appComponent;

    public void initAppComponent(ApplicationComponent appComponent) {
        this.appComponent = appComponent;
    }

    public ApplicationComponent getAppComponent() {
        return appComponent;
    }
}
