package com.alexthekap.societe_generale.app.presentation_layer;

/**
 * created on 19.04.2020
 */
public interface BasePresenter<V> {

    void wire(V view);

    void unWire();
}
