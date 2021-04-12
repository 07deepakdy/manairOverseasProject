package com.manairoverseas.model;

public class BlogModel {
    String mainheading;
    int innerheading;


    public BlogModel(String mainheading, int innerheading) {
        this.mainheading = mainheading;
        this.innerheading = innerheading;
    }

    public String getMainheading() {
        return mainheading;
    }

    public void setMainheading(String mainheading) {
        this.mainheading = mainheading;
    }

    public int getInnerheading() {
        return innerheading;
    }

    public void setInnerheading(int innerheading) {
        this.innerheading = innerheading;
    }
}
