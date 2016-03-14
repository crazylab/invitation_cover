package com.invitation.label;


public class WithFullAddress implements Formatter {

    @Override
    public java.lang.String generate(String city, String state, String country) {
        return java.lang.String.format("%s, %s\n%s", city, state, country);
    }
}
