package com.guest;

public enum Gender {
    MALE("Mr"),
    FEMALE("Ms");

    private String title;

    Gender(String title) {
        this.title = title;
    }

    public String getHonorific(){
        return title;
    }
}