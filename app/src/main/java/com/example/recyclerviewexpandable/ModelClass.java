package com.example.recyclerviewexpandable;

public class ModelClass {

    private String name;
    private boolean shouldShowImageview;

    public ModelClass(String name, boolean shouldShowImageview) {
        this.name = name;
        this.shouldShowImageview = shouldShowImageview;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isShouldShowImageview() {
        return shouldShowImageview;
    }

    public void setShouldShowImageview(boolean shouldShowImageview) {
        this.shouldShowImageview = shouldShowImageview;
    }

    @Override
    public String toString() {
        return "ModelClass{" +
                "name='" + name + '\'' +
                ", shouldShowImageview=" + shouldShowImageview +
                '}';
    }
}
