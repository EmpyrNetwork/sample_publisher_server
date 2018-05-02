package com.empyr.api.consumer.model;

public class VenueSearchRequest {
    private String query;
    private String queryLocation;
    private String city;
    private String state;
    private double latitude;
    private double longitude;
    private int page;
    private int numResults;
    private boolean checkBookmarks;
    private String cities;
    private double distance;
    private String attributes;
    private String categories;
    private String features;
    private String ambiances;
    private String serves;
    private String priceRanges;
    private String bestNights;
    private double minRating;

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getQueryLocation() {
        return queryLocation;
    }

    public void setQueryLocation(String queryLocation) {
        this.queryLocation = queryLocation;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getNumResults() {
        return numResults;
    }

    public void setNumResults(int numResults) {
        this.numResults = numResults;
    }

    public boolean isCheckBookmarks() {
        return checkBookmarks;
    }

    public void setCheckBookmarks(boolean checkBookmarks) {
        this.checkBookmarks = checkBookmarks;
    }

    public String getCities() {
        return cities;
    }

    public void setCities(String cities) {
        this.cities = cities;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public String getAttributes() {
        return attributes;
    }

    public void setAttributes(String attributes) {
        this.attributes = attributes;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    public String getAmbiances() {
        return ambiances;
    }

    public void setAmbiances(String ambiances) {
        this.ambiances = ambiances;
    }

    public String getServes() {
        return serves;
    }

    public void setServes(String serves) {
        this.serves = serves;
    }

    public String getPriceRanges() {
        return priceRanges;
    }

    public void setPriceRanges(String priceRanges) {
        this.priceRanges = priceRanges;
    }

    public String getBestNights() {
        return bestNights;
    }

    public void setBestNights(String bestNights) {
        this.bestNights = bestNights;
    }

    public double getMinRating() {
        return minRating;
    }

    public void setMinRating(double minRating) {
        this.minRating = minRating;
    }
}
