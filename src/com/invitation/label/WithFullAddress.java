package com.invitation.label;

public class WithFullAddress implements Formatter {
    @Override
    public String generate(String city, String state, String country) {
        return String.format("%s, %s\n%s", city, state, country);
    }
}
