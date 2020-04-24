package com.alexthekap.societe_generale.app.network.responses;

import com.google.gson.annotations.SerializedName;

/**
 * created on 22.04.2020 20:35
 */
public class AskGeoComTimeZone {

    @SerializedName("IsInside")
    private String isInside;
    @SerializedName("AskGeoId")
    private int askGeoId;
    @SerializedName("MinDistanceKm")
    private int minDistanceKm;
    @SerializedName("TimeZoneId")
    private String timeZoneId;
    @SerializedName("ShortName")
    private String shortName;
    @SerializedName("CurrentOffsetMs")
    private int currentOffsetMs;
    @SerializedName("WindowsStandardName")
    private String windowsStandardName;
    @SerializedName("InDstNow")
    private String inDstNow;

    public String getIsInside() {
        return isInside;
    }
    public void setIsInside(String isInside) {
        this.isInside = isInside;
    }

    public int getAskGeoId() {
        return askGeoId;
    }
    public void setAskGeoId(int askGeoId) {
        this.askGeoId = askGeoId;
    }

    public int getMinDistanceKm() {
        return minDistanceKm;
    }
    public void setMinDistanceKm(int minDistanceKm) {
        this.minDistanceKm = minDistanceKm;
    }

    public String getTimeZoneId() {
        return timeZoneId;
    }
    public void setTimeZoneId(String timeZoneId) {
        this.timeZoneId = timeZoneId;
    }

    public String getShortName() {
        return shortName;
    }
    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public int getCurrentOffsetMs() {
        return currentOffsetMs;
    }
    public void setCurrentOffsetMs(int currentOffsetMs) {
        this.currentOffsetMs = currentOffsetMs;
    }

    public String getWindowsStandardName() {
        return windowsStandardName;
    }
    public void setWindowsStandardName(String windowsStandardName) {
        this.windowsStandardName = windowsStandardName;
    }

    public String getInDstNow() {
        return inDstNow;
    }
    public void setInDstNow(String inDstNow) {
        this.inDstNow = inDstNow;
    }
}
