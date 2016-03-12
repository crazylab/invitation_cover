package com.guest;

public class Age{
    private int age;

    public Age(int age) {
        this.age = age;
    }

    public boolean isOlderThan(int age) {
        return this.age > age;
    }
}
