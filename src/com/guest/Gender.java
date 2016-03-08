package com.guest;

public enum Gender {
    Male("Mr"),
    Female("Ms");

    private String title;

    Gender(String title) {
        this.title = title;
    }

    public String getTitle(){
        return title;
    }
}