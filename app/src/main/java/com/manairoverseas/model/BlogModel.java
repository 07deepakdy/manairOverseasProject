package com.manairoverseas.model;

public class BlogModel {
    String mainheading,innerheading;

    public String getMainheading() {
        return mainheading;
    }

    public void setMainheading(String mainheading) {
        this.mainheading = mainheading;
    }

    public String getInnerheading() {
        return innerheading;
    }

    public void setInnerheading(String innerheading) {
        this.innerheading = innerheading;
    }

    public BlogModel(String mainheading, String innerheading) {
        this.mainheading = mainheading;
        this.innerheading = innerheading;
    }
}
