package com.example.nosick3;

public class Info {
    String recovered;
    String deaths;
    String confirmed;

    public Info(String recovered, String deaths, String confirmed) {
        this.recovered = recovered;
        this.deaths = deaths;
        this.confirmed = confirmed;
    }

    public String getRecovered() {
        return recovered;
    }

    public void setRecovered(String recovered) {
        this.recovered = recovered;
    }

    public String getDeaths() {
        return deaths;
    }

    public void setDeaths(String deaths) {
        this.deaths = deaths;
    }

    public String getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(String confirmed) {
        this.confirmed = confirmed;
    }

    @Override
    public String toString() {
        return "Info{" +
                "recovered='" + recovered + '\'' +
                ", deaths='" + deaths + '\'' +
                ", confirmed='" + confirmed + '\'' +
                '}';
    }
}
