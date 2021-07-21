package com.example.nosick3;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("recovered")
    @Expose
    private Integer recovered;
    @SerializedName("deaths")
    @Expose
    private Integer deaths;
    @SerializedName("confirmed")
    @Expose
    private Integer confirmed;
    @SerializedName("lastChecked")
    @Expose
    private String lastChecked;
    @SerializedName("lastReported")
    @Expose
    private String lastReported;
    @SerializedName("location")
    @Expose
    private String location;

    public Integer getRecovered() {
        return recovered;
    }

    public void setRecovered(Integer recovered) {
        this.recovered = recovered;
    }

    public Integer getDeaths() {
        return deaths;
    }

    public void setDeaths(Integer deaths) {
        this.deaths = deaths;
    }

    public Integer getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(Integer confirmed) {
        this.confirmed = confirmed;
    }

    public String getLastChecked() {
        return lastChecked;
    }

    public void setLastChecked(String lastChecked) {
        this.lastChecked = lastChecked;
    }

    public String getLastReported() {
        return lastReported;
    }

    public void setLastReported(String lastReported) {
        this.lastReported = lastReported;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
