package com.empyr.api.consumer.model;

public class Redemption {
    private int id;
    private String state;
    private long dateAdded;
    private double cashbackAmount;
    private double referralFee;
    private double qualifiedSpend;
    private int offerId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public long getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(long dateAdded) {
        this.dateAdded = dateAdded;
    }

    public double getCashbackAmount() {
        return cashbackAmount;
    }

    public void setCashbackAmount(double cashbackAmount) {
        this.cashbackAmount = cashbackAmount;
    }

    public double getReferralFee() {
        return referralFee;
    }

    public void setReferralFee(double referralFee) {
        this.referralFee = referralFee;
    }

    public double getQualifiedSpend() {
        return qualifiedSpend;
    }

    public void setQualifiedSpend(double qualifiedSpend) {
        this.qualifiedSpend = qualifiedSpend;
    }

    public int getOfferId() {
        return offerId;
    }

    public void setOfferId(int offerId) {
        this.offerId = offerId;
    }
}
