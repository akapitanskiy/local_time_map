package com.alexthekap.societe_generale.app.network.responses;

import com.google.gson.annotations.SerializedName;

/**
 * created on 22.04.2020 19:57
 */
public class GeoData {

    @SerializedName("TimeZone")
    private AskGeoComTimeZone timeZone;

    public AskGeoComTimeZone getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(AskGeoComTimeZone timeZone) {
        this.timeZone = timeZone;
    }
}
