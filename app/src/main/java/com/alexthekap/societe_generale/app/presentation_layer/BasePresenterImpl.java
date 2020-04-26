package com.alexthekap.societe_generale.app.presentation_layer;

import io.reactivex.disposables.CompositeDisposable;

/**
 * created on 19.04.2020
 */
public class BasePresenterImpl<V> implements BasePresenter<V> {

    private V mView;
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Override
    public void wire(V view) {
        mView = view;
    }

    @Override
    public void unWire() {
        mView = null;
        compositeDisposable.clear();
    }

    protected V getView() {
        return mView;
    }

    protected CompositeDisposable getCompositeDisposable() {
        return compositeDisposable;
    }

}
