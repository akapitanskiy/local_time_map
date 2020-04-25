package com.alexthekap.societe_generale.app.presentation_layer.Main;

import com.alexthekap.societe_generale.app.presentation_layer.BasePresenter;

/**
 * created on 19.04.2020
 */
public interface MainContract {

    interface View {
        void showMap();
    }

    interface Presenter extends BasePresenter<View> {
        void onGoToMapClick();
    }
}
