package com.manairoverseas.model;

import android.widget.ImageView;

public class VisaType {
    String visaDesc;
    int visaType;


    public VisaType(String visaDesc, int visaType) {
        this.visaDesc = visaDesc;
        this.visaType = visaType;
    }

    public String getVisaDesc() {
        return visaDesc;
    }

    public void setVisaDesc(String visaDesc) {
        this.visaDesc = visaDesc;
    }

    public int getVisaType() {
        return visaType;
    }

    public void setVisaType(int visaType) {
        this.visaType = visaType;
    }
}
