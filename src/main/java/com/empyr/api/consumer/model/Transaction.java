package com.empyr.api.consumer.model;

public class Transaction {
    private int id;
    private double amount;
    private double cashbackAmount;
    private double cashbackBilled;
    private double referralFee;
    private long dateOfTransaction;
    private long rewardTime;
    private long dateProcessed;
    private Venue venue;
    private User user;
    private int cardId;
    private double clearingAmount;
    private double authorizationAmount;
    private String last4;
    private Redemption[] redemptions;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getCashbackAmount() {
        return cashbackAmount;
    }

    public void setCashbackAmount(double cashbackAmount) {
        this.cashbackAmount = cashbackAmount;
    }

    public double getCashbackBilled() {
        return cashbackBilled;
    }

    public void setCashbackBilled(double cashbackBilled) {
        this.cashbackBilled = cashbackBilled;
    }

    public double getReferralFee() {
        return referralFee;
    }

    public void setReferralFee(double referralFee) {
        this.referralFee = referralFee;
    }

    public long getDateOfTransaction() {
        return dateOfTransaction;
    }

    public void setDateOfTransaction(long dateOfTransaction) {
        this.dateOfTransaction = dateOfTransaction;
    }

    public long getRewardTime() {
        return rewardTime;
    }

    public void setRewardTime(long rewardTime) {
        this.rewardTime = rewardTime;
    }

    public long getDateProcessed() {
        return dateProcessed;
    }

    public void setDateProcessed(long dateProcessed) {
        this.dateProcessed = dateProcessed;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public double getClearingAmount() {
        return clearingAmount;
    }

    public void setClearingAmount(double clearingAmount) {
        this.clearingAmount = clearingAmount;
    }

    public double getAuthorizationAmount() {
        return authorizationAmount;
    }

    public void setAuthorizationAmount(double authorizationAmount) {
        this.authorizationAmount = authorizationAmount;
    }

    public String getLast4() {
        return last4;
    }

    public void setLast4(String last4) {
        this.last4 = last4;
    }

    public Redemption[] getRedemptions() {
        return redemptions;
    }

    public void setRedemptions(Redemption[] redemptions) {
        this.redemptions = redemptions;
    }
}
