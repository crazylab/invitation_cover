package com.person;

public enum Gender {
    Male("Mr"),
    Female("Ms");

    private String title;

    Gender(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return name();
    }

    public String getTitle(){
        return title;
    }
}