package com.alexthekap.societe_generale.app.presentation_layer.Map;

import com.alexthekap.societe_generale.app.presentation_layer.BasePresenter;
import com.google.android.gms.maps.model.LatLng;

/**
 * created on 19.04.2020
 */
public interface MapContract {

    interface View {

        void showTime(String time);

        void showLoading(boolean enable);

        void setClickable(boolean clickable);

        void onDataNotAvailable();
    }

    interface Presenter extends BasePresenter<View> {

        void onMapClick(LatLng latLng);
    }
}
