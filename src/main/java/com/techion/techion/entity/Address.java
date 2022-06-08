package com.techion.techion.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// refer: https://jsonplaceholder.typicode.com/users

class GeoCoord {

    String lat;
    String lng;

    // constructors
    public GeoCoord() {}

    public GeoCoord(String lat, String lng) {
        this.lat = lat;
        this.lng = lng;
    }

    // getters and setters
    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    @Override
    public String toString() {
        return "GeoCoord{" +
                "lat='" + lat + '\'' +
                ", lng='" + lng + '\'' +
                '}';
    }

}

@JsonIgnoreProperties(ignoreUnknown = true)
public class Address {

    String street;
    String suite;
    String city;
    String zipcode;
    GeoCoord geo;

    // constructors
    public Address() {
    }

    public Address(String street, String suite, String city, String zipcode, GeoCoord geo) {
        this.street = street;
        this.suite = suite;
        this.city = city;
        this.zipcode = zipcode;
        this.geo = geo;
    }

    // getters and setters
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getSuite() {
        return suite;
    }

    public void setSuite(String suite) {
        this.suite = suite;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public GeoCoord getGeo() {
        return geo;
    }

    public void setGeo(GeoCoord geo) {
        this.geo = geo;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", suite='" + suite + '\'' +
                ", city='" + city + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", geo=" + geo +
                '}';
    }
}
