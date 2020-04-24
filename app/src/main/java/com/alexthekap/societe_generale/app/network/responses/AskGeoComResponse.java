package com.alexthekap.societe_generale.app.network.responses;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * created on 22.04.2020 20:33
 */
public class AskGeoComResponse {
    @SerializedName("code")
    private int code;
    @SerializedName("message")
    private String message;
    @SerializedName("data")
    private List<GeoData> data = null;

    public int getCode() {
        return code;
    }
    // TODO проверить нужны ли сеттеры
    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public List<GeoData> getData() {
        return data;
    }
    public void setData(List<GeoData> data) {
        this.data = data;
    }
}
