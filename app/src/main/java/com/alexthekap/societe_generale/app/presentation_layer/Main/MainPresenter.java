package com.alexthekap.societe_generale.app.presentation_layer.Main;

import com.alexthekap.societe_generale.app.presentation_layer.BasePresenterImpl;

/**
 * @author Alexey Kapitanskiy created on 19.04.2020
 */
public class MainPresenter extends BasePresenterImpl<MainContract.View> implements MainContract.Presenter {

    @Override
    public void onGoToMapClick() {
        getView().showMap();
    }
}
