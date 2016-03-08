package com.person;

public enum Gender {
    Male("Mr"),
    Female("Ms");

    private String title;

    private Gender(String title) {
        this.title = title;
    }

    public String getTitle(){
        return title;
    }
}