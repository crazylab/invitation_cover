package com.guest;

public class Name {
    private String first;

    private String last;

    public Name(String firstName, String lastName) {
        this.first = firstName;
        this.last = lastName;
    }

    public String getFirst(){
        return first;
    }

    public String getLast(){
        return last;
    }
}
