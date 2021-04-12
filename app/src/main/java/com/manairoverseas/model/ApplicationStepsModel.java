package com.manairoverseas.model;

public class ApplicationStepsModel {
    String stepsNo;
    String steps;
    String status;
    String dated;

    public ApplicationStepsModel(String stepsNo, String steps, String status, String dated) {
        this.stepsNo = stepsNo;
        this.steps = steps;
        this.status = status;
        this.dated = dated;
    }

    public String getStepsNo() {
        return stepsNo;
    }

    public void setStepsNo(String stepsNo) {
        this.stepsNo = stepsNo;
    }

    public String getSteps() {
        return steps;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDated() {
        return dated;
    }

    public void setDated(String dated) {
        this.dated = dated;
    }
}
