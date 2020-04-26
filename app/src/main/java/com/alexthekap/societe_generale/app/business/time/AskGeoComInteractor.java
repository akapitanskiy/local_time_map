package com.alexthekap.societe_generale.app.business.time;

import com.alexthekap.societe_generale.app.network.api.AskGeoComApi;
import com.alexthekap.societe_generale.app.network.responses.AskGeoComResponse;
import com.google.android.gms.maps.model.LatLng;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

/**
 * created on 20.04.2020
 */
@Singleton
public class AskGeoComInteractor {

    private final AskGeoComApi askGeoComApi;

    @Inject
    public AskGeoComInteractor(AskGeoComApi askGeoComApi) {
        this.askGeoComApi = askGeoComApi;
    }

    public Single<AskGeoComResponse> getTime(LatLng latLng) {
        return askGeoComApi.getPlayerInfoUsingGET("TimeZone", latLng.latitude + "," + latLng.longitude);
    }
}
