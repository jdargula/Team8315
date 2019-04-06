package com.example.notam;

public class Coords {
    private Object lat;
    private Object lng;
    Coords(Object lat, Object lng) {
        this.lat = lat;
        this.lng = lng;
    }
    void setLat(Object lat) {
        this.lat = lat;
    }
    Object getLat() {
        return lat;
    }
    void setLng(Object lng) {
        this.lng = lng;
    }
    Object getLng() {
        return lng;
    }
}
