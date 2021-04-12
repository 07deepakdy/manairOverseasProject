package com.manairoverseas.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Candidatedetail {

    @SerializedName("candidateid")
    @Expose
    private String candidateid;
    @SerializedName("application_number")
    @Expose
    private String applicationNumber;
    @SerializedName("full_name")
    @Expose
    private String fullName;
    @SerializedName("email_id")
    @Expose
    private String emailId;
    @SerializedName("phone_number")
    @Expose
    private String phoneNumber;

    public String getCandidateid() {
        return candidateid;
    }

    public void setCandidateid(String candidateid) {
        this.candidateid = candidateid;
    }

    public String getApplicationNumber() {
        return applicationNumber;
    }

    public void setApplicationNumber(String applicationNumber) {
        this.applicationNumber = applicationNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}