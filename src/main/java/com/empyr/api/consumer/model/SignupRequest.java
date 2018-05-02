package com.empyr.api.consumer.model;

public class SignupRequest extends AuthenticatedRequest {

    private boolean sendNotifications;
    private boolean generatePassword;
    private User user;
    private BillingDetail billingDetail;

    public boolean getSendNotifications() {
        return sendNotifications;
    }

    public void setSendNotifications(boolean sendNotifications) {
        this.sendNotifications = sendNotifications;
    }

    public boolean getGeneratePassword() {
        return generatePassword;
    }

    public void setGeneratePassword(boolean generatePassword) {
        this.generatePassword = generatePassword;
    }

    public void setUser(User user) { this.user = user; }

    public User getUser() { return user; }

    public BillingDetail getBillingDetail() {
        return billingDetail;
    }

    public void setBillingDetail(BillingDetail billingDetail) {
        this.billingDetail = billingDetail;
    }

}
