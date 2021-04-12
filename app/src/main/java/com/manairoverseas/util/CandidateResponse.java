package com.manairoverseas.util;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.manairoverseas.model.Candidatedetail;

public class CandidateResponse {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("candidatedetail")
    @Expose
    private Candidatedetail candidatedetail;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Candidatedetail getCandidatedetail() {
        return candidatedetail;
    }

    public void setCandidatedetail(Candidatedetail candidatedetail) {
        this.candidatedetail = candidatedetail;
    }

}