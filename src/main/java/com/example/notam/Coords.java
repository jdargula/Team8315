package com.example.notam;

public class Coords {
    private Double lat;
    private Double lng;
    Coords(Double lat, Double lng) {
        this.lat = lat;
        this.lng = lng;
    }
    void setLat(Double lat) {
        this.lat = lat;
    }
    Double getLat() {
        return lat;
    }
    void setLng(Double lng) {
        this.lng = lng;
    }
    Double getLng() {
        return lng;
    }
}
