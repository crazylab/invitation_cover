package com.person;

public enum Gender {
    Male("Mr"),
    Female("Ms");

    private String prefix;

    Gender(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public String toString() {
        return name();
    }

    public String prefix(){
        return prefix;
    }
}