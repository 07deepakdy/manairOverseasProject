package com.manairoverseas.model;

public class VisaType {
    String visaType,visaDesc;

    public VisaType(String visaType, String visaDesc) {
        this.visaType = visaType;
        this.visaDesc = visaDesc;
    }

    public String getVisaType() {
        return visaType;
    }

    public void setVisaType(String visaType) {
        this.visaType = visaType;
    }

    public String getVisaDesc() {
        return visaDesc;
    }

    public void setVisaDesc(String visaDesc) {
        this.visaDesc = visaDesc;
    }
}
