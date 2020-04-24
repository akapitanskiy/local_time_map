package com.alexthekap.societe_generale.app.network.api;

import com.alexthekap.societe_generale.app.network.responses.AskGeoComResponse;

import io.reactivex.Flowable;
import retrofit2.http.GET;

/**
 * created on 22.04.2020 22:19
 */
public interface AskGeoComApi {

    @GET("v1/2225/ce5b61a86ae56b379c7b29981ed35e1d587aff43c1d4b78d39be362c74a4a7f9/query.json")
    Flowable<AskGeoComResponse> getPlayerInfoUsingGET(
            @retrofit2.http.Query("databases") String databases,
            @retrofit2.http.Query("points") String points
    );
}
